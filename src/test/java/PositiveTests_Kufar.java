import Driver.BaseTestSelenide;
import PageObject.*;
import PageObject.Enum.AudiCars;
import PageObject.Enum.Car;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.ProfilePage;
import PageObject.SettingsPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class PositiveTests_Kufar extends BaseTestSelenide {

    /*@BeforeMethod
    public void precondition() {
        get(HomePage.class)
                .сlosePopUp();
    }*/


    @Description("Test to validate select fields")
    @Test
    public void chooseRgnOnHomePageTest() {
        get(HomePage.class)
                .verifyHomePage()
                .verifyRegionMenu()
                .selectRegion("7")
                .selectDistrict("24")
                .clickSelect()
                .checkMainTxtAfterSelect("Все объявления в Первомайском районе Минска");
    }

    @Description("PopUp Test")
    @Test
    public void checkingPopUpTest() {
        get(HomePage.class)
                .checkPopUpWindow()
                .closeSecondPopUp();
    }

    @Description("Dialog display Test")
    @Test
    public void identifyNoticeWindowTest() {
        get(HomePage.class)
                .verifyHomePage();
        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(HomePage.class)
                .goToRealtyPage();
        get(RealtyPage.class)
                .verifyRealtyPage()
                .identifyNoticeWindow();
    }

    @Description("Entity creation and deletion test")
    @Test
    public void entityTest() {
        get(HomePage.class)
                .verifyHomePage();
        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(HomePage.class)
                .goToCarPage();
        get(CarPage.class)
                .verifyCarPage()
                .moveToAudiCars(AudiCars.AUDI_CARS)
                .clickOnCar(Car.CAR)
                .addCarToLiked()
                .verifyCarInLiked()
                .deleteCarFromLiked()
                .verifyEmptyLiked();
    }


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

    @Description("Test for checking the input field for boundary values")
    @Test
    public void carCheckTest() {
        get(CarCheckPage.class)
                .clickCarCheckPage()
                .switchToAnotherWindow("Проверка авто по ВИН на Куфаре")
                .verifyTitle()
                .enterVinOfCar("111111111711111111")
                .submitClick();
        }

    @AfterMethod
    public void closeDriver() {
        closeWebDriver();
        }
    }

