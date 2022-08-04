package by.it_academy.onliner.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FireFoxDriverCreator implements WebDriverCreator{
    @Override
    public RemoteWebDriver create() {
        return new FirefoxDriver();
    }
}
