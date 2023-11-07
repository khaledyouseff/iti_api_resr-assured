package tests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import net.minidev.json.JSONObject;
public class DeleteProduct {
    @Test
    public void testDeleteRequest() {

        Response response = RestAssured
                .when()
                .delete("https://dummyjson.com/products/1");

        response.then().statusCode(200);

    }
}






