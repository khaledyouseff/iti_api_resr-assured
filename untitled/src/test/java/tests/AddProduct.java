package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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
        // Validate response code

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Validate response header

        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8");

        // validate response body
        response.then().assertThat().
                body("id", equalTo(101)).and().
                body("title", equalTo("bmw"));

    }
    }

