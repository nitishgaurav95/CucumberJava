package Utility;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import Base.BasePage;

public class APIUtils {

    public static RequestSpecification getRequestSpec() throws IOException {

        String jiraUser  = BasePage.ReadDataFromProperties("jira.user");
        String jiraToken = BasePage.ReadDataFromProperties("jira.token");
        String jiraUrl   = BasePage.ReadDataFromProperties("jira.base.url");

        return RestAssured
                .given()
                .auth().preemptive().basic(jiraUser, jiraToken)
                .baseUri(jiraUrl)
                .header("Content-Type", "application/json");
    }
}