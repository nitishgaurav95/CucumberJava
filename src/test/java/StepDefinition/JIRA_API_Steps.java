package StepDefinition;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static org.testng.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

import Utility.APIUtils;
import pojo.JiraCommentRequest;

public class JIRA_API_Steps {  

    Response response;

    @Given("I call Jira issue API for issue {string}")
    public void I_call_Jira_issue_API_for_issue(String issueID) throws IOException {
        response = APIUtils.getRequestSpec()
                   .get("/rest/api/3/issue/" + issueID);
    }

    @Then("status code should be {int}")
    public void check_status(int code){
        assertEquals(response.getStatusCode(), code);
    }

    @Given("I call Jira create issue API")
    public void I_call_Jira_create_issue_API() throws IOException {
        String payload = new String(
    Files.readAllBytes(Paths.get("src/test/resources/payloads/createIssue.json")));
        response = APIUtils.getRequestSpec()
                   .body(payload)
                   .post("/rest/api/3/issue");
    }

    @Given("I add comment {string} to Jira issue {string}")
    public void i_add_comment_to_jira_issue(String commentText, String issueKey) throws IOException {
        JiraCommentRequest.Text text = new JiraCommentRequest.Text("text", commentText);
        JiraCommentRequest.Content content = new JiraCommentRequest.Content("paragraph", Collections.singletonList(text));
        JiraCommentRequest.Body body = new JiraCommentRequest.Body("doc", 1, Collections.singletonList(content));
        JiraCommentRequest payload = new JiraCommentRequest(body);

        response = APIUtils.getRequestSpec()
                .body(payload)
                .post("/rest/api/3/issue/" + issueKey + "/comment");
    }

    @Then("comment response should contain issue key {string}, id and self URL")
    public void comment_response_should_contain_issue_key_id_and_self_url(String issueKey) throws IOException {
        String id = response.jsonPath().getString("id");
        String self = response.jsonPath().getString("self");

        assertNotNull(id, "Expected comment id in response");
        assertFalse(id.trim().isEmpty(), "Comment id should not be empty");
        assertNotNull(self, "Expected self URL in response");
        assertFalse(self.trim().isEmpty(), "self URL should not be empty");
        assertTrue(self.contains("/comment/" + id),
                "Expected self URL to contain created comment id: " + id);

        Response issueCommentsResponse = APIUtils.getRequestSpec()
                .get("/rest/api/3/issue/" + issueKey + "/comment");
        assertEquals(issueCommentsResponse.getStatusCode(), 200,
                "Unable to fetch comments for issue: " + issueKey);

        String commentIds = issueCommentsResponse.jsonPath().getString("comments.id");
        assertTrue(commentIds != null && commentIds.contains(id),
                "Created comment id " + id + " not found under issue " + issueKey);
    }
    
}   
