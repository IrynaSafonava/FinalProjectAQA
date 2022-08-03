package by.it_academy.onliner.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Optional;

import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;
//import static org.openqa.selenium.firefox.GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY;

public class DriverManager {
    private static final String CHROME_DRIVE_PATH =
            "C:\\Users\\Iryna\\webdrivers\\chromedriver.exe";
//
//    private static final String GECKO_DRIVE_PATH =
//            "C:\\Users\\Iryna\\webdrivers\\geckodriver.exe";
    private static final int IMPLICIT_WAIT_TIMEOUT = 5;
    private static final int PAGE_LOAD_TIMEOUT = 20;
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setupDriver() {
        WebDriver driver = null;
        String driverType = "firefox";
        switch (driverType) {
            case "chrome" -> {
                //System.setProperty("webdriver.chrome.driver", "chrome.driver.path");
                driver = new ChromeDriver();
            }
            case "firefox" -> {
//                System.setProperty("webdriver.gecko.driver", "gecko.driver.path");
                driver = new FirefoxDriver();
            }
        }

//        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVE_PATH);
//        WebDriver driver = new ChromeDriver();
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

    public static String getDriverType() {
        return System.getProperty("driverType");
    }
}
