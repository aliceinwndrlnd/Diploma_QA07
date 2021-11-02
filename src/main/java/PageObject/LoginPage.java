package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

    @FindBy (xpath = "//*[@id='header']/div[2]/div[3]//button")
    SelenideElement enterButton;

    @FindBy (id = "email")
    SelenideElement inputEmail;

    @FindBy (id = "password")
    SelenideElement inputPassword;

    @FindBy (xpath = "//*[@id='__next']//form/div[4]/button")
    SelenideElement submitButton;

    @FindBy (xpath = "//*[@id='__next']//form/span/div")
    SelenideElement errorText;

    public LoginPage clickLoginPage() {
        enterButton.click();
        return this;
    }

    public LoginPage enterEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public LoginPage checkingErrorText() {
        Assert.assertEquals(errorText.getText(), "Профиль не активирован. Нажмите здесь, чтобы активировать его.");
        return this;
    }
}
