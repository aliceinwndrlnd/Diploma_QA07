import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;

public class APiTests {

    @BeforeTest
    public void preconditions() {
        baseURI = "https://kufar.by/";
    }

    @Test
    public void securityPage() {
        RestAssured.registerParser("text/html", Parser.JSON);
        String endpoint = "/api/search/items-search/v1/engine/v1/search/rendered?cat=2010&sort=lst.d&typ=sell&size=8&oph=1&cnd=2&lang=ru";
        given().when().get(endpoint).then().statusCode(200);
        given().contentType(ContentType.JSON).when().get(endpoint).then().assertThat().contentType("text/html; charset=utf-8");
    }
}
