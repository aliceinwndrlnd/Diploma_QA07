package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;


public class ProfilePage {

    @FindBy (css = "body div.form_settings__control > label")
    SelenideElement chooseImgButton;

    @FindBy (css = "#upload_avatar")
    SelenideElement uploader;

    @FindBy(css = ".form_settings__media.form_settings__image > img")
    SelenideElement imageProfile;


    public ProfilePage clickChooseButton() {
        chooseImgButton.click();
        return this;
    }

    public ProfilePage uploadImg() {
        uploader.uploadFile(new File("src/test/resources/imageee.jpg"));
        return this;
    }

    public ProfilePage checkImageAvailability() {
        imageProfile.shouldBe(Condition.enabled);
        return this;
    }

    /*public ProfilePage checkImageAvailability() {
        Assert.assertEquals(imageProfile.getText(),"imagee.jpg");
        return this;
    }*/


}
