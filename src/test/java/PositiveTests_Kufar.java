import Driver.BaseTestSelenide;
import PageObject.HomePage;
import PageObject.LoginPage;
import org.testng.annotations.Test;

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
}
