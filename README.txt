In order to complete this assignment I have used the following Softwares,
------------------------------------------------------------------------------------------------
1.  Java-1.8,
2.  Selenium WebDriver with Core Java binding,
3.  Maven
4.  TestNG
5.  Eclipse IDE

Instructions to run this assignment
---------------------------------------------
1. Clone project from github 
  i.e git clone https://github.com/lokeshkp/RecruiterboxTest.git,
2. Open command prompt and navigate to project location,
3. type "mvn test site"

Note: I have placed chromedriver & gekodriver in repositary (/src/main/java/browsers) it self hence no need to download,

To run selenium scripts on safari & mac os please follow the bellow instructions,
------------------------------------------------------------------------
1. Hope JDK already installed & configured in your mac book if not plz install and configure,
2. Download the Safari Browser Extension and  Install the Safari Browser Extension,
3. Enable WebDriver browser Extension – Now open the preferences pane on Safari browser. Go to Safari >> Preferences  and open the preferences window. In the  preferences window select Extension. There you will find Selenium web driver listed in the extensions list, select the check box,
4. Enable "Allow Remote Automation" which is located in Safari Browser>>Develop>>Allow Remote Automation
5. Restart your Browser – and excute it

Note : Make sure that you have “Enable WebDriver“ check-box enabled.
Note : I have configured browser safari in the following properties file (i.e /RecruiterboxTestLOK/src/main/java/com/makemytrip/config/config.properties)
so if you would like run selenium scripts on chrome/firefox please change here.
