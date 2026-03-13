package StepDefinition;
import io.cucumber.java.en.*;
//import io.cucumber.java.sl.In;
import io.restassured.response.Response;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.*;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

import model.AssignIssueRequest;
import model.CreateJiraRequest;
import model.UpdateIssueRequest;
import Utility.APIUtils;
import api.JiraApi;

public class Jira_API_Steps_Intermediate {

    Response newResponse;
    
    @Given("I call Jira missing mandatory fields API")
    public void I_call_Jira_missing_mandatory_fields_API() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CreateJiraRequest requestBody = mapper.readValue(new File("src/test/resources/payloads/missingMandatoryFields.json"), CreateJiraRequest.class);
         newResponse = JiraApi.createIssueWithoutMandatoryFields(requestBody);
         assertNotNull(newResponse);
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
    @Then("I should see the assignee as {string}")
    public void check_issue_assignee(String expectedAssignee) throws IOException {
        String actualAssignee = newResponse.jsonPath().getString("fields.assignee.displayName");
        if (!actualAssignee.equals(expectedAssignee)) {
            throw new AssertionError("Expected assignee " + expectedAssignee + " but got " + actualAssignee);
        }
    }
    @When("I get the issue details for issue with {string}")
    public void get_issue_details(String issueKey) throws IOException {
                newResponse = APIUtils.getRequestSpec()
                .get("/rest/api/3/issue/" + issueKey);
    }
    @Then("the status code should be {int}")
    public void check_status_code(int expectedStatusCode) {

        int actual = newResponse.getStatusCode();

        if (actual != expectedStatusCode) {
            throw new AssertionError("Expected status code " + expectedStatusCode + " but got " + actual);
        }
    }
    @Then("I verify the issue status is {string}")
    public void verify_issue_status(String expectedStatus) {

        String actualStatus = newResponse.jsonPath().getString("fields.status.name");

        if (!actualStatus.equals(expectedStatus)) {
            throw new AssertionError("Expected status " + expectedStatus + " but got " + actualStatus);
        }
    }
    @Then("I should see the transition status as {string}")
    public void verify_transition_status(String expectedTransition) {

        String actualStatus = newResponse.jsonPath().getString("fields.status.name");

        if (!actualStatus.equals(expectedTransition)) {
            throw new AssertionError("Expected transition " + expectedTransition + " but got " + actualStatus);
        }
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

    @Given("I call Jira transition API for issue with {string} to transition {string}")
    public void I_call_Jira_transition_API_for_issue_with_to_transition(String issueKey, String transitionName) throws IOException {
        Response transitionsResponse = APIUtils.getRequestSpec()
            .get("/rest/api/3/issue/" + issueKey + "/transitions");
        String transitionId = transitionsResponse.jsonPath()    
            .getString("transitions.find { it.name == '" + transitionName + "' }.id");
        if (transitionId == null) {
            throw new AssertionError("Transition '" + transitionName + "' not available for issue " +   issueKey);  
        }
        Map<String, Object> requestBody = Map.of("transition", Map.of("id", transitionId));
        newResponse = APIUtils.getRequestSpec()
            .body(requestBody)
            .post("/rest/api/3/issue/" + issueKey + "/transitions");
            newResponse.then().log().all();
              }

    @Given("I call Jira assign issue API for issue with {string} to assign to user {string}")
    public void I_call_Jira_assign_issue_API_for_issue_with_to_assign_to_user(String issueKey, String assigneeName) {
        ObjectMapper mapper = new ObjectMapper();
        try{
        AssignIssueRequest requestBody = mapper.readValue(new File("src/test/resources/payloads/assignee.json"), AssignIssueRequest.class);
        newResponse = APIUtils.getRequestSpec()
                    .body(requestBody)
                    .put("/rest/api/3/issue/" + issueKey + "/assignee");
                   newResponse.then().log().all();
   }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
