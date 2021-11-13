package PageObject;

import PageObject.Enum.AudiCars;
import PageObject.Enum.Car;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


public class CarPage {

    @FindBy(xpath = "//div[@data-name='logo_auto']")
    SelenideElement title;

    @FindBy(xpath = "//section[@data-cy='auto-section-popular-brands']//h3")
    SelenideElement subTitle;

    @FindBy(xpath = "//div[@style = 'cursor:pointer']")
    SelenideElement addToLike;

    @FindBy(xpath = "//div[@data-name = 'user_profile_pic']//span")
    SelenideElement goToProfile;

    @FindBy(xpath = "//a[@data-name = 'profile_menu_saved_link']")
    SelenideElement liked;

    @FindBy(xpath = "//a[@data-tab = 'ads']")
    SelenideElement advtLiked;

    @FindBy(xpath = "//a[contains(@href,'auto.kufar.by/vi')]//h3")
    SelenideElement titleOfCar;

    @FindBy(xpath = "//div[@style = 'cursor: pointer;']") //
    SelenideElement deleteFromLike;

    @FindBy(xpath = "//p[contains(text(), 'Ой')]") // [Ой, у вас нет избранных объявлений!], [Сохраняйте понравившиеся объявления, чтобы не потерять их.]
    SelenideElement textAboutEmpty;

    public CarPage verifyCarPage() {
        title.should(Condition.matchText("Авто"));
        subTitle.should(Condition.matchText("Популярные марки авто"));
        return this;
    }

    public CarPage moveToAudiCars(AudiCars audiCars) {
        Selenide.actions().moveToElement(audiCars.getElement()).perform();
        return this;
    }

    public CarPage clickOnCar(Car car) {
        car.getElement().click();
        return this;
    }

    public CarPage addCarToLiked() {
        addToLike.click();
        return this;
    }

    public CarPage verifyCarInLiked() {
        goToProfile.click();
        liked.click();
        advtLiked.click();
        titleOfCar.should(Condition.matchText(titleOfCar.getText()));
        return this;
    }

    public CarPage deleteCarFromLiked() {
        deleteFromLike.click();
        return this;
    }

    public CarPage verifyEmptyLiked() {
        goToProfile.click();
        liked.click();
        textAboutEmpty.should(Condition.matchText(textAboutEmpty.getText()));
        return this;
    }
}
