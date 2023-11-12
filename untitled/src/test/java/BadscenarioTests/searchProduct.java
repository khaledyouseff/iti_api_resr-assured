package BadscenarioTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class searchProduct {

    @Test
    public void emptyQuery(){
        given().when().get("https://dummyjson.com/products/search?q=").then().statusCode(400);
//bug -> resul:200ok
    }

    @Test
    public void invalidQuery(){
        given().when().get("https://dummyjson.com/products/search?q=@#@slnk").then().statusCode(400);
//bug -> resul:200ok
    }
    @Test
    public void NonexistentQuery(){
        given().when().get("https://dummyjson.com/products/search?q=khaled").then().statusCode(400);
//bug -> resul:200ok
    }
    @Test
    public void invalidMethod(){
        given().when().post("https://dummyjson.com/products/search?q=phone").then().statusCode(415);

    }



}
