package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;


public class ProfilePage {

    @FindBy (css = "body div.form_settings__control > label")
    SelenideElement chooseImgButton;

    @FindBy (css = "#upload_avatar")
    SelenideElement uploader;


    public ProfilePage clickChooseButton() {
        chooseImgButton.click();
        return this;
    }

    public ProfilePage uploadImg() {
        uploader.uploadFile(new File("src/test/resources/imageee.jpg"));
        return this;
    }


}
