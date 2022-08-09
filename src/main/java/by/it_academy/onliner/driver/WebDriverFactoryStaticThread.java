package by.it_academy.onliner.driver;

import by.it_academy.onliner.framework.PropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebDriverFactoryStaticThread {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static CapabilityFactory capabilityFactory = new CapabilityFactory();
    private static final int IMPLICIT_WAIT_TIMEOUT = 5;
    private static final int PAGE_LOAD_TIMEOUT = 20;

    public static void setDriver(String browser) {
        String property = PropertiesReader.getEndpointProperty("webdriver.thread");
        if ("local".equals(property)) {
            setLocalDriver(browser);
        } else if ("remote".equals(property)) {
            setRemoteDriver(browser);
        }
    }

    private static void setLocalDriver(String browser) {
        switch (browser) {
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

    private static void setRemoteDriver(String browser) {
        try {
            driver.set(new RemoteWebDriver(new URL("http://172.19.160.1:4444/"),
                    capabilityFactory.getCapabilities(browser)));
        } catch (MalformedURLException e) {
            System.out.println("Cannot create connection with remote server");
            e.printStackTrace();
        }
    }



    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().close();
        driver.remove();
    }
}
