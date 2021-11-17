package Driver;

import Properties.PropertyReader;
import TestNG.Listener;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;

@Log4j2
@Listeners(Listener.class)
public class BaseTestSelenide {

    public <PageObjectClass> PageObjectClass get(Class<PageObjectClass> pageObjectClassClass) {
        return driver().hasWebDriverStarted() ? page(pageObjectClassClass) : open(PropertyReader.getProperties().getProperty("url"), pageObjectClassClass);
    }

    @AfterTest(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }
}