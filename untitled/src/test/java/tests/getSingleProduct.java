package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getSingleProduct {
    @Test
    public void CheckStatusCodeIs200ok(){
        given().when().get("https://dummyjson.com/products/1").then().
                statusCode(200);
    }
    @Test
    public void ValidatingResponseBody(){
        Response response = RestAssured.get("https://dummyjson.com/products/1");
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("id"));
    }
    @Test
    public void ValidateSpecificFields() {
        given().
                when().
                get("https://dummyjson.com/products/1").
                then().
                assertThat().
                body("id", equalTo(1)).and().
                body("description", equalTo("An apple mobile which is nothing like apple")).
                and().body("rating", equalTo(4.69F)).and().
                body("brand", equalTo("Apple"));
    }
    @Test
    public void ValidateContentType() {
        given().when().get("https://dummyjson.com/products/1").then().
                assertThat().
                contentType(ContentType.JSON);
    }
    @Test
    public void ValidatingResponseHeaders(){
        given().when().get("https://dummyjson.com/products/1").then().
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
                get("https://dummyjson.com/products/1").
                then().
                log().body();
    }

}
