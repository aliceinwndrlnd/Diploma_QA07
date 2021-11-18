package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;


public class ProfilePage extends BasePage{

    @FindBy (css = "#upload_avatar")
    SelenideElement uploader;

    @FindBy(css = ".form_settings__media.form_settings__image > img")
    SelenideElement imageProfile;


    public ProfilePage uploadImg() {
        uploader.uploadFile(new File("src/test/resources/imageee.jpg"));
        return this;
    }

    public ProfilePage checkImageAvailability() {
        imageProfile.shouldBe(Condition.enabled);
        return this;
    }
}
