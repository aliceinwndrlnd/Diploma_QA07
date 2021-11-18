package Regression;

import Driver.BaseTestSelenide;
import PageObject.LoginPage;
import PageObject.SettingsPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SettingsPageNegativeTest extends BaseTestSelenide {

    @Description("Test reproducing any defect")
    @Test
    public void settingsPageNegativeTest() {
        get(LoginPage.class)
                .clickLoginPage()
                .enterEmail("AutomationTestQA@yahoo.com")
                .enterPassword("AutomationTestQA1234")
                .clickSubmit();
        get(SettingsPage.class)
                .clickOnProfile()
                .clickSettings()
                .enterName("илооллллллллллллллисвылотсатцуолаиииииииииииииииииииииииииииасилуцотвлуцо")
                .clickSave()
                .checkingValidationOfName();
    }
}
