package StepDefinition;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static org.testng.Assert.*;
<<<<<<< HEAD
=======

>>>>>>> d7135bbe19bcf7b674b8c2298da3ddf2f27c9fc9
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Utility.APIUtils;

public class JIRA_API_Steps {  

    Response response;

<<<<<<< HEAD
    @Given("I call Jira issue API for issue with {string}")
    public void I_call_Jira_issue_API_for_issue(String issueID) throws IOException {
        response = APIUtils.getRequestSpec()
                   .get("/rest/api/3/issue/" + issueID);
}
=======
    @Given("I call Jira issue API for issue {string}")
    public void I_call_Jira_issue_API_for_issue(String issueID) throws IOException {
        response = APIUtils.getRequestSpec()
                   .get("/rest/api/3/issue/" + issueID);
    }

>>>>>>> d7135bbe19bcf7b674b8c2298da3ddf2f27c9fc9
    @Then("status code should be {int}")
    public void check_status(int code){
        assertEquals(response.getStatusCode(), code);
    }
<<<<<<< HEAD
    @Then("I should see the issue as {string}")
    public void check_issue_summary(String expectedSummary) {
        String actualSummary = response.jsonPath().getString("fields.summary");
        assertEquals(actualSummary, expectedSummary);
    }
=======

>>>>>>> d7135bbe19bcf7b674b8c2298da3ddf2f27c9fc9
    @Given("I call Jira create issue API")
    public void I_call_Jira_create_issue_API() throws IOException {
        String payload = new String(
    Files.readAllBytes(Paths.get("src/test/resources/payloads/createIssue.json")));
        response = APIUtils.getRequestSpec()
                   .body(payload)
                   .post("/rest/api/3/issue");
    }
<<<<<<< HEAD
    @Then("I should see the reporter as {string}")
    public void check_issue_reporter(String expectedReporter) {
        String actualReporter = response.jsonPath().getString("fields.reporter.displayName");
        assertEquals(actualReporter, expectedReporter);
    }
    @Given("I call Jira add comment API for issue with {string}")
    public void I_call_Jira_add_comment_API_for_issue_with(String issueID) throws IOException { 
        String payload = new String(
    Files.readAllBytes(Paths.get("src/test/resources/payloads/comment.json")));      
        response = APIUtils.getRequestSpec()
                   .body(payload)
                   .post("/rest/api/3/issue/" + issueID + "/comment");
    }
    @Then("I should see the comment as {string}")
    public void check_comment_content(String expectedCommentContent) {
        String actualCommentContent = response.jsonPath().getString("body.content[0].content[0].text");
        assertEquals(actualCommentContent, expectedCommentContent);
    }
    @Given("I call Jira update API for issue with {string}")
    public void I_call_Jira_update_API_for_issue_with(String issueID) throws IOException { 
        String payload = new String(
    Files.readAllBytes(Paths.get("src/test/resources/payloads/update.json")));      
        response = APIUtils.getRequestSpec()
                   .body(payload)
                   .put("/rest/api/3/issue/" + issueID);
    }   
    @Then("I should see the issue summary as {string} from {string}")
    public void I_should_see_the_issue_summary_as(String expectedSummary, String issueID) throws IOException {  
        // Fetch the issue details again to get the updated summary
        response = APIUtils.getRequestSpec()
                   .get("/rest/api/3/issue/" + issueID);
        String actualSummary = response.jsonPath().getString("fields.summary");
        assertEquals(actualSummary, expectedSummary);
    }
}
  
=======
    
}   
>>>>>>> d7135bbe19bcf7b674b8c2298da3ddf2f27c9fc9
