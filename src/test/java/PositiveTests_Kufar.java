import Driver.BaseTestSelenide;
import PageObject.*;
import PageObject.Enum.AudiCars;
import PageObject.Enum.Car;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.ProfilePage;
import PageObject.SettingsPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class PositiveTests_Kufar extends BaseTestSelenide {

    @BeforeMethod
    public void precondition() {
        get(HomePage.class)
                .сlosePopUp();
    }

    @Test
    public void chooseRgnOnHomePageTest() { //тест без входа в профиль, выбираю Минск, Первомайский район
        get(HomePage.class)
                .verifyHomePage()
                .verifyRegionMenu()
                .selectRegion("7")
                .selectDistrict("24")
                .clickSelect()
                .checkMainTxtAfterSelect("Все объявления в Первомайском районе Минска");
    }

    @Test
    public void identifyNoticeWindowTest() { //тест cо входом в профиль, проверяю наличие окна с уведомлениями
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

    @Test
    public void entityTest() { //тест со входом в профиль на добавление и удаление объявления в избранные
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

    @Test
    public void uploadFileTest() { //тест на загрузку файла
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
    public void carCheckTest() { //проверка на граничные значения
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

