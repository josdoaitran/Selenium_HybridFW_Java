Hybrid Framework for Automation testing.
Created by DoaiTran.
========================================================================================================
Version 2.2.1 (20-NOV-2016)
========================================================================================================
Support:
+ Browsers: FF V.47.0.2; Chrome (Lasted version); IE (10;11)
+ Tested on Windows 10.
+ Excel 2003 - 2016. Report: Summary report and charts.
+ Exception handling: Take screenshot for failed steps.
+ Object repositories be following by XPATH
========================================= Keywords =====================================================
    - openBrowser : Chrome, FF, IE. Default browser: FF ~ FireFox
    - navigateToURL : Set the browser to go to URL (Defined on OR ~ Object Repository file)
    - navigateTo : Go to the URL (Define on data test column on Excel file)
    - clickElement                              - moveToElement
    - closeBrowser                              - doubleClick
    - clearTextBox                              - navigateToForward
    - waitAndPause                              - navigateToBack
    - inputValue                                - submit
    - refreshPage                               - clearTextBox
    - doubleClick
======================================= Exception Handling =============================================
getscreenshot
    + To take screenshots for failed steps on a test cases.
    + testing.reports file be named following naming convention.
    + Error__[TestCase]__[TestStep] (Eg: Error__TestCase1__TS_003__Mon Nov 14 11-47-40 ICT 2016.png)
========================================================================================================