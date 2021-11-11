import Driver.BaseTestSelenide;
import PageObject.*;
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
    public void addCarInLiked() { //тест со входом в профиль на добавление объявления в избранные
        get(HomePage.class)
                .verifyHomePage();
        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(HomePage.class)
                .goToAutoPage();
        get(CarPage.class)
                .verifyCarPage()
                .selectCarBrand("category_2010.mark_audi")
                .selectFilter("prc.d") // добавила также фильтрацию, чтобы самые дорогие машины сначала были, т.к. список не такой меняющийся получается
                .scrollToCars() // не уверена, что нужен, но для того, чтобы прокрутить страницу до самих объявлений машин
                .selectCar(1);
        get(CarCheckPage.class)
                .switchToAnotherWindow("Купить  3.0 л, Минск, С пробегом, 48100 км., Бензин, Автомат по цене 206 683 р. на Куфар Авто");
        get(CarPage.class)
                .addCarToLiked()
                .verifyCarInLiked("Audi Q8 55 TFSI quattro S line");
    }

    @Test
    public void deleteCarFromLiked() {
        get(HomePage.class)
                .verifyHomePage();
        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(HomePage.class)
                .goToAutoPage();
        get(CarPage.class)
                .verifyCarPage()
                .selectCarBrand("category_2010.mark_audi")
                .selectFilter("prc.d")
                .scrollToCars()
                .selectCar(1);
        get(CarCheckPage.class)
                .switchToAnotherWindow("Купить  3.0 л, Минск, С пробегом, 48100 км., Бензин, Автомат по цене 206 683 р. на Куфар Авто");
        get(CarPage.class)
                .addCarToLiked()
                .verifyCarInLiked("Audi Q8 55 TFSI quattro S line")
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

