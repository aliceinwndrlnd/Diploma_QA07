package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

    @FindBy (css = "#portal img")
    SelenideElement closePopUpWindow;

    @FindBy (css = ".kf-HccG-9fd2c div")
    SelenideElement enterButton;

    @FindBy (id = "email")
    SelenideElement inputEmail;

    @FindBy (id = "password")
    SelenideElement inputPassword;

    @FindBy (className = "kf-cS-8bbc7 kf-cLS-c2977 kf-cLA-d9cc7 kf-cLZ-3e5d1")
    SelenideElement submitButton;

    @FindBy (className = "kf-HbkZ-b0d48")
    SelenideElement icons;

    @FindBy (className = "kf-eBXO-2f96e")
    SelenideElement errorText;

    public LoginPage closePopUpWindow() {
        closePopUpWindow.click();
        return this;
    }

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

    public LoginPage verifyIcons() {
        icons.isEnabled();
        return this;
    }

    public LoginPage checkingErrorText() {
        Assert.assertEquals(errorText.getText(), "Профиль не активирован. Нажмите ");
        return this;
    }
}
