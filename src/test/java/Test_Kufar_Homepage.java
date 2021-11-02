import Driver.BaseTestSelenide;
import PageObject.HomePage;
import PageObject.LoginPage;
import org.testng.annotations.Test;

public class Test_Kufar_Homepage extends BaseTestSelenide {
    @Test
    public void homePageTest() {
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
