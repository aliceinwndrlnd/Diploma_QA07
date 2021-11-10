package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.elements;

public class CarPage {

    @FindBy(xpath = "//div[@data-name='logo_auto']")
    SelenideElement title;

    @FindBy(xpath = "//h3[@class='kf-ir-8390b kf-qfe-b1b3f']")
    SelenideElement subTitle;

    @FindBy(xpath = "//select[@name='cbnd2']")
    SelenideElement selectBrand;

    @FindBy(xpath = "//button[@data-cy='filters-auto-submit-button']")
    SelenideElement foundBtn;

    @FindBy(xpath = "//select[@id = 'sort']")
    SelenideElement selectFilter;

    @FindBy(xpath = "//div[@class = 'kf-aRN-75d05']")
    SelenideElement filter;

    @FindBy(xpath = "//div[@style = 'cursor:pointer']")
    SelenideElement addToLike;

    @FindBy(xpath = "//span[@class = 'kf-tgGA-81f77 kf-tgGW-08d79']")
    SelenideElement goToProfile;

    @FindBy(xpath = "//a[@data-name = 'profile_menu_saved_link']")
    SelenideElement liked;

    @FindBy(xpath = "//a[@data-tab = 'ads']")
    SelenideElement advtLiked;

    @FindBy(xpath = "//h3[@class = 'kf-OsXi-322fa']")
    SelenideElement titleOfCar;

    @FindBy(xpath = "//div[@style = 'cursor: pointer;']") //
    SelenideElement deleteFromLike;

    @FindBy(xpath = "//span[@class = 'kf-fQsM-b83f6 kf-fQsN-3d7dd") //снова в избранные
    SelenideElement goToProfileNextTime;

    @FindBy(xpath = "//div[@class = 'kf-pHH-b178c']") // [Ой, у вас нет избранных объявлений!], [Сохраняйте понравившиеся объявления, чтобы не потерять их.]
    SelenideElement textAboutEmpty;

    public CarPage verifyCarPage() {
        title.should(Condition.matchText("Авто"));
        subTitle.should(Condition.matchText("Популярные марки авто"));
        return this;
    }

    public CarPage selectCarBrand(String brand) {
        selectBrand.selectOptionByValue(brand);
        foundBtn.click();
        return this;
    }

    public CarPage selectFilter(String filterName) {
        selectFilter.selectOptionByValue(filterName);
        return this;
    }

    public CarPage scrollToCars() {
        filter.scrollTo();
        return this;
    }

    public CarPage selectCar(Integer index) { // не уверена, что прописала верно коллекцию, но по моей логике всё отлично:)
        List<SelenideElement> car = elements(By.xpath("//h3[@class='kf-var-8390b']"));
        for (index = 0; index < car.size(); index++){
        car.get(index).click();}
        return this;
    }

    public CarPage addCarToLiked() {
        addToLike.click();
        return this;
    }

    public CarPage verifyCarInLiked(String text) {
        goToProfile.click();
        liked.click();
        advtLiked.click();
        titleOfCar.should(Condition.matchText(text));
        return this;
    }

    public CarPage deleteCarFromLiked() {
        deleteFromLike.click();
        return this;
    }

    public CarPage verifyEmptyLiked() {
        goToProfileNextTime.click();
        liked.click();
        advtLiked.click();
        textAboutEmpty.should(Condition.matchText("Ой, у вас нет избранных объявлений!"));
        return this;
    }
}
