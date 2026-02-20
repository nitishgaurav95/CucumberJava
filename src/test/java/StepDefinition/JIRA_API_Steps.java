package StepDefinition;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static org.testng.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Utility.APIUtils;

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
    
}   
