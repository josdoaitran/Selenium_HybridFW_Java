package support;

import config.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static executionEngine.Controller.*;
import static support.ExecuteTestcase.TestStepName;
import static support.ExecuteTestcase.sTestCaseID;
import static support.ExecuteTestcase.testsuiteName;


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
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
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
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
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
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
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
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("Refresh page");
            DRIVER.navigate().refresh();
        }catch (Exception e){
            Log.info("Not able to refresh page");
            ExecuteTestcase.bResult = false;
        }
    }
    public static void  movetoElement(String object, String data){
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Des: This function is used to movetoElement
        // Created by DoaiTran. On: 13-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
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
        // Created by DoaiTran. On: 13-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            Log.info("doubleClick on Element: " + data);
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
        // Created by DoaiTran. On: 13-Nov-2016
        // Updated :
        // Status:
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            WebDriverWait wait = new WebDriverWait(DRIVER, 15);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty(object))));
        }catch (Exception e){
            Log.info("Not able to doubleClick on Element: ");
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
