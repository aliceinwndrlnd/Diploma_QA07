package Rest_Api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;

public class APiTests {
    String token;
    Gson gson = new Gson();
    ObjectMapper mapper = new ObjectMapper();
    Login login = new Login() {{
        setEmail("AutomationTestQA@yahoo.com");
        setPassword("AutomationTestQA1234");
    }};


    @Test
    public void authorization() throws JsonProcessingException {
        baseURI = "https://www.kufar.by/";
        String response = given().when().body(mapper.writeValueAsString(login))
                .and().header("Content-Type", "application/json").when()
                .post("l/api/login/v2/auth/signin?token_type=user").getBody().asPrettyString();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        token = jsonObject.get("jwt").getAsString();
    }

    @Test
    public void checkAdvtInLiked() {
        baseURI = "https://cre-api-v2.kufar.by/";
        String endpoint = "items-search/v1/engine/v1/search/rendered-paginated?size=32&aid=v.or:141441869";
        Response response = given().when().header("Authorization", "Bearer " + token)
                .and().header("Content-Type", "application/json")
                .get(endpoint);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.as(Ad.class).getAdLink(), "https://auto.kufar.by/vi/141441869");
        Assert.assertEquals(response.as(Ad.class).getCurrency(), "USD");
    }
}