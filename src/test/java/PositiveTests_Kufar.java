import Driver.BaseTestSelenide;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.ProfilePage;
import PageObject.SettingsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class PositiveTests_Kufar extends BaseTestSelenide {
    @Test
    public void homePagePositiveTest() {
        get(HomePage.class)
                .сlosePopUp()
                .verifyHomePage()
                .verifyRegionMenu()
                .selectRegion("1")
                .selectDistrict("3")
                .clickSelect()
                .checkMainTxtAfterSelect();
    }

    @Test
    public void uploadFileTest() { //загрузка файла (допилить)
        get(HomePage.class)
                .сlosePopUp();
        get(LoginPage.class)
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

}
