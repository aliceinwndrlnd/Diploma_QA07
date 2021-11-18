package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SettingsPage extends BasePage{

    @FindBy (xpath = "//*[@id='header']/div[2]/div[3]//span")
    SelenideElement profile;

    @FindBy (xpath = "//*[@id='header']//a[7]")
    SelenideElement settings;

    @FindBy (xpath = "//*[@id='name']")
    SelenideElement inputName;

    @FindBy (xpath = "//*[@id='change']")
    SelenideElement saveButton;

    public SettingsPage clickOnProfile() {
        profile.click();
        return this;
    }

    public SettingsPage clickSettings () {
        settings.click();
        return this;
    }

    public SettingsPage enterName(String name) {
        inputName.setValue(name);
        return this;
    }

    public SettingsPage clickSave() {
        saveButton.click();
        return this;
    }

    public SettingsPage checkingValidationOfName() {
        Assert.assertEquals(inputName.getValue(), "илооллллллллллллллисвылотсатцуолаиииииииииииииииииииииииииииасилуцотвлуцо");
        return this;
    }
}
