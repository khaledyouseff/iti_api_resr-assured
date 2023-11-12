package validationTestes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class DeleteProduct {
    @Test
    public void testDeleteRequest() {

        Response response = RestAssured
                .when()
                .delete("https://dummyjson.com/products/1");

        response.then().statusCode(200);
        response.then().time(lessThan(2000L));

    }
    @Test
    public void ValidatingResponseHeaders(){
        given().when().delete("https://dummyjson.com/products/1").then().
                header("Content-Type" , "application/json; charset=utf-8");
        //or
        // Response response = RestAssured.get("https://dummyjson.com/products/1");
        // String contentType = response.header("Content-Type");
        //Assert.assertEquals(contentType, "application/json; charset=utf-8");
    }
    @Test
    public void validateResponseTime() {

        Response response = RestAssured
                .when()
                .delete("https://dummyjson.com/products/1");
        response.then().time(lessThan(2000L));

        }
    @Test
    public void validateResponseCode() {

        Response response = RestAssured
                .when()
                .delete("https://dummyjson.com/products/1");
                response.then().statusCode(200);
    }
    @Test
    public void validateResponseIsJson() {

        Response response = RestAssured
                .when()
                .delete("https://dummyjson.com/products/1");
        response.then().contentType(ContentType.JSON);
    }
}







