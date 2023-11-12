package validationTestes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class AddProduct {
    @Test
    public void addNewItem(){

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

    }
    @Test
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
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    public void validateRequestHeaders(){
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
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8");
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
                body("id", equalTo(101)).and().
                body("title", equalTo("bmw"));
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
        response.then().time(lessThan(5000L));
    }
    @Test
    public void validateResponsebodyIsJson(){
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
        response.then().contentType(ContentType.JSON);
    }
    }

