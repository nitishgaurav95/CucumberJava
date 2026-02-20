package StepDefinition;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.testng.Assert.*;

import java.io.IOException;

import Base.BasePage;

public class JIRA_API_Steps {

    Response response;

    @Given("I call Jira issue API")
    public void call_jira_api() throws IOException{

        // -------- Read From Config File ----------
        String jiraUser  = BasePage.ReadDataFromProperties("jira.user");
        String jiraToken = BasePage.ReadDataFromProperties("jira.token");
        String jiraUrl = BasePage.ReadDataFromProperties("jira.base.url");
        String issueKey = "TES-7";

        response = RestAssured
                .given()
                .auth().preemptive()
                .basic(jiraUser, jiraToken)
                .baseUri(jiraUrl)
                .get("/rest/api/3/issue/" + issueKey);
    }

    @Then("status code should be {int}")
    public void check_status(int code){
        assertEquals(response.getStatusCode(), code);
    }
}
