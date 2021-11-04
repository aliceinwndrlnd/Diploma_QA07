package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class CarCheckPage {

    @FindBy (css = ".swiper-slide.kf-CNw-a2cff.swiper-slide-visible.swiper-slide-next span")
    SelenideElement carCheckPage;

    @FindBy (css = ".container.index-page")
    SelenideElement pageTitle;

    @FindBy (xpath = "//div[contains(@class, 'input-wrapper')]//input")
    SelenideElement inputVin;

    @FindBy (css = ".btn-wrapper button")
    SelenideElement submitButton;

    public CarCheckPage clickCarCheckPage() {
        carCheckPage.click();
        return this;
    }

    public CarCheckPage verifyTitle() {
        pageTitle.shouldBe(Condition.text("Проверка авто по VIN"));
        return this;
    }

    public CarCheckPage enterVinOfCar(String vinNum) {
        inputVin.setValue(vinNum);
        return this;
    }

    public CarCheckPage submitClick(){
        submitButton.click();
        return this;
    }


}
