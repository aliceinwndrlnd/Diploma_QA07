package Regression;

import Driver.BaseTestSelenide;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.RealtyPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class NoticeWindowTest extends BaseTestSelenide {

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
                .closeSecondPopUp()
                .goToRealtyPage();
        get(RealtyPage.class)
                .verifyRealtyPage()
                .identifyNoticeWindow();
    }
}
