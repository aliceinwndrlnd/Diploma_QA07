import Driver.BaseTestSelenide;
import PageObject.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class PositiveTests_Kufar extends BaseTestSelenide {

    @BeforeMethod
    public void precondition() {
        get(HomePage.class)
                .сlosePopUp();
    }

    @Test
    public void homePageTest() {
        get(HomePage.class)
                .verifyHomePage()
                .verifyRegionMenu()
                .selectRegion("1")
                .selectDistrict("3")
                .clickSelect()
                .checkMainTxtAfterSelect();
    }
  
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

    @Test
    public void carCheckTest() {
        get(CarCheckPage.class)
                .clickCarCheckPage()
                .verifyTitle()
                .enterVinOfCar("11111111111111111")
                .submitClick();

    }

    @AfterMethod
    public void closeDriver() {

        closeWebDriver();
    }
}

