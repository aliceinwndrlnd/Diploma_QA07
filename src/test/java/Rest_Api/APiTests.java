package Rest_Api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void unsuccessfulAuthorization() throws JsonProcessingException {
        baseURI = "https://www.kufar.by/";
        String endpoint = "l/api/login/v2/auth/signin?token_type=user";
        String response = given().when().body(mapper.writeValueAsString(uncorrectLogin))
                .and().header("Content-Type", "application/json").when()
                .post(endpoint).getBody().asPrettyString();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        errorText = jsonObject.get("message").getAsString();
        Assert.assertEquals(errorText,"authentication failed");
    }
}