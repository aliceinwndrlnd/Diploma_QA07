package Smoke;

import Driver.BaseTestSelenide;
import PageObject.CarPage;
import PageObject.Enum.AudiCars;
import PageObject.Enum.Car;
import PageObject.HomePage;
import PageObject.LoginPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class EntityTest extends BaseTestSelenide {

    /*@BeforeTest
    public void precondition() {
        get(HomePage.class)
                .сlosePopUp();
    }*/

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

}
