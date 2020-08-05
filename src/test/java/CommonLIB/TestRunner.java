package CommonLIB;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.*;

import org.testng.annotations.Parameters;

import Reports.ExtentReportUtil;



@CucumberOptions(features = {"src/test/java/CuFeatures"} , 
glue = {"CuFeatures/stepdefinitions","CommonLIB"},
tags="@smoke",
plugin = "json:target/cucumber.json")       
public class TestRunner extends AbstractTestNGCucumberTests {
	
	    @Parameters({ "browser","implicitWait" })
	    @BeforeTest
	    public void BeforeTest(String browser,String implicitWait) {
	    	ExtentReportUtil.ExtentReport();
			GetBrowserElement.BrowserLaunch(browser, implicitWait);
		}
	 @AfterTest
	 public void Aftertest() {
		 GetBrowserElement.BrowserClosing();
	 }


}