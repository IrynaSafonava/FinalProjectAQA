package by.it_academy.onliner.parallel_local;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverFactoryStaticThreadLocal {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final int IMPLICIT_WAIT_TIMEOUT = 5;
    private static final int PAGE_LOAD_TIMEOUT = 20;
    public static void setDriver(String driverType) {
        switch (driverType) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            }
            default -> System.out.println("No driverType found");
        }
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().close();
        driver.remove();
    }
}
