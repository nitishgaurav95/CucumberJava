package Utility;

import java.io.File;
import java.io.IOException;

import Base.BasePage;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class FileUploadUtil {
    public static RequestSpecification getMultipartRequestSpec() throws IOException {

    String jiraUser  = BasePage.ReadDataFromProperties("jira.user");
    String jiraToken = BasePage.ReadDataFromProperties("jira.token");
    String jiraUrl   = BasePage.ReadDataFromProperties("jira.base.url");

    return RestAssured
            .given()
            .log().all()
            .baseUri(jiraUrl)
            .auth().preemptive().basic(jiraUser, jiraToken)
            .header("X-Atlassian-Token", "no-check"); // required for Jira attachment
}
public static File getFile(String fileName) {
    return new File(System.getProperty("user.dir")
            + "/src/test/resources/files/" + fileName);
}
}
