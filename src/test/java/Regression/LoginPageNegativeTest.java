package Regression;

import Driver.BaseTestSelenide;
import PageObject.LoginPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class LoginPageNegativeTest extends BaseTestSelenide {

    @Description("Test for the use of incorrect data")
    @Test
    public void loginPageNegativeTest() {

        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("test@test.ru")
                .enterPassword("22222")
                .clickSubmit()
                .checkingErrorText();
    }
}
