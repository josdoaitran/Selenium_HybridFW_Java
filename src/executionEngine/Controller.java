package executionEngine;

import config.Constants;
import org.apache.log4j.xml.DOMConfigurator;
import support.ExecuteTestcase;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * Desc: This function is to set the control / Driver Script
 * Created by DoaiTran on 27-Oct-16.
 * Updated by DoaiTran on 19-Nov-16.
 * Solution: https://goo.gl/iy3KJV
 * Version 2 => using
 */
public class Controller {
    public static Properties OR;
    public static void main(String[] args)throws Exception {
        /******************************************************************************************************
        /** Desc: Main
        /** Resolve issues => make the differences to old version on web. On 28-Oct-2016 ~~ new Controller();
        /** Update: 19-Nov-2016      Data: Restructure data and how to execute TestSuite.
        /******************************************************************************************************/
        DOMConfigurator.configure("log4j.xml");
        String Path_OR = Constants.Path_OR;
        FileInputStream fs = new FileInputStream(Path_OR);
        OR = new Properties(System.getProperties());
        OR.load(fs);
        //****************************************************************************************************//
        // Select the test suite and test report location and input name of test suite before executed
        //****************************************************************************************************//
        //ExecuteTestcase.execute_TestCase(".\\src\\testing\\dataEngine\\TestSuite1.xlsx",".\\src\\testing\\reports\\TestResult_TestSuite1.xlsx","TestSuite1");
        ExecuteTestcase.execute_TestCase(".\\src\\testing\\dataEngine\\TestSuite-Demo.xlsx",".\\src\\testing\\reports\\TestResult_TestSuite-Demo.xlsx","TestSuite-Demo");
    }
}
