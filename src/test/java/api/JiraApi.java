package api;
import io.restassured.response.Response;
import model.CreateJiraRequest; 

public class JiraApi {

    public static <CreateJiraResponse> Response createIssue(CreateJiraRequest payload) {
        return ApiSpec.baseSpec()
                .body(payload)
            .when()
                .post("/rest/api/3/issue")
            .then()
                .statusCode(201).extract().response();
    }

    public static Response getIssue(CreateJiraRequest issueKey) {
        return ApiSpec.baseSpec()
            .when()
                .get("/rest/api/3/issue/" + issueKey.getFields().getProject().getKey() + "-" + issueKey.getFields().getSummary())
            .then()
                .statusCode(200).extract().response();
    }

    public static Response assignIssue(String issueKey, String assigneeName) {
        String payload = "{\"name\": \"" + assigneeName + "\"}";
        return ApiSpec.baseSpec()
            .body(payload)
            .when()
                .put("/rest/api/3/issue/" + issueKey + "/assignee")
            .then()         
                .statusCode(204).extract().response();
    }

    public static Response createIssueWithoutMandatoryFields(CreateJiraRequest requestBody) {
        return ApiSpec.baseSpec()
            .body(requestBody)
            .when()
                .post("/rest/api/3/issue")
            .then()
                .statusCode(400).extract().response();  
    }

    public static Response getIssueWithInvalidEndpoint(String s) {
        return ApiSpec.baseSpec()
            .when()
                .get("/rest/api/3/invalidEndpoint/" + s)
            .then()
                .statusCode(404).extract().response();
    }

    public static Response updateIssueWithoutPermission(CreateJiraRequest requestBody, String issueKey) {
        return ApiSpec.baseSpec()
            .body(requestBody)
            .when()
                .put("/rest/api/3/issue/" + issueKey)
            .then()
                .statusCode(404).extract().response();
    }
}

