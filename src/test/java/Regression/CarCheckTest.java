package Regression;

import Driver.BaseTestSelenide;
import PageObject.CarCheckPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class CarCheckTest extends BaseTestSelenide {

    @Description("Test for checking the input field for boundary values")
    @Test
    public void carCheckTest() {
        get(CarCheckPage.class)
                .closeSecondPopUp()
                .clickCarCheckPage()
                .switchToAnotherWindow("Проверка авто по ВИН на Куфаре")
                .verifyTitle()
                .enterVinOfCar("111111111711111111")
                .submitClick();
    }
}
