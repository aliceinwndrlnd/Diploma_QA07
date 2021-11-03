import Driver.BaseTestSelenide;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.ProfilePage;
import PageObject.SettingsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void uploadFileTest() { //загрузка файла (допилить)
        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(SettingsPage.class)
                .clickOnPfofile()
                .clickSettings();
        get(ProfilePage.class)
                .clickChooseButton()
                .uploadImg();

    }
}
