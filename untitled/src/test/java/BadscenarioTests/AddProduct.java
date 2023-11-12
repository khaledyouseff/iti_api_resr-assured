package BadscenarioTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

@Test
public class AddProduct {
    public void validateResponseCode(){
        String requestBody = "{\n" +
                "    \"id\": \"13\",\n" +
                "    \"title\": \"bmw\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://dummyjson.com/products/add");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }
    @Test
    public void validateResponseBody(){
        String requestBody = "{\n" +
                "    \"id\": \"13\",\n" +
                "    \"title\": \"bmw\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://dummyjson.com/products/add");
        response.then().assertThat().
                body("id", equalTo(102)).and().
                body("title", equalTo("bmm"));
    }
    @Test
    public void validateResponseTime(){
        String requestBody = "{\n" +
                "    \"id\": \"13\",\n" +
                "    \"title\": \"bmw\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://dummyjson.com/products/add");
        response.then().time(lessThan(200L));
    }

    @Test
    public void validateResponsebodyIsJson(){
        String requestBody = "{\n" +
                "    \"id\": \"13\",\n" +
                "    \"title\": \"bmw\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .contentType(ContentType.HTML)
                .body(requestBody)
                .when()
                .post("https://dummyjson.com/products/add");
        response.then().contentType(ContentType.HTML);
    }
}
