package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationDataPage extends BasePage{

    @FindBy(css = "a[href$='registration_data']")
    SelenideElement registrationDataPage;

    @FindBy(css = "a[href$='change_password']")
    SelenideElement changePasswordButton;

    @FindBy(tagName = "h1")
    SelenideElement titleText;

    @FindBy(id = "currentPassword")
    SelenideElement inputCurrentPassword;

    @FindBy(id = "password")
    SelenideElement inputPassword;

    @FindBy(id = "confirmPassword")
    SelenideElement inputConfirmPassword;

    @FindBy(xpath = "//span[contains(text(),'Пароль не должен ')]")
    SelenideElement errorText;

    public RegistrationDataPage registrationDataPageClick(){
        registrationDataPage.click();
        return this;
    }

    public RegistrationDataPage changePasswordButtonClick() {
        changePasswordButton.click();
        return this;
    }

    public RegistrationDataPage verifyTitle() {
        Assert.assertEquals(titleText.getText(),"Изменение пароля от профиля");
        return this;
    }

    public RegistrationDataPage enterCurrentPassword(String currentPassword) {
        inputCurrentPassword.setValue(currentPassword);
        return this;
    }

    public RegistrationDataPage enterPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    public RegistrationDataPage enterConfirmPassword(String confirmPassword) {
        inputConfirmPassword.setValue(confirmPassword);
        return this;
    }

    public RegistrationDataPage checkErrorText() {
        Assert.assertEquals(errorText.getText(),"Пароль не должен быть короче 8 символов");
        return this;
    }
}
