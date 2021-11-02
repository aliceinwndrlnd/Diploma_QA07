import Driver.BaseTestSelenide;
import PageObject.LoginPage;
import PageObject.ProfilePage;
import PageObject.SettingsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class NegativeTests_Kufar extends BaseTestSelenide {

    @Test
    public void loginPageNegativeTest() { //ввод некорректных данных
        get(LoginPage.class)
                .closePopUpWindow()
                .clickLoginPage()
                .enterEmail("test@test.ru")
                .enterPassword("22222")
                .clickSubmit()
                .checkingErrorText();
    }

    @Test
    public void settingsPageNegativeTest() { //воспроизведение дефекта
        get(LoginPage.class)
                .closePopUpWindow()
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
    public void uploadFileTest() { //загрузка файла (перенести в позитивные)
        get(LoginPage.class)
                .closePopUpWindow()
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(SettingsPage.class)
                .clickOnPfofile()
                .clickSettings();
        get(ProfilePage.class)
                .clickChooseButton()
                .uploadImg();

    }

    @AfterMethod
    public void closeDriver() {
        closeWebDriver();
    }
}
