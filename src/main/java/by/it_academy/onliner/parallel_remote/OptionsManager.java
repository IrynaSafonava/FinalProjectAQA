package by.it_academy.onliner.parallel_remote;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OptionsManager {
    public static DesiredCapabilities getChromeDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.WIN10);
        desiredCapabilities.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return desiredCapabilities.merge(options);
    }

    public static DesiredCapabilities getFirefoxDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.WIN10);
        desiredCapabilities.setBrowserName("firefox");
        return desiredCapabilities;
    }
}
