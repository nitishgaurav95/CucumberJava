package Utility;
<<<<<<< HEAD
=======

>>>>>>> d7135bbe19bcf7b674b8c2298da3ddf2f27c9fc9
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
<<<<<<< HEAD
import java.util.Map;
=======
>>>>>>> d7135bbe19bcf7b674b8c2298da3ddf2f27c9fc9

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
<<<<<<< HEAD

    public static RequestSpecification getUnauthenticatedRequestSpec() throws IOException {    
        String jiraUrl   = BasePage.ReadDataFromProperties("jira.base.url");

        return RestAssured
                .given()
                .baseUri(jiraUrl)
                .header("Content-Type", "application/json");
    }

    public static Map<String, Object> buildCreateIssueRequestBody(String summary, String description) {
        return Map.of(
                "fields", Map.of(
                        "project", Map.of("key", "TEST"),
                        "summary", summary,
                        "description", description,
                        "issuetype", Map.of("name", "Task")
                )
        );  
   } 
}
=======
}
>>>>>>> d7135bbe19bcf7b674b8c2298da3ddf2f27c9fc9
