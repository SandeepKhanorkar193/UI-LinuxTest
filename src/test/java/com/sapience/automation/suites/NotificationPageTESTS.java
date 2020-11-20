package com.sapience.automation.suites;

import com.sapience.automation.base.BaseTest;
import com.sapience.automation.base.WebDriverFactory;
import com.sapience.automation.config.Configuration;
import com.sapience.automation.factory.Log4JFactory;
import com.sapience.automation.listeners.MethodListener;
import com.sapience.automation.utilities.AppAssert;
import com.sapience.automation.utilities.TestConstants;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

@Listeners({MethodListener.class})
public class NotificationPageTESTS extends BaseTest {

    Logger logger = Log4JFactory.getLogger(this.getClass().getSimpleName());


    @Test(groups = {TestConstants.TEST_GROUP_SMOKE}, description = "TC25245")
    public void verify_google() throws Exception {
        try {
            WebDriverFactory.getDriver().get(Configuration.portalUrl);
            logger.info("URL : " + WebDriverFactory.getDriver().getCurrentUrl());

	    logger.info("ELEMENT : "+ WebDriverFactory.getDriver().findElement(By.xpath(".//*[@id='submitButton']")).getText());

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            AppAssert.assertTrue(false, ex.getMessage());
        }


    }

}
