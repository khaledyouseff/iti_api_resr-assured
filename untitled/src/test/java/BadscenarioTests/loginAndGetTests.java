package BadscenarioTests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class loginAndGetTests {

    @Test
    public void invalidUsernameAndPassword(){
        String invalidCredentials = "{\n" +
                "    \"username\": \"khaled\",\n" +
                "    \"password\": \"yousef\"\n" +
                "}";

        given().contentType(ContentType.JSON).
                body(invalidCredentials).when().
                post("https://dummyjson.com/auth/login").then().statusCode(400);

    }
    @Test
    public void withoutUserName(){
        String invalidCredentials = "{\n" +
                "    \"password\": \"0lelplR\"\n" +
                "}";

        given().contentType(ContentType.JSON).
                body(invalidCredentials).when().
                post("https://dummyjson.com/auth/login").then().statusCode(400);

    }
    @Test
    public void withoutPassword(){
        String invalidCredentials = "{\n" +
                "    \"username\": \"kminchelle\"\n" +
                "}";

        given().contentType(ContentType.JSON).
                body(invalidCredentials).when().
                post("https://dummyjson.com/auth/login").then().statusCode(400);

    }
    @Test
    public void emptyBody(){
        String invalidCredentials = "{}";

        given().contentType(ContentType.JSON).
                body(invalidCredentials).when().
                post("https://dummyjson.com/auth/login").then().statusCode(400);

    }
    @Test
    public void missingUserNameAndPassword(){
        String invalidCredentials = "{\\n\" +\n" +
                "                \"    \\\"username\\\":  +\n" +
                "                \"    \\\"password\\\":  +\n" +
                "                \"}";

        given().contentType(ContentType.JSON).
                body(invalidCredentials).when().
                post("https://dummyjson.com/auth/login").then().statusCode(400);

    }
    @Test
    public void invalidJsonBody(){
        String invalidCredentials = "drthstjryjrbgbgrbs";

        given().contentType(ContentType.JSON).
                body(invalidCredentials).when().
                post("https://dummyjson.com/auth/login").then().statusCode(400);

    }

}
