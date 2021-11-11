package PageObject.Enum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public enum Car {
    CAR($(By.xpath("//a[contains(@href,'auto.kufar.by/vi')]")));

    protected SelenideElement element;

    Car(SelenideElement element) {
        this.element = element;
    }

    public SelenideElement getElement() {
        return element;
    }
}
