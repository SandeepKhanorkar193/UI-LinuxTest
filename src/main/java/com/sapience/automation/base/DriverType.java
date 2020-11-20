package com.sapience.automation.base;

import com.sapience.automation.config.Configuration;
import com.sapience.automation.utilities.TestConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

/**
 * @author kohitij_das
 */
public enum DriverType implements DriverSetup {

    CHROME {
        public DesiredCapabilities getDesiredCapabilities() {
            final DesiredCapabilities capabilities;

            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.acceptInsecureCerts();

            return capabilities;
        }

        public ChromeOptions getChromeOptions() {

            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            //chromePrefs.put("download.default_directory", System.getProperty("java.io.tmpdir"));
            chromePrefs.put("download.default_directory", TestConstants.DOWNLOAD_PATH);
            chromePrefs.put("download.directory_upgrade", true);
            chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1 );
            chromePrefs.put( "profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1 );
            chromePrefs.put("download.prompt_for_download", false);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--disable-notifications");


	   options.addArguments("--headless");
	        options.addArguments("window-size=1366,768");
		options.addArguments("--single-process");
		options.addArguments("--no-sandbox");

//            options.addArguments("download.default_directory="+System.getProperty("java.io.tmpdir"));
//            options.addArguments("--test-type");
//            options.addArguments("--disable-extensions");

            return options;
        }


        public WebDriver getWebDriver(DesiredCapabilities capabilities) {
            WebDriver driver = null;
            try {
                ChromeDriverService service = new ChromeDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                ChromeOptions options = new ChromeOptions();
                options = getChromeOptions();
                options.merge(capabilities);
                driver = new ChromeDriver(service, options);
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
            return driver;
        }
    },

    FIREFOX {
        public DesiredCapabilities getDesiredCapabilities() {
            final DesiredCapabilities capabilities;
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("browser.download.folderList", 2);
            firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
            //firefoxProfile.setPreference("browser.download.dir", System.getProperty("java.io.tmpdir"));
            firefoxProfile.setPreference("browser.download.dir", TestConstants.DOWNLOAD_PATH);
            firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                    "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");

            capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
            capabilities.setCapability("acceptInsecureCerts", true);
            capabilities.setJavascriptEnabled(true);
            capabilities.setCapability("marionette", true);

            return capabilities;
        }


        public WebDriver getWebDriver(DesiredCapabilities capabilities) {
            WebDriver driver = null;
            try {
                GeckoDriverService service = new GeckoDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                FirefoxOptions options = new FirefoxOptions();
                options.merge(capabilities);
                driver = new FirefoxDriver(service, capabilities);

            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
            return driver;
        }
    },

    BROWSER_STACK {
        public DesiredCapabilities getDesiredCapabilities() {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browser", System.getProperty("browserName"));
                caps.setCapability("browser_version", System.getProperty("browserVersion"));
                caps.setCapability("browserstack.debug", "true");
                caps.setCapability("build", System.getProperty("buildName"));
                caps.setCapability("project", "NGP_MVP_CERTIFICATION");
                return caps;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }

        public WebDriver getWebDriver(DesiredCapabilities capabilities) {
            try {
                return new RemoteWebDriver(new URL(Configuration.browserURL), capabilities);
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
}
