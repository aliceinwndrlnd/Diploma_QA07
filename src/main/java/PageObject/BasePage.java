package PageObject;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;

public abstract class BasePage {

    protected void waitPageLoaded() {
        pause(1);
        Selenide.Wait().until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    protected void pause(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void switchTo(int page) {
        Selenide.switchTo().window(page);
    }
}
