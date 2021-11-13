package Rest_Api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeTest;


import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;

public class APiTests {
    String token;
    Gson gson = new Gson();
    ObjectMapper mapper = new ObjectMapper();
    Login login = new Login() {{
        setLogin("AutomationTestQA@yahoo.com");
        setPassword("AutomationTestQA1234");
    }};

    @BeforeTest
    public void preconditions() throws JsonProcessingException {
        baseURI = "https://kufar.by/";
        String response = given().when().body(mapper.writeValueAsString(login))
                .and().header("Content-Type", "application/json").when().post("l/api/login/v2/auth/signin?token_type=user").getBody().asPrettyString();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        token = jsonObject.get("token").getAsString();
    }
}
