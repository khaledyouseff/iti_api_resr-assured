package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class searchProduct {
    @Test
    public void CheckStatusCodeIs200ok(){
        given().when().get("https://dummyjson.com/products/search?q=phone").then().
                statusCode(200);
    }
    @Test
    public void ValidatingResponseBody(){
        Response response = RestAssured.get("https://dummyjson.com/products/search?q=phone");
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("phone"));
    }
    @Test
    public void ValidateSpecificFields() {
        given().
                when().
                get("https://dummyjson.com/products/search?q=phone").
                then().
                assertThat().
                body("products[0].title", equalTo("iPhone 9")).and().
                body("products[0].description", equalTo("An apple mobile which is nothing like apple")).
                and().body("products[0].stock", equalTo(94)).and().
                body("products[0].category", equalTo("smartphones"));
    }
    @Test
    public void ValidateContentType() {
        given().when().get("https://dummyjson.com/products/search?q=phone").then().
                assertThat().
                contentType(ContentType.JSON);
    }
    @Test
    public void ValidatingResponseHeaders(){
        given().when().get("https://dummyjson.com/products/search?q=phone").then().
                header("Content-Type" , "application/json; charset=utf-8");
        //or
        // Response response = RestAssured.get("https://dummyjson.com/products/1");
        // String contentType = response.header("Content-Type");
        //Assert.assertEquals(contentType, "application/json; charset=utf-8");
    }
    @Test
    public void requestDetails() {
        given().
                log().all().
                when().
                get("https://dummyjson.com/products/search?q=phone").
                then().
                log().body();
    }
}
