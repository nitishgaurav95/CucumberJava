package api;

import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;

public class ApiSpec {

    public static RequestSpecification baseSpec() {
        return given()
                .log().all()
                .baseUri("https://aparnashrihari1303.atlassian.net/")
                .header("X-API-KEY","test-key")
                .contentType("application/json");
    }    
    public static io.restassured.response.Response sendRequest(RequestSpecification requestSpec, String method, String endpoint) {
        switch (method.toUpperCase()) {
            case "GET":
                return requestSpec.when().get(endpoint);
            case "POST":
                return requestSpec.when().post(endpoint);
            case "PUT":
                return requestSpec.when().put(endpoint);
            case "DELETE":
                return requestSpec.when().delete(endpoint);
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }
    }
}
