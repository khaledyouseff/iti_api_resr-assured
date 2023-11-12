package BadscenarioTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UpdateDataTest {
    @Test
    public void InvalidJSONRequestBody() {
        // Define the JSON request body for the update
        String requestBody =  "{\n" + "    \"khaled\": \"iPhone Galaxy +1\"}";


        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://dummyjson.com/products/1");

        response.then().statusCode(200);
        System.out.println("Response Body: " + response.getBody().asString());
        //bug
    }
    @Test
    public void nonExistedProduct() {
        // Define the JSON request body for the update
        String requestBody =  "{\n" + "    \"khaled\": \"iPhone Galaxy +1\"}";


        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://dummyjson.com/products/1511115");

        response.then().statusCode(200);
        System.out.println("Response Body: " + response.getBody().asString());
        //tamam
    }
    @Test
    public void MissingRequiredFields() {
        // Define the JSON request body for the update
        String requestBody =  "{}";


        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://dummyjson.com/products/1511115");

        response.then().statusCode(200);
        System.out.println("Response Body: " + response.getBody().asString());
        //tamam
    }

}
