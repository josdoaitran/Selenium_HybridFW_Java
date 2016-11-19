package executionEngine;

import config.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import support.ExecuteTestcase;
import support.Keyword;
import support.Log;
import support.ReadWriteExcel;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
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
        /////////////////////////////////////////////////////////////////////////////////////////
        // Desc: Main
        // Resolve issues => make the differences to old version on web. On 28-Oct-2016 ~~ new Controller();
        //
        /////////////////////////////////////////////////////////////////////////////////////////
        DOMConfigurator.configure("log4j.xml");
        String Path_OR = Constants.Path_OR;
        FileInputStream fs = new FileInputStream(Path_OR);
        OR = new Properties(System.getProperties());
        OR.load(fs);
        ExecuteTestcase.execute_TestCase(Constants.Path_TestData,Constants.Path_SaveExcel);
    }
}
