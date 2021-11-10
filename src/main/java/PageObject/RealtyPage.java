package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class RealtyPage {

    @FindBy(xpath = "//a[@class='kf-mL-ef9bf']")
    SelenideElement title;

    @FindBy(xpath = "//div[@class='kf-EwG-3d93c']")
    SelenideElement subTitle;

    @FindBy(xpath = "//div[@class='kf-vWoC-7761a']")
    SelenideElement ring;

    @FindBy(xpath = "//img[@alt='notification-no-result']")
    SelenideElement imgRing;

    @FindBy(xpath = "//button[@class='kf-QaQF-9bb7d kf-QavG-6cdf8']")
    SelenideElement closeBtn;

    public RealtyPage verifyRealtyPage() {
        //title.should(Condition.matchText("Недвижимость")); // может уведомление перекрывает
        subTitle.should(Condition.matchText("Листай, выбирай, переезжай!"));
        return this;
    }

    public RealtyPage identifyNoticeWindow() {
        ring.click();
        imgRing.isDisplayed();
        closeBtn.click();
        return this;
    }
}
