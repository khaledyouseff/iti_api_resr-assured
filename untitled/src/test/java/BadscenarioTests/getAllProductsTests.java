package BadscenarioTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.text.IsEmptyString.emptyString;

public class getAllProductsTests {
@Test
    public void invalidEndPoint(){
    given().
            when().get("https://dummyjson.com/aykalam").then().statusCode(404);
}
    @Test
    public void invalidMethod(){

        given().when().post("https://dummyjson.com/products").then().statusCode(415);
    }
    @Test
    public void invalidParameters(){
    given().param("invalidParam", "value").
            when().get("https://dummyjson.com/products").then().statusCode(400);
    //bug
    }
    @Test
    public void emptyResponse(){
        given().when().get("https://dummyjson.com/products").
                then().statusCode(200).body(is(emptyString()));
//tamam
    }

}
