package BadscenarioTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;

public class DeleteProduct {
    @Test
    public void validateResponseTime() {

        Response response = RestAssured
                .when()
                .delete("https://dummyjson.com/products/1");
        response.then().time(lessThan(500L));
         //expected result to fail
    }
    @Test
    public void SendingInvalidId() {

        Response response = RestAssured
                .when()
                .delete("https://dummyjson.com/products/-8");
       response.then().statusCode(404);
    }

    @Test
    public void missingParameter() {

        Response response = RestAssured
                .when()
                .delete("https://dummyjson.com/products");
        response.then().statusCode(404);
    }

}
