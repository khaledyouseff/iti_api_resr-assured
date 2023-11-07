package tests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import net.minidev.json.JSONObject;

public class updateData {
    @Test
    public void testPutRequest() {

        String requestBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"iPhone Galaxy +1\",\n " +
                "  \"description\": \"An apple mobile which is nothing like apple\",\n" +
                "  \"price\": 549,\n" +
                "  \"discountPercentage\": 12.96,\n" +
                "  \"rating\": 4.69,\n" +
                "  \"stock\": 94,\n" +
        "  \"brand\": \"Apple\",\n" +
                "  \"category\": \"smartphones\",\n" +
                "  \"thumbnail\": \"...\",\n" +
                "  \"images\": [\"...\", \"...\", \"...\"]\n" +
                "}";

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("https://dummyjson.com/products/1");


        // Check if the response status code is 200 (OK)
        response.then().statusCode(404);
        // Validate the updated title
       response.then().assertThat().body("title", equalTo("iPhone 9"));
    }
    @Test
    public void requestDetails() {
        given().
                log().all().
                when().
                put("https://dummyjson.com/products/1").
                then().
                log().body();
    }
}

