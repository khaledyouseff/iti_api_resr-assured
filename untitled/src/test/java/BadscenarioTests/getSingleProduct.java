package BadscenarioTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;

public class getSingleProduct {
    @Test
    public void invalidId(){
        given().when().get("https://dummyjson.com/products/invalidID").then().statusCode(404);

    }
    @Test
    public void invalidMethod(){
        given().when().post("https://dummyjson.com/products/1").then().statusCode(415);

    }
    @Test
    public void emptyResponse(){
        given().when().get("https://dummyjson.com/products/emptyresponse").
                then().statusCode(200).body(is(emptyString()));
//tamam
    }

}
