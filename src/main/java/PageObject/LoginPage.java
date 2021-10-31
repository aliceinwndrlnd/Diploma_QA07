package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

    @FindBy (className = "kf-HTgR-ee339")
    SelenideElement enterButton;

    @FindBy (id = "email")
    SelenideElement inputEmail;

    @FindBy (id = "password")
    SelenideElement inputPassword;

    @FindBy (className = "kf-cS-8bbc7 kf-cLS-c2977 kf-cLA-d9cc7 kf-cLZ-3e5d1")
    SelenideElement submitButton;

    @FindBy (className = "kf-HbkZ-b0d48")
    SelenideElement icons;

    @FindBy (className = "kf-HRkA-a1267")
    SelenideElement text;

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

    public LoginPage checkingText() {
        Assert.assertEquals(text.getText(), "Войдите через сервисы:");
        return this;
    }
}
