package Rest_Api;

import Rest_Api.AdvtCarInLiked.AdvtInLiked;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;

public class APiTests {
    String token;
    String errorText;
    Gson gson = new Gson();
    ObjectMapper mapper = new ObjectMapper();
    Login correctLogin = new Login() {{
        setEmail("AutomationTestQA@yahoo.com");
        setPassword("AutomationTestQA1234");
    }};
    Login uncorrectLogin = new Login() {{
        setEmail("AutomationTestQA@yahoo.com");
        setPassword("ttt");
    }};

    @Test
    public void successfulAuthorization() throws JsonProcessingException {
        baseURI = "https://www.kufar.by/";
        String endpoint = "l/api/login/v2/auth/signin?token_type=user";
        String response = given().when().body(mapper.writeValueAsString(correctLogin))
                .and().header("Content-Type", "application/json").when()
                .post(endpoint).getBody().asPrettyString();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        token = jsonObject.get("jwt").getAsString();
    }

    @Test
    public void checkAdvtCarInLiked() {
        baseURI = "https://cre-api-v2.kufar.by/";
        String endpoint = "items-search/v1/engine/v1/search/rendered-paginated?size=32&aid=v.or:141441869";
        Response response = given().when().header("Authorization", "Bearer " + token)
                .and().header("Content-Type", "application/json")
                .get(endpoint);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.as(AdvtInLiked.class).getAds()[0].getAd_link(), "https://auto.kufar.by/vi/141441869");
        Assert.assertEquals(response.as(AdvtInLiked.class).getAds()[0].getCurrency(), "USD");
    }

    @Test
    public void checkAdvtRealtyInLiked() {
        baseURI = "https://cre-api-v2.kufar.by/";
        String endpoint = "items-search/v1/engine/v1/search/rendered-paginated?size=32&aid=v.or:123514239";
        Response response = given().when().header("Authorization", "Bearer " + token)
                .and().header("Content-Type", "application/json")
                .get(endpoint);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.as(Rest_Api.AdvtRealtyInLiked.AdvtInLiked.class).getAds()[0].getAccount_id(), 5994810);
        Assert.assertEquals(response.as(Rest_Api.AdvtRealtyInLiked.AdvtInLiked.class).getAds()[0].getAd_id(), 123514239);
        Assert.assertEquals(response.as(Rest_Api.AdvtRealtyInLiked.AdvtInLiked.class).getAds()[0].getSubject(), "Жилой комплекс «Парк Челюскинцев»");
    }

    @Test
    public void unsuccessfulAuthorization() throws JsonProcessingException {
        baseURI = "https://www.kufar.by/";
        String endpoint = "l/api/login/v2/auth/signin?token_type=user";
        String response = given().when().body(mapper.writeValueAsString(uncorrectLogin))
                .and().header("Content-Type", "application/json").when()
                .post(endpoint).getBody().asPrettyString();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        errorText = jsonObject.get("message").getAsString();
        Assert.assertEquals(errorText, "authentication failed");
    }
}