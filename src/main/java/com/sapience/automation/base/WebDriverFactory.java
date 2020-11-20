package com.sapience.automation.base;

import com.sapience.automation.config.Configuration;
import com.sapience.automation.factory.Log4JFactory;
import com.sapience.automation.utilities.MainUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * @author kohitij_das
 */
public class WebDriverFactory {

    private static List<WebDriverThread> webDriverThreadPool = Collections
            .synchronizedList(new ArrayList<WebDriverThread>());
    private static ThreadLocal<WebDriverThread> driverThread;
    private Logger logger = Log4JFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Method to instantiate driver and assign a thread pool.
     */
    public static void instantiateDriverObject() {
        driverThread = new ThreadLocal<WebDriverThread>() {
            @Override
            protected WebDriverThread initialValue() {
                WebDriverThread webDriverThread = new WebDriverThread();
                webDriverThreadPool.add(webDriverThread);
                return webDriverThread;
            }
        };
    }

    /**
     * Method to get the current webdriver instance.
     *
     * @return
     * @throws Exception
     */
    public static WebDriver getDriver() throws Exception {
        return driverThread.get().getDriver();
    }

    /**
     * Method to clear cookies after each test method.
     *
     * @throws Exception
     */
    //@AfterMethod
    public static void clearCookies() throws Exception {
        getDriver().manage().deleteAllCookies();
    }

    /**
     * Method to clean up webdriver instance after every suite.
     */
    @AfterSuite(alwaysRun = true)
    public static void closeDriverObjects() {
        for (WebDriverThread webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }

    @BeforeSuite(alwaysRun = true)
    public final void init() {
        logger.info("====== SettingUp Suite Execution ======");
        String envName = System.getProperty("envName");
        Properties properties = new Properties();
        try {
            properties.load(MainUtils.loadProperties(envName + ".properties"));
            Configuration.portalUrl = MainUtils.fetchProperty(properties, "portal.url");
            instantiateDriverObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}