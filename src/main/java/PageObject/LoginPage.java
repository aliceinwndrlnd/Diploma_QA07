package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy (className = "kf-HTgR-ee339")
    SelenideElement enterButton;

    @FindBy (id = "email")
    SelenideElement inputEmail;

    @FindBy (id = "password")
    SelenideElement inputPassword;

    @FindBy (className = "kf-cS-8bbc7 kf-cLS-c2977 kf-cLA-d9cc7 kf-cLZ-3e5d1")
    SelenideElement submitButton;

    public LoginPage enterEmail() {
        inputEmail.setValue("AutomationTestQA@yahoo.com");
        return this;
    }

    public LoginPage enterPassword() {
        inputPassword.setValue("AutomationTestQA1234");
        return this;
    }

    public LoginPage clickSubmit() {
        submitButton.click();
        return this;
    }



}
