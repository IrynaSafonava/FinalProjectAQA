package by.it_academy.onliner.driver;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface WebDriverCreator<T extends RemoteWebDriver> {
    T create();
}
