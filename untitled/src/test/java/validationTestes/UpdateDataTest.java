package validationTestes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class UpdateDataTest {


    @Test
    public void validateResponseCode() {
        // Define the JSON request body for the update
        String requestBody =  "{\n" + "    \"title\": \"iPhone Galaxy +1\"}";


        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://dummyjson.com/products/1");

        // Assertions
        response.then().statusCode(200);
        System.out.println("Response Body: " + response.getBody().asString());
    }
    @Test
    public void validateResponseTime() {
        // Define the JSON request body for the update
        String requestBody =  "{\n" + "    \"title\": \"iPhone Galaxy +1\"}";


        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://dummyjson.com/products/1");

        // Assertions
        response.then().time(lessThan(2000L));
        System.out.println("Response Body: " + response.getBody().asString());
    }
    @Test
    public void validateUpdatedField() {
        // Define the JSON request body for the update
        String requestBody =  "{\n" + "    \"title\": \"iPhone Galaxy +1\"}";


        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://dummyjson.com/products/1");

        // Assertions
        response.then().assertThat().body("title",equalTo("iPhone Galaxy +1"));
        System.out.println("Response Body: " + response.getBody().asString());
    }

    }



