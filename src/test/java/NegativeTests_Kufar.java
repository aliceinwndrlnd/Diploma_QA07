import Driver.BaseTestSelenide;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.RegistrationDataPage;
import PageObject.SettingsPage;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class NegativeTests_Kufar extends BaseTestSelenide {

    /*@BeforeMethod
    public void precondition() {
        get(HomePage.class)
                .сlosePopUp();
    }*/

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

    @Description("Test reproducing any defect")
    @Test
    public void settingsPageNegativeTest() {
        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(SettingsPage.class)
                .clickOnProfile()
                .clickSettings()
                .enterName("илооллллллллллллллисвылотсатцуолаиииииииииииииииииииииииииииасилуцотвлуцо")
                .clickSave()
                .checkingValidationOfName();
    }

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

    @AfterMethod
    public void closeDriver() {
        closeWebDriver();
    }
}
