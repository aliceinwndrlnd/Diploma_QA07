package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy (css = "#portal img")
    SelenideElement closePopUpWindow;

    @FindBy(css = "#header img")
    SelenideElement labels;

    @FindBy(xpath = "//a[@data-name = 'header-generalist-to-realty']")
    SelenideElement realtyBtn;

    @FindBy(xpath = "//a[@data-name = 'header-generalist-to-auto']")
    SelenideElement autoBtn;

    @FindBy(id = "searchbar-main")
    SelenideElement searchField;

    @FindBy(css = "button.kf-QNOz-80328")
    SelenideElement regionBtn;

    @FindBy(xpath = "//span[text()='Ваш регион']")
    SelenideElement txtAfterClickRegionBtn;

    @FindBy(xpath = "//select[@name = 'rgn']")
    SelenideElement selectRegion;

    @FindBy(xpath = "//select[@name = 'ar']")
    SelenideElement selectDistrict;

    @FindBy(xpath = "//button[text()='Выбрать']")
    SelenideElement selectBtn;

    @FindBy(css = "h1.kf-QSeV-5c87d")
    SelenideElement mainText;

    public HomePage сlosePopUp() {
        closePopUpWindow
                .click();
        return this;
    }

    public HomePage verifyHomePage() {
        labels.isEnabled();
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
