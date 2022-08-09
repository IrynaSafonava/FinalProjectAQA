package by.it_academy.onliner.ui_tests.cucumber.hooks;

import by.it_academy.onliner.driver.WebDriverFactoryStaticThread;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {
    @Before
    public void setupDriver() {
        WebDriverFactoryStaticThread.setDriver(System.getProperty("driverType"));
    }

    @After
    public void quitDriver() {
        WebDriverFactoryStaticThread.closeDriver();
    }
}
