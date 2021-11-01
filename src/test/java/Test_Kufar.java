import static com.codeborne.selenide.Selenide.*;
import Driver.BaseTestSelenide;
import PageObject.LoginPage;
import org.testng.annotations.Test;


public class Test_Kufar extends BaseTestSelenide {

    @Test
    public void loginPageNegativeTest() { //ввод некорректных данных
        get(LoginPage.class)
                .closePopUpWindow()
                .clickLoginPage()
                .enterEmail("test@test.ru")
                .enterPassword("22222")
                .verifyIcons()
                .clickSubmit()
                .checkingErrorText();
    }




}
