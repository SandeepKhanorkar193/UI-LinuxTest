package com.sapience.automation.base;

import com.sapience.automation.factory.Log4JFactory;
import com.sapience.automation.utilities.AppAssert;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;

public class BaseTest extends WebDriverFactory{

    static Logger logger = Log4JFactory.getLogger(BaseTest.class.getSimpleName());
}
