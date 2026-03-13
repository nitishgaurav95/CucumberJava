package Utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import Base.BasePage;

public class APIUtils {

    public static RequestSpecification getRequestSpec() throws IOException {

        String jiraUser  = BasePage.ReadDataFromProperties("jira.user");
        String jiraToken = BasePage.ReadDataFromProperties("jira.token");
        String jiraUrl   = BasePage.ReadDataFromProperties("jira.base.url");

        return RestAssured
                .given()
                .log().all()
                .baseUri(jiraUrl)
                .auth().preemptive().basic(jiraUser, jiraToken)
                .header("Content-Type", "application/json");
    }
    public static RequestSpecification getUnauthenticatedRequestSpec() throws IOException {    
        String jiraUrl   = BasePage.ReadDataFromProperties("jira.base.url");

        return RestAssured
                .given()
                .log().all()
                .baseUri(jiraUrl)
                .header("Content-Type", "application/json");
    }

    public static Map<String, Object> buildCreateIssueRequestBody(String summary, String description) throws IOException {

    String projectKey = BasePage.ReadDataFromProperties("jira.project.key");

    String issueType = BasePage.ReadDataFromProperties("jira.issue.type");

    if (projectKey == null || projectKey.isEmpty()) {
        throw new RuntimeException("jira.project.key is missing in Config.properties");
    }

    Map<String, Object> descriptionBody = Map.of(
            "type", "doc",
            "version", 1,
            "content", List.of(
                    Map.of(
                            "type", "paragraph",
                            "content", List.of(
                                    Map.of(
                                            "type", "text",
                                            "text", description
                                    )
                            )
                    )
            )
    );
    return Map.of(
            "fields", Map.of(
                    "project", Map.of("key", projectKey),
                    "summary", summary,
                    "description", descriptionBody,
                    "issuetype", Map.of("name", "" + issueType + "")
            )
    );
}


    public static void validateJsonSchema(Response response, String s) {
        try {
            String schemaPath = "src/test/resources/Schemas/" + s;
            response.then().assertThat().body(io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
        } catch (Exception e) {
            throw new RuntimeException("Failed to validate JSON schema: " + e.getMessage(), e);
        }
    }
}
   