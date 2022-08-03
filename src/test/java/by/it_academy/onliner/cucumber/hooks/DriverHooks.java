package by.it_academy.onliner.cucumber.hooks;

import by.it_academy.onliner.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {
    @Before
    public void setupDriver() {
        DriverManager.setupDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.quidDriver();
    }
}
