import Driver.BaseTestSelenide;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.RegistrationDataPage;
import PageObject.SettingsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class NegativeTests_Kufar extends BaseTestSelenide {

    @BeforeMethod
    public void precondition() {
        get(HomePage.class)
                .сlosePopUp();
    }

    @Test
    public void loginPageNegativeTest() { //ввод некорректных данных

        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("test@test.ru")
                .enterPassword("22222")
                .clickSubmit()
                .checkingErrorText();
    }

    @Test
    public void settingsPageNegativeTest() {//воспроизведение дефекта
        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(SettingsPage.class)
                .clickOnPfofile()
                .clickSettings()
                .enterName("илооллллллллллллллисвылотсатцуолаиииииииииииииииииииииииииииасилуцотвлуцо")
                .clickSave()
                .checkingValidationOfName();
    }

    @Test
    public void registrationDataPageTest() {//тест на ввод данных, не соответвующих минимальному количеству символов
        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(SettingsPage.class)
                .clickOnPfofile()
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
