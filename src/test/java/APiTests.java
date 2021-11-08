import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;

public class APiTests {

    @BeforeTest
    public void preconditions() {
        baseURI = "https://kufar.by/";
    }

    @Test
    public void securityPage() {
        String endpoint = "api/search/items-search/v1/engine/v1/search/rendered?cat=2060&sort=lst.d&typ=sell&size=8&oph=1&lang=ru";
        given().when().get(endpoint).then().statusCode(200);




    }
}
