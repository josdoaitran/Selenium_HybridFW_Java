package config;

/**************************************************************************************************
 * Desc:
 * Created by DoaiTran on 27-Oct-16.
 * Updated by Doai Tran: 01-Nov-16. => Test Suite execution engine. Source: https://goo.gl/K73xH1
 * Updated by DoaiTran: 04-Nov-16. => Ref: https://goo.gl/vbnMNq
 * Updated by DoaiTran: 08-Nov-16 => Ref: testing.reports
 *************************************************************************************************/
public class Constants {
    //********************************************************************************************
    // List all initial definition for project
    // We will define object repository file (txt)
    public static final String URL = "http://www.seleniumframework.com/";
    public static final String Path_OR = ".\\src\\testing\\objectRepository\\OR.txt";
    public static final String Path_OR_DEMO = ".\\src\\testing\\objectRepository\\OR_DEMO.txt";
    //********************************************************************************************
    //List of Data Sheet Column Numbers
    public static final int Col_TestCaseID = 0;
    public static final int Col_TestStepID = 1 ;
    public static final int Col_PageObject = 3;
    public static final int Col_ActionKeyword = 4 ;
    public static final int Col_DataSet = 5;
    // New entry in Constant Variable
    public static final int Col_RunMode = 2;
    // Create two new Constants variables for the results column of Test Case sheet and Test Step sheet
    public static final int Col_Result = 3 ;
    public static final int Col_TestStepResult = 6 ;
    // Create two new Constants variables for the Pass results & Fail result
    public static final String KEYWORD_FAIL = "FAILED";
    public static final String KEYWORD_PASS = "PASSED";
    //List of Data Engine Excel sheets
    public static final String Sheet_TestCases = "TestSuite";  //    public static final String Sheet_TestSteps = "TestCase1";
}
