package Regression;

import Driver.BaseTestSelenide;
import PageObject.LoginPage;
import PageObject.ProfilePage;
import PageObject.SettingsPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class UploadFileTest extends BaseTestSelenide {

    @Description("File Uploader Test")
    @Test
    public void uploadFileTest() {
        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(SettingsPage.class)
                .clickOnProfile()
                .clickSettings();
        get(ProfilePage.class)
                .uploadImg()
                .checkImageAvailability();
    }
}
