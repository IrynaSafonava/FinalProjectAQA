package by.it_academy.onliner.parallel_remote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactoryStaticThreadRemote {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static CapabilityFactory capabilityFactory = new CapabilityFactory();

    public static void setDriver(String browser) {
        try {
            driver.set(new RemoteWebDriver(new URL("http://192.168.100.3:5555/"),
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
