package validationTestes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateDataTest {

    @Test
    public void testPutRequest() {
        // Define the JSON request body for the update
        String requestBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"iPhone Galaxy +1\",\n" +
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

        // Send the PUT request and capture the response
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON).header("Content-Type", "application/json").
                header("Authorization" ,"Bearer /* eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTUsInVzZXJuYW1lIjoia21pbmNoZWxsZSIsImVtYWlsIjoia21pbmNoZWxsZUBxcS5jb20iLCJmaXJzdE5hbWUiOiJKZWFubmUiLCJsYXN0TmFtZSI6IkhhbHZvcnNvbiIsImdlbmRlciI6ImZlbWFsZSIsImltYWdlIjoiaHR0cHM6Ly9yb2JvaGFzaC5vcmcvYXV0cXVpYXV0LnBuZz9zaXplPTUweDUwJnNldD1zZXQxIiwiaWF0IjoxNjM1NzczOTYyLCJleHAiOjE2MzU3Nzc1NjJ9.n9PQX8w8ocKo0dMCw3g8bKhjB8Wo7f7IONFBDqfxKhs */")
                .body(requestBody)
                .when()
                .put("https://dummyjson.com/products/1");

        // Check the response status code (adjust to your expected code)
        response.then().statusCode(200); // Assuming a successful update returns 200

        // Validate the response body, e.g., check the updated "title"
        response.then().assertThat().body("title", equalTo("iPhone Galaxy +1"));
    }
}


