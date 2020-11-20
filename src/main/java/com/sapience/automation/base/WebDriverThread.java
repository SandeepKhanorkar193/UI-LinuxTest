package com.sapience.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * @author kohitij_das
 */
public class WebDriverThread {

    private final DriverType defaultDriverType = DriverType.CHROME;
    private final String browser = System.getProperty("browser").toUpperCase();
    private WebDriver webdriver;
    private DriverType selectedDriverType;

    /**
     * Method to get the specified webdriver handle.
     *
     * @return
     * @throws Exception
     */
    public WebDriver getDriver() throws Exception {
        if (null == webdriver) {
            selectedDriverType = determineEffectiveDriverType();
            DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
            instantiateWebDriver(desiredCapabilities);
            webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webdriver.manage().window().maximize();
        }
        return webdriver;
    }

    /**
     * Method to clean up the webdriver session.
     */
    public void quitDriver() {
        if (null != webdriver) {
            webdriver.quit();
        }
    }

    /**
     * Method to determine the specified driverType.
     *
     * @return
     */
    private DriverType determineEffectiveDriverType() {
        DriverType driverType = defaultDriverType;
        try {
            driverType = DriverType.valueOf(browser);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
        } catch (NullPointerException ignored) {
            System.err.println("No driver specified, defaulting to '" + driverType + "'...");
        }
        return driverType;
    }

    /**
     * Method to instantiate the webdriver.
     *
     * @param desiredCapabilities
     */
    private void instantiateWebDriver(DesiredCapabilities desiredCapabilities) {
        webdriver = selectedDriverType.getWebDriver(desiredCapabilities);
    }
}
