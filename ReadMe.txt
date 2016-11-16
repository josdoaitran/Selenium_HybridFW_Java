Framework for Automation testing.
Created by DoaiTran.
========================
Version 1 (08-Nov-2016)
========================
Support:
+ Browsers: FF V.47.0.2; Chrome (Lasted version); IE (10;11)
+ Tested on Windows 10.
+ Excel 2003 - 2016.
+ Exception handling: Take screenshot for failed steps.
=========== Keywords==========
- browserType
    + Can select / input type of browser: Chrome, FF, IE.
    + Default browser: FF ~ FireFox
- navigateToURL
    Set the browser to go to URL (Defined on OR ~ Object Repository file)
- navigateTo
    Go to the URL (Define on data test column on Excel file)
- clickElement

- closeBrowser

- closeBrowser

- waitandPause

- input

- getscreenshot
    + To take screenshots for failed steps on a test cases.
    + Screenshot file be named following naming convention.
    + Error__[TestCase]__[TestStep] (Eg: Error__HOME_SITE_01__TS003.png)