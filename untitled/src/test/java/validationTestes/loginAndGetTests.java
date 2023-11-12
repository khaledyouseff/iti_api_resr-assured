package validationTestes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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
    }
    @Test
    public void validateResponseCode() {

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

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
    @Test
    public void ValidateResponseHeader() {
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

        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8");

    }
    @Test
    public void ValidateResponseBody() {
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

               response.then().assertThat().
                       body("id", equalTo(15))
                       .body("username", equalTo("kminchelle"))
                       .body("email", equalTo("kminchelle@qq.com"))
                       .body("firstName", equalTo("Jeanne"))
                       .body("lastName", equalTo("Halvorson"))
                       .body("gender", equalTo("female"))
                       .body("token", not(emptyOrNullString()));


    }
    @Test
    public void ValidateResponseTime() {
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

        response.then().time(lessThan(2000L));

    }


}
