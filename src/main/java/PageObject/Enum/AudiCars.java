package PageObject.Enum;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public enum AudiCars {
    AUDI_CARS($(xpath("//span[contains(text(), 'Audi')]")));

    protected SelenideElement element;

    AudiCars(SelenideElement element) {
        this.element = element;
    }

    public SelenideElement getElement() {
        return element;
    }
}
