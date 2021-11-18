package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class RealtyPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(),'Недвижимость')]")
    SelenideElement title;

    @FindBy(xpath = "//h2[contains(text(),'Листай, выбирай, переезжай!')]")
    SelenideElement subTitle;

    @FindBy(xpath = "//img[@alt='notification_icon']")
    SelenideElement imgRing;

    @FindBy(xpath = "//button[contains(text(),'Закрыть')]")
    SelenideElement closeBtn;


    public RealtyPage verifyRealtyPage() {
        title.should(Condition.matchText("Недвижимость"));
        subTitle.should(Condition.matchText("Листай, выбирай, переезжай!"));
        return this;
    }

    public RealtyPage identifyNoticeWindow() {
        imgRing.click();
        imgRing.isEnabled();
        closeBtn.click();
        return this;
    }
}
