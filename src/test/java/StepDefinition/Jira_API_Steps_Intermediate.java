package StepDefinition;
import io.cucumber.java.en.*;
//import io.cucumber.java.sl.In;
import io.restassured.response.Response;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.*;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

import model.AssignIssueRequest;
import model.CreateJiraRequest;
import model.UpdateIssueRequest;
import Utility.APIUtils;
import api.JiraApi;

public class Jira_API_Steps_Intermediate {

    Response newResponse;
    private String issueKey;

    @Given("I call Jira missing mandatory fields API")
    public void I_call_Jira_missing_mandatory_fields_API() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CreateJiraRequest requestBody = mapper.readValue(new File("src/test/resources/payloads/missingMandatoryFields.json"), CreateJiraRequest.class);
         newResponse = JiraApi.createIssueWithoutMandatoryFields(requestBody);
         assertNotNull(newResponse);
    }
    @Then("the status code should be {int}")
    public void check_status_code(int code){
           assertEquals(newResponse.getStatusCode(), code);
    }
    @Given("I call Jira invalid API for issue with {string}")
    public void I_call_Jira_invalid_API_for_issue_with(String s) {
            newResponse = JiraApi.getIssueWithInvalidEndpoint(s);
            assertNotNull(newResponse);
    }
    @Then("I should see the exact error message as {string}")
    public void I_should_see_the_exact_error_message_as(String s) {
        String actualErrorMessage = newResponse.jsonPath().getString("errorMessages[0]");
        assertEquals(actualErrorMessage, s);
    }
    @Given("I call Jira assign API for issue with {string} to user {string}")
    public void I_call_Jira_assign_API_for_issue_with_to_user_with(String issueKey, String assigneeName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AssignIssueRequest requestBody = mapper.readValue(new File("src/test/resources/payloads/assignee.json"), AssignIssueRequest.class);
        newResponse = APIUtils.getRequestSpec()
                    .body(requestBody)
                    .put("/rest/api/3/issue/" + issueKey + "/assignee");
                    newResponse.then().statusCode(204);
    }
    @Then("I should see the assignee as {string}")
    public void check_issue_assignee(String expectedAssignee) throws IOException {
        Response getResponse = APIUtils.getRequestSpec()
            .get("/rest/api/3/issue/" + issueKey);
            String actualAssignee = getResponse.jsonPath()
                    .getString("fields.assignee.displayName");
                     assertEquals(actualAssignee, expectedAssignee);
        
    }
    @Given("I call Jira transition issue API for issue with {string} to status {string}")
    public void I_call_Jira_transition_issue_API_for_issue_with_to_status(String issueKey, String status) throws IOException {
        newResponse = APIUtils.getRequestSpec()
                   .get("/rest/api/3/issue/" + issueKey + "/transitions");
    }
    @Then("I should see the status as {int}")
    public void check_issue_status(int expectedStatus) {
       assertNotNull("Response is null. API call failed.", newResponse);
        assertEquals(expectedStatus, newResponse.getStatusCode());
    }
    @Then("I should see the transition status as {string}")
    public void check_transition_status(String expectedStatus) {
        String actualStatus = newResponse.jsonPath().getString("transitions[0].name");
        assertEquals(expectedStatus, actualStatus);
    }
    @Given("I call Jira update issue API for issue with {string} without proper authentication")
    public void I_call_Jira_update_issue_API_for_issue_with_without_proper_authentication(String issueKey) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        UpdateIssueRequest requestBody = mapper.readValue(new File("src/test/resources/payloads/update.json"), UpdateIssueRequest.class);
        newResponse = APIUtils.getUnauthenticatedRequestSpec()
                    .body(requestBody)
                    .put("/rest/api/3/issue/" + issueKey);       
    }
    @Then("I should see the error message as {string}")
    public void I_should_see_the_error_message_as(String expectedMessage) {
        String actualErrorMessage = newResponse.jsonPath().getString("errorMessages[0]");
        assertEquals(actualErrorMessage, expectedMessage);
    }
}