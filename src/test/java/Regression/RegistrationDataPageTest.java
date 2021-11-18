package Regression;

import Driver.BaseTestSelenide;
import PageObject.LoginPage;
import PageObject.RegistrationDataPage;
import PageObject.SettingsPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class RegistrationDataPageTest extends BaseTestSelenide {

    @Description("Test for entering data that does not match the minimum")
    @Test
    public void registrationDataPageTest() {
        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(SettingsPage.class)
                .clickOnProfile()
                .clickSettings();
        get(RegistrationDataPage.class)
                .registrationDataPageClick()
                .changePasswordButtonClick()
                .verifyTitle()
                .enterCurrentPassword("1")
                .enterPassword("1")
                .enterConfirmPassword(" ")
                .checkErrorText();
    }
}
