package StepDefinition;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import Utility.APIUtils;
import Utility.FileUploadUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Jira_Advanced {

Response response;
String issueKey;
String saveKey;

@Given("I create a Jira issue with summary {string} and description {string}")
public void create_issue(String summary, String description) throws Exception {

    Map<String, Object> requestBody = APIUtils.buildCreateIssueRequestBody(summary, description);
        RequestSpecification spec = APIUtils.getRequestSpec()
                                            .body(requestBody);
        this.response = spec.when().post("/rest/api/3/issue");
        this.saveKey = this.response.jsonPath().getString("key");
}
@Then("status code of the response should be {int}")
public void validate_status_code(int expectedStatusCode) {
    if(this.response == null) {
            throw new IllegalStateException("Response is null. The previous step did not assign it.");
        }
        int status = this.response.getStatusCode();
        if (status != expectedStatusCode) {
            throw new AssertionError("Expected " + expectedStatusCode + ", got " + status + ". Body: " + response.asString());
        }
}
@Then("the issue key should be generated")
public void validate_issue_key() {
    if(this.response == null) {
            throw new IllegalStateException("Response is null. The previous step did not assign it.");
        }
        int status = this.response.getStatusCode();
        if (status != 201) {
            throw new AssertionError("Expected 201 Created, got " + status + ". Body: " + this.response.asString());
        }
        String key = this.response.jsonPath().getString("key");
        if (key == null || key.isEmpty()) {
            throw new AssertionError("Issue key missing in response: " + this.response.asString());
        }}

    @When("I add a comment {string} to the created issue")
    public void I_add_a_comment(String comment) throws IOException {    
            Map<String, Object> body = Map.of(
            "body", Map.of(
                    "type", "doc",
                    "version", 1,
                    "content", List.of(
                            Map.of(
                                    "type", "paragraph",
                                    "content", List.of(
                                            Map.of("type", "text", "text", comment)))))
    ); 
    response = APIUtils.getRequestSpec()
            .body(body)
            .post("/rest/api/3/issue/" + saveKey + "/comment");
}
    @When("I transition the created issue to {string}")
    public void I_transition_the_issue_to(String targetStatus) throws IOException {
            Response transitionsResponse = APIUtils.getRequestSpec()
            .get("/rest/api/3/issue/" + saveKey + "/transitions");
                        List<Map<String, Object>> transitions = transitionsResponse.jsonPath().getList("transitions");
                        String transitionId = null;

        for (Map<String, Object> transition : transitions) {
        if (transition.get("name").toString().equalsIgnoreCase(targetStatus)) {
            transitionId = transition.get("id").toString();
            break;
        }}
        if (transitionId == null) {
        throw new RuntimeException("Transition '" + targetStatus + "' not found.");
    }
        Map<String, Object> body = Map.of(
            "transition", Map.of("id", transitionId)
    );
        response = APIUtils.getRequestSpec()
            .body(body)
            .post("/rest/api/3/issue/" + saveKey + "/transitions");
}
    @When("I get the created issue")
    public void I_get_the_created_issue() throws IOException {
            response = APIUtils.getRequestSpec()
                .get("/rest/api/3/issue/" + saveKey);
    }
    @Then("the issue status should be {string}")
    public void the_issue_status_should_be(String expectedStatus) {
        String actualStatus = response.jsonPath().getString("fields.status.name");  
        if (!actualStatus.equals(expectedStatus)) {
            throw new AssertionError("Expected status: " + expectedStatus + ", but got: " + actualStatus);
        }}

    @When("I upload attachment {string}") 
    public void I_upload_attachment(String fileName) throws IOException {

    response = FileUploadUtil.getMultipartRequestSpec()
            .multiPart("file", FileUploadUtil.getFile(fileName))
            .post("/rest/api/3/issue/" + saveKey + "/attachments");
    }
    @Then("attachment name should be {string}")
    public void attachment_name_should_be(String attachment) {
        List<Map<String, Object>> attachments = response.jsonPath().getList("$");
        if (attachments == null || attachments.isEmpty()) {
            throw new AssertionError("No attachments found in response: " + response.asString());
        }
        String actualFileName = String.valueOf(attachments.get(0).get("filename"));
        if (!actualFileName.equals(attachment)) {
            throw new AssertionError("Expected attachment name: " + attachment + ", but got: " + actualFileName);
        }
    }
    @Then("response should match JSON schema {string}")
   public void response_should_match_JSON_schema(String schemaFile) {
            response
                 .then()
                 .log().ifValidationFails()
                 .assertThat()
                 .body(matchesJsonSchemaInClasspath("schema/" + schemaFile));
}
    @Then("response time should be less than {string} milliseconds")
    public void response_time_should_be_less_than_milliseconds(String s) {  
        long responseTime = response.getTime();
        long threshold = Long.parseLong(s);
        if (responseTime >= threshold) {
            throw new AssertionError("Expected response time less than " + threshold + " ms, but got " + responseTime + " ms");
        }
    }
}




