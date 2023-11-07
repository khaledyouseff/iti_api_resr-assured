package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class loginAndGetTests {
    @Test
    public void createLoginPostRequest() {
        // Create a JSON request body
        String requestBody = "{\n" +
                "    \"username\": \"kminchelle\",\n" +
                "    \"password\": \"0lelplR\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://dummyjson.com/auth/login");

        // Validate response code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }


}
