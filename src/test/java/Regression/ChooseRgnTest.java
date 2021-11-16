package Regression;

import Driver.BaseTestSelenide;
import PageObject.HomePage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class ChooseRgnTest extends BaseTestSelenide {

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
}
