package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//h1[contains(text(),' Подпишитесь на уведомления')]")
    SelenideElement secondPopupWindow;

    @FindBy(xpath = "//button[@id='cancel']")
    SelenideElement closeSecondPopupBtn;

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

    @FindBy(xpath = "//span[contains(text(),'Вся Беларусь')]")
    SelenideElement regionBtn;

    @FindBy(xpath = "//span[text()='Ваш регион']")
    SelenideElement txtAfterClickRegionBtn;

    @FindBy(xpath = "//select[@name = 'rgn']")
    SelenideElement selectRegion;

    @FindBy(xpath = "//select[@name = 'ar']")
    SelenideElement selectDistrict;

    @FindBy(xpath = "//button[contains(text(),'Выбрать')]")
    SelenideElement selectBtn;

    @FindBy(xpath = "//h1[contains(text(),'Все объявления ')]")
    SelenideElement mainText;

    public HomePage checkPopUpWindow(){
        secondPopupWindow.isEnabled();
        secondPopupWindow.shouldBe(Condition.matchText(" Подпишитесь на уведомления"));
        return this;
    }

    public HomePage closeSecondPopUp() {
        closeSecondPopupBtn.click();
        return this;
    }

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

    public HomePage goToCarPage() {
        autoBtn.click();
        return this;
    }

}
