package by.it_academy.onliner.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Optional;

public class DriverManager {
    private static final int IMPLICIT_WAIT_TIMEOUT = 5;
    private static final int PAGE_LOAD_TIMEOUT = 20;
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static CapabilityFactory capabilityFactory = new CapabilityFactory();

    private DriverManager() {
        if (webDriverThreadLocal.get() == null) {
            startBrowser();
        }
    }

    public static void startBrowser() {
        setupDriver(Driver.getByDriverType(System.getProperty("driverType"))
                .getWebDriverCreator()
                .create());
    }

    private static void setupDriver(RemoteWebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void quidDriver() {
        Optional.ofNullable(getDriver()).ifPresent(webDriver -> {
            webDriver.quit();
            webDriverThreadLocal.remove();
        });
    }
}
