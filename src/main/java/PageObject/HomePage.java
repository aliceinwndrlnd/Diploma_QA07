package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//img[@class = 'kf-QhSk-3eb10']")
    SelenideElement advtImg;

    @FindBy(xpath = "/a[@class = 'kf-ll-33e4f kf-lQm-dbfaa kf-lQq-d21e7 kf-lQN-7bbc0']")
    SelenideElement txtOnAdvt;

    @FindBy(xpath = "//button[@class = 'kf-wl-33e4f kf-wuQ-ef61a kf-wQq-d21e7 kf-QheX-41fb0']")
    SelenideElement closeAdvtBtn;

    @FindBy(xpath = "//img[@class = 'kf-LXFO-1bc4d']")
    SelenideElement label;

    @FindBy(xpath = "//a[@data-name = 'header-generalist-to-realty']")
    SelenideElement realtyBtn;

    @FindBy(xpath = "//a[@data-name = 'header-generalist-to-auto']")
    SelenideElement autoBtn;

    @FindBy(id = "searchbar-main")
    SelenideElement searchField;

    @FindBy(css = ".kf-LNVG-6f660")
    SelenideElement regionBtn;

    @FindBy(xpath = "//span[@class = 'kf-CnnV-6af06']")
    SelenideElement txtAfterClickRegionBtn;

    @FindBy(xpath = "//span[@class = 'kf-CnnV-6af06']")
    SelenideElement selectRegion;

    @FindBy(xpath = "//select[@name = 'ar']")
    SelenideElement selectDistrict;

    @FindBy(xpath = "//button[@class = 'kf-wl-33e4f kf-wQm-dbfaa kf-wQq-d21e7']")
    SelenideElement selectBtn;

    @FindBy(xpath = "//button[@appearance = 'primary']")
    SelenideElement advtBtn;

    @FindBy(xpath = "//button[@class = 'kf-cS-8bbc7 kf-cLR-0aa8d']")
    SelenideElement btnToLog;

    @FindBy(xpath = "//h1[@class = 'kf-Qzz-9d2a4']")
    SelenideElement mainText;

    @FindBy(xpath = "//button[@class = 'kf-eYS-8bbc7']")
    SelenideElement categoriesBtn;

    @FindBy(xpath = "//div[@class = 'fl-ao-22389']")
    SelenideElement filtersBtn;

    @FindBy(xpath = "//div[@data-name = 'prc']")
    SelenideElement priceBtn;

    @FindBy(xpath = "//div[@data-name = 'cnd']")
    SelenideElement conditionBtn;

    @FindBy(xpath = "//div[@data-name = 'cmp']")
    SelenideElement sellerBtn;

    @FindBy(xpath = "//h2[@class = 'kf-Vzc-cb225 kf-Vzb-ae3ed']")
    SelenideElement allItemsBtn;

    @FindBy(xpath = "//h2[@class = 'kf-Vzc-cb225']")
    SelenideElement itemsFromShopsBtn;

    @FindBy(xpath = "//a[@class = 'kf-zGms-0afda']")// локатор для всех объявлений на вкладке все товары
    SelenideElement allAdvtFromAllItems;

    @FindBy(css = ".kf-EzN-f7ed4")
    SelenideElement textOnItemsFromShops;

    @FindBy(xpath = "//a[@class = 'kf-zGms-0afda']")// локатор для всех объявлений на вкладке товары от магазинов
    SelenideElement allAdvtFromItemsFromShops;

    @FindBy(xpath = "//span[@class = 'kf-szT-59ba5 kf-sNH-636ce kf-sHf-ebdd2']")//проверить, что не доступна, т.к. на первой я стр
    SelenideElement pagePrevBtn;

    @FindBy(xpath = "//a[@class = 'kf-szT-59ba5 kf-sNH-636ce']")
    SelenideElement pageNextBtn;

    @FindBy(xpath = "//button[@class = 'kf-LRFC-1034a']")
    SelenideElement langChangeBtn;

    @FindBy(xpath = "//a[@class = 'kf-LqFB-53eaa']")// локатор для всех эл-ов внизу сайта (Реклама - Вакансии)
    SelenideElement linksForAddHelpElOnPageDown;

    @FindBy(xpath = "//a[@class = 'kf-LtOL-fd8b8']")// локатор для всех эл-ов внизу сайта (Appstore - Huawei)
    SelenideElement linksToStoresOnPageDown;

    @FindBy(xpath = "//a[@class = 'kf-LYTX-d8146']")// локатор для всех эл-ов внизу сайта (Telegram - Viber)
    SelenideElement linksToSocNetOnPageDown;

    public HomePage checkAndCloseAdvt() {
        this.advtImg.shouldBe(Condition.exist);
        txtOnAdvt.should(Condition.matchText("Ого, расскажите подробнее"));
        closeAdvtBtn.click();
        return this;
    }

    public HomePage verifyHomePage() {
        label.isDisplayed();
        searchField.isEnabled();
        mainText.should(Condition.matchText("Все объявления в Беларуси"));
        return this;
    }

    public HomePage chooseRegion() {
        regionBtn.click();
        txtAfterClickRegionBtn.should(Condition.matchText("Ваш регион"));
        selectRegion.getSelectedValue();
        selectDistrict.getSelectedValue();
        selectBtn.click();
        return this;
    }
}
