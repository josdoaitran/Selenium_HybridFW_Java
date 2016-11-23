package support;

import config.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static executionEngine.Controller.OR;
import static support.ExecuteTestcase.*;


/**
 * Created by DoaiTran on 26-Oct-16.
 * Create all definitions for actions on Selenium
 */
public class Keyword {
    public static WebDriver DRIVER;
    public static void openBrowser(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to define the browser
        // Created by DoaiTran. Date: 26-Oct-2016
        // The lasted updated by: DoaiTran 04-Nov-2016 Ref: https://goo.gl/qRMJtv
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Log.info("Opening Browser");
        try {
            switch (data) {
                case "FF":
                    DRIVER = new FirefoxDriver();
                    DRIVER.manage().window().maximize();
                    break;
                case  "Chrome":
                    DRIVER= new ChromeDriver();
                    DRIVER.manage().window().maximize();
                    break;
                case "IE":
                    DRIVER = new InternetExplorerDriver();
                    DRIVER.manage().window().maximize();
                    break;
                case "":
                    DRIVER = new FirefoxDriver();
                    DRIVER.manage().window().maximize();
                    break;
            }
        }catch (Exception e){
            Log.info("Not able to open Browser --- " + e.getMessage());
            ExecuteTestcase.bResult = false;
        }
    }
    public static void navigateToURL (String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to navigate to BASE_URL
        // Created by DoaiTran. 26-Oct-2016
        // The lasted updated by: Doai Tran 27-Oct-2016
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            Log.info("Navigating to URL");
            DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            DRIVER.navigate().to(Constants.URL);
        }catch (Exception e){
            Log.info("Not able to navigate to URL --- "+ e.getMessage());
            ExecuteTestcase.bResult = false;
        }
    }

    public static void navigateTo (String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to navigate to BASE_URL
        // Created by DoaiTran. 26-Oct-2016
        // The lasted updated by: Doai Tran 27-Oct-2016
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            Log.info("Navigating to specify URL");
            DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            DRIVER.navigate().to(data);
        }catch (Exception e){
            Log.info("Not able to navigate to URL --- "+ e.getMessage());
            ExecuteTestcase.bResult = false;
        }
    }
    public static void closeBrowser(String object,String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to close browser
        // Created by DoaiTran. On: 26-Oct-2016
        // Updated by: DoaiTran. On: 27-Oct-2016
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            Log.info("Closing the browser");
            DRIVER.quit();
        }catch (Exception e){
            Log.info("Not able to close Browser --- "+ e.getMessage());
            ExecuteTestcase.bResult = false;
        }
    }
    public static void clickElement(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to click on Elements
        // Created by DoaiTran. 26-Oct-2016
        // Updated by: DoaiTran 27-Oct-2016
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            Log.info("Clicking on WebElement "+ object);
            DRIVER.findElement(By.xpath(OR.getProperty(object))).click();
        }catch (Exception e){
            Log.info("Not able to click on Element --- "+ e.getMessage());
            ExecuteTestcase.bResult = false;
        }
    }
    public static void clickElementByLinkText(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to clickElementByLinkText
        // Created by DoaiTran. 26-Oct-2016
        // Updated by: DoaiTran 27-Oct-2016
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            Log.info("Clicking on WebElement ByLinkText "+ object);
            DRIVER.findElement(By.linkText(OR.getProperty(object))).click();
        }catch (Exception e){
            Log.info("Not able to click on Element --- "+ e.getMessage());
            ExecuteTestcase.bResult = false;
        }
    }
    public static void waitAndPause(String object,String data) throws InterruptedException {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to pause all actions with time (MilSecond).
        // Created by DoaiTran. On: 26-Oct-2016
        // Updated by DoaiTran. On 28-Oct-2016
        // Status: Passed
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Wait for 5 seconds");
            //int ndata = Integer.parseInt(data);
            Thread.sleep(5000);
        }
        catch (Exception e){
            Log.info("Not able to wait --- "+ e.getMessage());
            ExecuteTestcase.bResult = false;
        }
    }
    public static void inputValue(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to clear and input data to text box.
        // Created by DoaiTran. On: 07-Nov-2016
        // Updated:
        // Status: Passed
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Input value "+ object + " with data: " + data);
            WebDriverWait wait = new WebDriverWait(DRIVER, 15);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(object)))).clear();
            DRIVER.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
        }catch (Exception e){
            Log.info("Not able to input --- "+ e.getMessage());
            ExecuteTestcase.bResult = false;
        }
    }
    public static void clearTextBox(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to clear data on text box
        // Created by DoaiTran. On: 07-Nov-2016
        // Updated :
        // Status: Passed
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Clear data on text box");
            WebDriverWait wait = new WebDriverWait(DRIVER, 15);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(object)))).clear();
        }catch (Exception e){
            Log.info("Not able to clear text box" + e.getMessage());
            ExecuteTestcase.bResult = false;
        }
    }
    public static void submit(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to submit button
        // Created by DoaiTran. On: 13-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Submit the button");
            WebDriverWait wait = new WebDriverWait(DRIVER, 15);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(object)))).submit();
        }catch (Exception e){
            Log.info("Not able ti submit button"+e.getMessage());
            ExecuteTestcase.bResult =false;
        }
    }
    public static void navigateToBack(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to navigate to Back page
        // Created by DoaiTran. On: 13-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Navifate to back page");
            DRIVER.navigate().back();
            Thread.sleep(5000);
        }catch (Exception e){
            Log.info("Not able to NavigatetoBack");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void  navigatetoForward(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to navigate to Forward
        // Created by DoaiTran. On: 13-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Navigate to Forward page");
            DRIVER.navigate().forward();
        }catch (Exception e){
            Log.info("Not able to NavigatetoForward");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void refreshPage(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to refresh page
        // Created by DoaiTran. On: 13-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Refresh page");
            DRIVER.navigate().refresh();
        }catch (Exception e){
            Log.info("Not able to refresh page");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void  moveToElement(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to movetoElement
        // Created by DoaiTran. On: 13-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Hover to element and click");
            Actions actions = new Actions(DRIVER);
            WebElement Element = DRIVER.findElement(By.xpath(OR.getProperty(object)));
            actions.moveToElement(Element).perform();
        }catch (Exception e){
            Log.info("Not able to movetoElement");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void doubleClick(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to doubleClick
        // Created by DoaiTran. On: 20-Nov-2016
        // Updated :            Date:
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("DoubleClick on Element: " + data);
            Actions actions = new Actions(DRIVER);
            WebElement Element = DRIVER.findElement(By.xpath(OR.getProperty(object)));
            actions.doubleClick().perform();
        }catch (Exception e){
            Log.info("Not able to doubleClick on Element: " + data);
            ExecuteTestcase.bResult = false;
        }
    }
    public static void  waitForElementPresent(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to waitForElementPresent
        // Created by DoaiTran. On: 20-Nov-2016
        // Updated :
        // Status: Passed
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Wait for element present");
            WebDriverWait wait = new WebDriverWait(DRIVER, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object))));
        }catch (Exception e){
            Log.info("Element is not presented");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void verifyElementIsExisted(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to Verify element is existedt
        // Created by DoaiTran. On: 20-Nov-2016
        // Updated :
        // Status: Passed
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Verify Element is existed.");
            WebDriverWait wait = new WebDriverWait(DRIVER, 15);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(object))));
        }catch (Exception e) {
            Log.info("Element is not existed.");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void verifyText(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to verify actual text and expected text.
        // Created by DoaiTran. On: 21-Nov-2016
        // Updated :
        // Status: Passed
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("verify text between get from element and expected text: "+ data);
            String actualText = DRIVER.findElement(By.xpath(OR.getProperty(object))).getText();
            if(actualText.equals(data)){
                ExecuteTestcase.bResult = true;
                Log.info("Expected text and actual text are the same.");
            }else {
                ExecuteTestcase.bResult = false;
                Log.info("Actual text and expected text are different.");
            }
        }catch(Exception e){
            Log.info("Not able to verify text.");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void closeAllBrowsers(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to kill all browser processes.
        // Created by DoaiTran. On: 21-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Try to kill all browser processes.");
            taskkill("Chrome");
            taskkill("IE");
            taskkill("FF");
        }catch (Exception e){
            Log.info("Not able to kill all processes.");
            ExecuteTestcase.bResult = false;
        }
    }
    // Support: https://technet.microsoft.com/en-us/library/bb491009.aspx
    private static void taskkill(String strProcessName){
        String strCmdLine = null;
        //Runtime rt = Runtime.getRuntime();
        switch (strProcessName){
            case "Chrome" : strCmdLine = String.format("taskkill /im chrome.exe /f /t >nul 2>&1"); break;
            case "IE" :     strCmdLine = String.format("taskkill /im iexplore.exe /f /t >nul 2>&1"); break;
            case "FF":      strCmdLine = String.format("taskkill /im firefox.exe /f /t >nul 2>&1"); break;
        }
        try {
            Runtime.getRuntime().exec(strCmdLine);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void waitForAjax(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to waitForAjax.
        // Created by DoaiTran. On: 21-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            Log.info("Wait for Ajax script be executed.");
            new WebDriverWait(DRIVER, 180).until(new ExpectedCondition<Boolean>()
            {
                public Boolean apply(WebDriver driver) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    return (Boolean)js.executeScript("return jQuery.active == 0");
                }
            });
        }catch (Exception e){
            Log.info("Error Ajax script waiting.");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void selectByVisibleText(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to select By Visible Text
        // Created by DoaiTran. On: 21-Nov-2016
        // Updated :
        // Status: Passed
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Try to select by visible text.");
            Select selectAction =  new Select(DRIVER.findElement(By.xpath(OR.getProperty(object))));
            selectAction.selectByVisibleText(data);
        }catch (Exception e){
            Log.info("Unable to select by visible text.");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void selectByValue(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to select By Value
        // Created by DoaiTran. On: 21-Nov-2016
        // Updated :
        // Status: Passed
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Try to select by value.");
            Select selectAction =  new Select(DRIVER.findElement(By.xpath(OR.getProperty(object))));
            selectAction.selectByValue(data);
        }catch (Exception e){
            Log.info("Unable to select by value.");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void selectByIndex(String object, int data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to select By Index
        // Created by DoaiTran. On: 21-Nov-2016
        // Updated :
        // Status: Passed
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Try to select by index.");
            Select selectAction =  new Select(DRIVER.findElement(By.xpath(OR.getProperty(object))));
            selectAction.selectByIndex(data);
        }catch (Exception e){
            Log.info("Unable to select by index.");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void  switchToIFrameWithName(String object, String data){
        //***************************************************
        //**  Desc: this function use to switch frame on page. It's used before hover_on_menu, and click_element functions
        //**        Three functions use to click on submenu on page
        //**  Currently, "switch_to.frame(str_frame_name)" work well on latest IE and chrome. Not work on new FF version (Verified:NOT YET)
        //**  On FF should add more wait time.
        //**  Created By: DoaiTran
        //**  Created Date: 21-Nov-2016
        //**  Modification History:
        //**         Modify by:            Date:       Note:
        //****************************************************
        try{
            Log.info("To switch to iFrame with name");
            List<WebElement> iframes = DRIVER.findElements(By.tagName("iframe")); // (By.xpath("//iframe"));
            for (WebElement iframe : iframes) {
                System.out.println(iframe);
                if(iframe.getAttribute("name").equals(data)){
                    DRIVER.switchTo().frame(data);
                    break;
                }
            }
        }catch (Exception e){
            Log.info("Unable to switch to iFrame with name");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void  switchToIFrameWithID(String object, String data){
        try{
            Log.info("To switch to iFrame with iFrameID");
            List<WebElement> iframes = DRIVER.findElements(By.id("iframe"));
            for (WebElement iframe : iframes) {
                System.out.println(iframe);
                if(iframe.getAttribute("id").equals(data)){
                    DRIVER.switchTo().frame(data);
                    break;
                }
            }
        }catch (Exception e){
            Log.info("Unable to switch to iFrame with iFrame ID");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void switchToMainPage(String object, String data){
        //***************************************************
        //**  Desc: this function use to switch frame to main page.
        //**  Currently, "switch_to.frame(str_frame_name)" work well on latest IE and chrome. Not work on new FF version (Verified:NOT YET)
        //**  Created By: DoaiTran
        //**  Created Date: 21-Nov-2016
        //**  Modification History:
        //**         Modify by:            Date:       Note:
        //****************************************************
        try{
            Log.info("To switch to Main Page");
            DRIVER.switchTo().defaultContent();
        }catch (Exception e){
            Log.info("Unable to switch to Main Page");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void  verifyTextInTable(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to verify text in table
        // Created by DoaiTran. On: 22-Nov-2016
        // Updated :
        // Status: Passed
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        boolean valueResult = false;
        try{
            List<WebElement> listCell = DRIVER.findElements(By.xpath(OR.getProperty(object)));
            for (WebElement iCell: listCell){
                if(iCell.getText().equals(data)){
                    Log.info("Value on table is existing.");
                    //System.out.println("Value on table is existing.");
                    valueResult = true;
                    break;
                }else {
                    Log.info("Value on table is not existing.");
                    //System.out.println("Value on table is not existing.");
                    valueResult = false;
                }
            }
            if(valueResult == true){
                ExecuteTestcase.bResult = true;
            }else {
                ExecuteTestcase.bResult = false;
            }
        }catch (Exception e){
            Log.info("Unable to verify text.");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void verifyCheckboxIsChecked(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to verify Checkbox Is Checked
        // Created by DoaiTran. On: 23-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            WebElement checkbox = DRIVER.findElement(By.xpath(OR.getProperty(object)));
            if(checkbox.isSelected() == true){
                Log.info("CheckBox is checked.");
            }else{
                Log.info("CheckBox is NOT checked.");
                ExecuteTestcase.bResult = false;
            }
        }catch (Exception e) {
            Log.info("Unable to verify checkbox is checked or not.");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void verifyCheckboxIsNotChecked(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to verify Checkbox Is NOT Checked
        // Created by DoaiTran. On: 23-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            WebElement checkbox = DRIVER.findElement(By.xpath(OR.getProperty(object)));
            if(checkbox.isSelected() == false){
                Log.info("CheckBox is NOT checked.");
            }else{
                Log.info("CheckBox is checked.");
                ExecuteTestcase.bResult = false;
            }
        }catch (Exception e) {
            Log.info("Unable to verify checkbox is checked or not.");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void verifyRadioIsChecked(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to verify Radio Is Checked
        // Created by DoaiTran. On: 23-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            WebElement radio = DRIVER.findElement(By.xpath(OR.getProperty(object)));
            if(radio.isSelected() == true){
                Log.info("Radio is checked.");
            }else{
                Log.info("Radio is NOT checked.");
                ExecuteTestcase.bResult = false;
            }
        }catch (Exception e) {
            Log.info("Unable to verify checkbox is checked or not.");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void verifyRadioIsNotChecked(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to verify Radio Is Not Checked
        // Created by DoaiTran. On: 23-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            WebElement radio = DRIVER.findElement(By.xpath(OR.getProperty(object)));
            if(radio.isSelected() == false){
                Log.info("Radio is NOT checked.");
            }else{
                Log.info("Radio is checked.");
                ExecuteTestcase.bResult = false;
            }
        }catch (Exception e) {
            Log.info("Unable to verify checkbox is checked or not.");
            ExecuteTestcase.bResult = false;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //  Exception handling
    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void getscreenshot() throws Exception {
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Created by DoaiTran. On : 26-Oct-2016
        //  Updated on 08-Nov-2016 for error steps.
        //  Format of screenshot file name: Error__"TestCaseID"__"TestStepName"__"TimeStampValue".png
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        File scrFile = ((TakesScreenshot) DRIVER).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src\\testing\\reports\\imagesLog\\" + "Error__" + testsuiteName+"__"+ sTestCaseID + "__" + TestStepName + "__" + GetTimeStampValue() + ".png"));
    }
    public  static String GetTimeStampValue()throws IOException {
        Calendar cal = Calendar.getInstance();
        java.util.Date time = cal.getTime();
        String timestamp = time.toString();
        System.out.println(timestamp);
        String systime = timestamp.replace(":", "-");
        System.out.println(systime);
        return systime;
    }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
