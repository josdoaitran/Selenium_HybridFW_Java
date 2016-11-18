package executionEngine;

import config.Constants;
import org.apache.log4j.xml.DOMConfigurator;
import support.Keyword;
import support.Log;
import support.ReadWriteExcel;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
/**
 * Desc: This function is to set the control / Driver Script
 * Created by DoaiTran on 27-Oct-16.
 * Updated by DoaiTran on 13-Nov-16.
 * Solution: https://goo.gl/iy3KJV
 * Version 2 => using
 */
public class Controller {
    //
    public static Properties OR;
    public static Keyword actionKeywords;
    public static String sActionKeyword;
    public static String sPageObject;
    public static Method method[];
    //
    public static int iTestStep;
    public static int iTestLastStep;
    public static String sTestCaseID;
    public static String TestStepName;
    public static String sRunMode;
    public static String sData;
    public static boolean bResult;
    public static String SheetName;
    public static boolean sTestCaseResult;
    //
    public Controller() throws NoSuchMethodException, SecurityException{
        actionKeywords = new Keyword();
        method = actionKeywords.getClass().getMethods();
    }
    public static void main(String[] args)throws Exception {
        /////////////////////////////////////////////////////////////////////////////////////////
        // Desc: Main
        // Resolve issues => make the differences to old version on web. On 28-Oct-2016 ~~ new Controller();
        //
        /////////////////////////////////////////////////////////////////////////////////////////
        new Controller();
        /*File source = new File(Constants.Path_TestData);
        File dest = new File(Constants.Path_SaveExcel);
        FileUtils.copyFile(source,dest);*/
        ReadWriteExcel.setExcelFile(Constants.Path_TestData);         //This is to start the Log4j logging in the test case
        DOMConfigurator.configure("log4j.xml");
        String Path_OR = Constants.Path_OR;
        FileInputStream fs = new FileInputStream(Path_OR);
        OR = new Properties(System.getProperties());
        OR.load(fs);
        Controller startEngine = new Controller();
        startEngine.execute_TestCase();
    }
    private void execute_TestCase() throws Exception {
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  Desc: This function will be used to read TestSuite ~ SheetTestCases. And Read each specify TestSteps on each Test Casse
        //  Created by DoaiTran. 31-Oct-2016
        //  Updated: DoaiTran. 13-Nov-2016
        //  => Read TestCases that will be executed (Runmode: Yes).
        //  => Read and execute TestCase (Sheets) that named as TestSuite sheet.
        //  => TestCases will be Passed only when all steps be executed and passed.
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int iTotalTestCases = ReadWriteExcel.getNumberofRow(Constants.Sheet_TestCases);
        for (int iTestcase = 1; iTestcase <= iTotalTestCases; iTestcase++) {
            bResult = true;
            sTestCaseID = ReadWriteExcel.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
            sRunMode = ReadWriteExcel.getCellData(iTestcase, Constants.Col_RunMode, Constants.Sheet_TestCases);
            System.out.println(sTestCaseID);
            if (sRunMode.equals("Yes")) {
                System.out.println(sTestCaseID+sRunMode);
                SheetName = sTestCaseID;
                iTestStep = ReadWriteExcel.getRowContains(sTestCaseID, Constants.Col_TestCaseID, SheetName);
                iTestLastStep = ReadWriteExcel.getTestStepsCount(SheetName, sTestCaseID, iTestStep);
                System.out.println(iTestStep);
                System.out.println(iTestLastStep);
                Log.startTestCase(sTestCaseID);
                bResult = true;
                for (; iTestStep <= iTestLastStep; iTestStep++) {
                    sActionKeyword = ReadWriteExcel.getCellData(iTestStep, Constants.Col_ActionKeyword, SheetName);
                    sPageObject = ReadWriteExcel.getCellData(iTestStep, Constants.Col_PageObject, SheetName);
                    TestStepName = ReadWriteExcel.getCellData(iTestStep, Constants.Col_TestStepID, SheetName);
                    sData = ReadWriteExcel.getCellData(iTestStep, Constants.Col_DataSet, SheetName);
                    execute_Actions();
                    if (sTestCaseResult == false) {
                        ReadWriteExcel.setCellData(Constants.KEYWORD_FAIL, iTestcase, Constants.Col_Result, Constants.Sheet_TestCases);
                        Log.endTestCase(sTestCaseID);
                        System.out.println("TestCase: Failed");
                        break;
                    }
                }
                if (sTestCaseResult == true) {
                    ReadWriteExcel.setCellData(Constants.KEYWORD_PASS, iTestcase, Constants.Col_Result, Constants.Sheet_TestCases);
                    Log.endTestCase(sTestCaseID);
                    System.out.println("TestCase: Passed");
                }
                ReadWriteExcel.saveExcelFile(Constants.Path_SaveExcel);
            }
        }
    }
    private static void execute_Actions() throws Exception{
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Method to control execution of all actions.
        // And will set value "PASSED" / "FAILED" for each TestSteps.
        // Improvement: More data. Source: https://goo.gl/TB0wmO (07-Nov-16)
        // Updated on 08-Nov-16 => Reports
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(int i=0;i<method.length;i++){
            if(method[i].getName().equals(sActionKeyword)){
                method[i].invoke(actionKeywords,sPageObject,sData);
                //This code block will execute after every test step
                if(bResult==true){
                    //If the executed test step value is true, Pass the test step in Excel sheet
                    ReadWriteExcel.setCellData(Constants.KEYWORD_PASS, iTestStep, Constants.Col_TestStepResult, SheetName);
                    sTestCaseResult = true;
                    break;
                }else{
                    //If the executed test step value is false, Fail the test step in Excel sheet
                    ReadWriteExcel.setCellData(Constants.KEYWORD_FAIL, iTestStep, Constants.Col_TestStepResult, SheetName);
                    //In case of false, the test execution will not reach to last step of closing browser
                    //So it make sense to close the browser before moving on to next test case
                    Keyword.getscreenshot();
                    Keyword.closeBrowser("","");
                    sTestCaseResult = false;
                    break;
                }
            }
        }
    }
}
