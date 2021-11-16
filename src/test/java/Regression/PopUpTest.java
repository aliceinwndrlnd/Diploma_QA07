package Regression;

import Driver.BaseTestSelenide;
import PageObject.HomePage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class PopUpTest extends BaseTestSelenide {

    @Description("PopUp Test")
    @Test
    public void checkingPopUpTest() {
        get(HomePage.class)
                .checkPopUpWindow()
                .closeSecondPopUp();
    }
}
