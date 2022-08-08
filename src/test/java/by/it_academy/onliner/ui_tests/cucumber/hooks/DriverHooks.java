package by.it_academy.onliner.ui_tests.cucumber.hooks;

import by.it_academy.onliner.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {
    @Before
    public void setupDriver() {
        DriverManager.startBrowser();
    }

    @After
    public void quitDriver() {
        DriverManager.quidDriver();
    }
}
