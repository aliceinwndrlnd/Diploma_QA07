package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.WebDriverRunner.driver;

public class CarCheckPage extends BasePage{

    @FindBy (css = "a[href$='vin_gorizontal&utm_term=menubutton']")
    SelenideElement carCheckPage;

    @FindBy(xpath = "//button[@id='cancel']")
    SelenideElement closeSecondPopupBtn;

    @FindBy (css = ".center-wrapper h1")
    SelenideElement pageTitle;

    @FindBy (css = "form.action-wrapper input")
    SelenideElement inputVin;

    @FindBy (css = ".btn-wrapper button")
    SelenideElement submitButton;

    public CarCheckPage closeSecondPopUp() {
        closeSecondPopupBtn.click();
        return this;
    }

    public CarCheckPage clickCarCheckPage() {
        carCheckPage.click();
        return this;
    }

    public CarCheckPage switchToAnotherWindow(String title){
        driver().switchTo().window(title);
        return this;
    }

    public CarCheckPage verifyTitle() {
        pageTitle.shouldBe(Condition.text("Проверка авто по VIN"));
        return this;
    }

    public CarCheckPage enterVinOfCar(String vinNum) {
        inputVin.setValue(vinNum);
        inputVin.shouldBe(Condition.attributeMatching("maxlength","17"));
        inputVin.shouldBe(Condition.attributeMatching("minlength","17"));
        return this;
    }

    public CarCheckPage submitClick(){
        submitButton.click();
        return this;
    }


}
