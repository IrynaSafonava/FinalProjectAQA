package by.it_academy.onliner.parallel_remote;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityFactory {
    public DesiredCapabilities capabilities;

    public DesiredCapabilities getCapabilities(String driverType) {
        if (driverType.equals("firefox"))
            capabilities = OptionsManager.getFirefoxDesiredCapabilities();
        else
            capabilities = OptionsManager.getChromeDesiredCapabilities();
        return capabilities;
    }
}
