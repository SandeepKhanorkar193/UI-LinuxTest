package com.sapience.automation.listeners;

import com.sapience.automation.factory.Log4JFactory;
import com.sapience.automation.utilities.MainUtils;
import org.apache.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * @author kohitij_das
 */
public class MethodListener implements IInvokedMethodListener {

    Logger logger = Log4JFactory.getLogger(this.getClass().getSimpleName());

    public void beforeInvocation(IInvokedMethod method, ITestResult result) {
        MainUtils.testStart(logger, method.getTestMethod().getMethodName());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        String testResult;
        switch (result.getStatus()) {
            case 1:
                testResult = "Passed";
                break;
            case 2:
                testResult = "Failed";
                break;
            case 3:
                testResult = "Skipped";
                break;
            default:
                testResult = "Unknown";
        }
        logger.info("Result: " + testResult);
        MainUtils.testEnd(logger, method.getTestMethod().getMethodName());
    }
}
