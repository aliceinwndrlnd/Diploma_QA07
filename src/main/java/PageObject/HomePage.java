package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy (css = "#portal img")
    SelenideElement closePopUpWindow;

    @FindBy(xpath = "//img[@class = 'kf-LvPY-4462d']")
    SelenideElement label;

    @FindBy(xpath = "//a[@data-name = 'header-generalist-to-realty']")
    SelenideElement realtyBtn;

    @FindBy(xpath = "//a[@data-name = 'header-generalist-to-auto']")
    SelenideElement autoBtn;

    @FindBy(id = "searchbar-main")
    SelenideElement searchField;

    @FindBy(css = ".kf-UOWm-e610f.kf-UOcV-893b8 > button") // .kf-LZmS-6fe98
    SelenideElement regionBtn;

    @FindBy(css = "span.kf-UOcb-c661a") // xpath = "//span[@class = 'kf-LbPk-7dca8']"
    SelenideElement txtAfterClickRegionBtn;

    @FindBy(xpath = "//select[@name = 'rgn']")
    SelenideElement selectRegion;

    @FindBy(xpath = "//select[@name = 'ar']")
    SelenideElement selectDistrict;

    @FindBy(css = "button.kf-QH-ef4dd.kf-QUe-bf782.kf-QUK-32bf8") //xpath = //button[@class = 'kf-wc-df57b kf-wLV-a96ca kf-wLE-75795']
    SelenideElement selectBtn;

    @FindBy(css = ".kf-XXAk-8cee0 h1") // xpath = "//h1[@class = 'kf-LnEa-0743e']"
    SelenideElement mainText;

    public HomePage сlosePopUp() {
        closePopUpWindow
                .click();
        return this;
    }

    public HomePage verifyHomePage() {
        label.isDisplayed();
        searchField.isEnabled();
        mainText.should(Condition.matchText("Все объявления в Беларуси"));
        return this;
    }

    public HomePage verifyRegionMenu() {
        regionBtn.click();
        txtAfterClickRegionBtn.should(Condition.matchText("Ваш регион"));
        return this;
    }

    public HomePage selectRegion(String index) {
        selectRegion.selectOptionByValue(index);
        return this;
    }

    public HomePage selectDistrict(String index) {
        selectDistrict.selectOptionByValue(index);
        return this;
    }

    public HomePage clickSelect() {
        selectBtn.click();
        return this;
    }

    public HomePage checkMainTxtAfterSelect(String text) {
        mainText.should(Condition.matchText(text));
        return this;
    }

    public HomePage goToRealtyPage() {
        realtyBtn.click();
        return this;
    }

    public HomePage goToAutoPage() {
        autoBtn.click();
        return this;
    }
}
