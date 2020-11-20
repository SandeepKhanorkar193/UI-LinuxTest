package com.sapience.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author kohitij_das
 */
public interface DriverSetup {

    WebDriver getWebDriver(DesiredCapabilities desiredCapabilities);

    DesiredCapabilities getDesiredCapabilities();

}
