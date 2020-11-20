package com.sapience.automation.utilities;

import com.google.common.base.Strings;
import com.sapience.automation.base.WebDriverFactory;
import com.sapience.automation.config.Configuration;
import com.sapience.automation.config.Constants;
import com.sapience.automation.factory.Log4JFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author kohitij_das
 */
public class CommonMethods {

    Logger logger = Log4JFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Method to wait until pageLoad complete event.
     */
    public void waitForPageToLoad() {
        try {
            int count = Integer.parseInt(Constants.TIMEOUT) / 1000;
            String pageLoaded;
            final JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getDriver();
            final String status = "return window.document.readyState;";
            do {
                pageLoaded = (String) js.executeScript(status);
                Thread.sleep(1000);
                count--;
                if (count <= 0) {
                    pageLoaded = "complete";
                    break;
                }
            } while (!pageLoaded.equalsIgnoreCase("complete"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method to return map of params from file
     *
     * @param filePath
     * @return paramMap
     */
    public HashMap getMapFromFileContent(String filePath) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();

        String line;
        BufferedReader reader = new BufferedReader(new FileReader((filePath)));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
        reader.close();

        return map;
    }

    /**
     * @param element
     * @return
     */
    public void clickUsingJavaScript(WebElement element) throws Exception {

        try {
            if (element.isEnabled() && element.isDisplayed()) {
                ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
                System.out.println("Scrolled to element view");
                Thread.sleep(1000);
                ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element " + e.getStackTrace());
        }

    }

    public void enterTextUsingJavaScript(WebElement element, String inputText) throws Exception {

        try {
            if (element.isEnabled() && element.isDisplayed()) {
                ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
                System.out.println("Scrolled to element view");
                Thread.sleep(1000);
                ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].click();", element);

                String js = "arguments[0].setAttribute('value','" + inputText + "')";
                ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript(js, element);
            } else {
                System.out.println("Unable to Enter Text in element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element " + e.getStackTrace());
        }

    }

    public void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
        }
    }

    /**
     * @throws Exception
     */
    public void refreshPage() throws Exception {
        WebDriverFactory.getDriver().navigate().refresh();
    }

    /**
     * @param element
     * @param timeout
     * @throws Exception
     */
    public void waitForElementVisible(WebElement element, int timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * @param elementList
     * @param timeout
     * @throws Exception
     */
    public void waitForVisibilityOfAllElements(List<WebElement> elementList, int timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    /**
     * @param element
     * @param timeout
     * @throws Exception
     */
    public void waitForElementClickable(WebElement element, int timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * @param elementList
     * @return
     */
    public ArrayList<String> getElementTextList(List<WebElement> elementList) {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        for (WebElement element : elementList) {
            stringArrayList.add(element.getText().trim());
        }
        Collections.sort(stringArrayList);
        return stringArrayList;
    }

    public String strStringFormatting(String mainString, String startText, String endText, int StartTextIndex) {
        return mainString.replace(mainString.substring(mainString.lastIndexOf(startText) + StartTextIndex, mainString.lastIndexOf(endText) - 1), "XXXX");

    }

    public void performActionOnWebElement(WebElement webElement) throws Exception {
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.moveToElement(webElement).perform();
        action.click(webElement).perform();
    }

    public void performDoubleClick(WebElement element) throws Exception {
        Actions actions = new Actions(WebDriverFactory.getDriver());
        actions.doubleClick(element).perform();
    }

    public void performMoveToElement(WebElement element) throws Exception {
        ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("window.scrollBy(0,0)");
        Actions actions = new Actions(WebDriverFactory.getDriver());
        actions.moveToElement(element).perform();
    }

    public void performMoveToElementForTable(WebElement element) throws Exception {
        //((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("window.scrollBy(0,1500)");
        //((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        Actions actions = new Actions(WebDriverFactory.getDriver());
        actions.moveToElement(element).perform();
    }

    public void performOnClickScript(WebElement element) throws Exception {
        String onClickScript = "if(document.createEvent){var evObj = document.createEvent(\'MouseEvents\');evObj.initEvent(\'click\',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject){ arguments[0].fireEvent(\'onclick\');}";
        ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript(onClickScript, element);
    }

    public void performActionsEscape() throws Exception {
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(Keys.ESCAPE).build().perform();
    }


    public String appendDateTime() {
        try {
            DateFormat df = new SimpleDateFormat("ss");
            Date dateobj = new Date();
            return df.format(dateobj);
        } catch (Exception e) {

        }
        return null;
    }

    public String getTodaysDate() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
        return df.format(dateobj);
    }

    public ArrayList<String> getColumnHeadings(List<WebElement> elementList, boolean isSorted) {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        String str = null;
        for (WebElement element : elementList) {
            str = element.getAttribute("innerHTML").trim();
            if (!(str.isEmpty())) {
                stringArrayList.add(element.getAttribute("innerHTML").trim());
            }
        }
        if (isSorted) {
            Collections.sort(stringArrayList);
            logger.info("Actual Collection Sorted : " + stringArrayList);
        }
        return stringArrayList;
    }

    public WebElement getElementByContent(List<WebElement> allElements, String findText) {
        for (WebElement element : allElements) {
            String content = element.getText();
            if (content.equals(findText)) {
                return element;
            }
        }
        return null;
    }

    public void scrollPageDown() throws Exception {
        WebDriver driver = WebDriverFactory.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public void scrollPageDownToElement(WebElement element) throws Exception {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
                System.out.println("Scrolled to element view");
                Thread.sleep(1000);
            } else {
                System.out.println("Unable to Enter Text in element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element " + e.getStackTrace());
        }
    }

    public void deleteIfFileExist() throws Exception {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
//        String tmpFolderPath = TestConstants.DOWNLOAD_PATH;
//        logger.info("File Path : " + tmpFolderPath);
//        File file = new File(tmpFolderPath + expectedFileName);
//        if (file.exists())
//            file.delete();

        logger.info("File Path : " + TestConstants.DOWNLOAD_PATH);
        File dir = new File(TestConstants.DOWNLOAD_PATH);
        File[] dir_contents = dir.listFiles();

        logger.info("Files : " + dir_contents.length);
        for (int i = 0; i < dir_contents.length; i++) {
            logger.info("FileName : " + dir_contents[i].getName());
            dir_contents[i].delete();
            logger.info("File Deleted : " + dir_contents[i].getName());
        }
    }

    public boolean isFileDownloaded(String fileName) {
        boolean flag = false;
        logger.info("File Path : " + TestConstants.DOWNLOAD_PATH);
        File dir = new File(TestConstants.DOWNLOAD_PATH);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag = true;
        }
        return flag;
    }

    public int isFileDownloadedExists() {
        logger.info("File Path : " + TestConstants.DOWNLOAD_PATH);
        File dir = new File(TestConstants.DOWNLOAD_PATH);
        File[] dir_contents = null;
        int counter = 0;
        do {
            pause(1000);
            dir_contents = dir.listFiles();
            counter = counter + 1;
        } while (dir_contents.length == 0 && counter <= 60);
        return dir_contents.length;
    }

    public String appendRandomNumber() {
        try {
            Random rand = new Random();
            return String.valueOf(rand.nextInt(1000));
        } catch (Exception e) {

        }
        return null;
    }
}