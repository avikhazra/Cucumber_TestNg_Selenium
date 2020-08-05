package CuFeatures.stepdefinitions;

import org.openqa.selenium.By;


import com.aventstack.extentreports.GherkinKeyword;

import CommonLIB.CommonFunctionLib;
import CommonLIB.GetBrowserElement;

import Reports.ExtentReportUtil;

import Repositories.TestingNinjaSeachPage;

import io.cucumber.java.en.*;

public class TestingNinjaSearchLIB {
	CommonFunctionLib ComLiB = new  CommonFunctionLib();
	@When("^User validates the page name \"([^\"]*)\"$")
	public void validatePageName(String Value) throws Exception {
		ExtentReportUtil.StepReportCreation(new GherkinKeyword("When"), "User validates the page name "+Value);// Reporting....
		ComLiB.ValidationText(GetBrowserElement.getWebElementByXpath(TestingNinjaSeachPage.PageNameShopping), Value);
	}

	
	@Then("^User select the product \"([^\"]*)\"$")
	public void SelectNinjaProduct(String Value) throws Exception {
		ExtentReportUtil.StepReportCreation(new GherkinKeyword("Then"), "User select the product "+Value);// Reporting....
		String ReplacedXpath=ComLiB.ReplacedXpath(TestingNinjaSeachPage.ProductSelect,"xxxx",Value);
		GetBrowserElement.ScrollVieWObject(GetBrowserElement.getWebElementByXpath(By.xpath(ReplacedXpath)));
		ComLiB.ClickObject(GetBrowserElement.getWebElementByXpath(By.xpath(ReplacedXpath)));
		GetBrowserElement.PageReadyStateCheck(1000);

	}

	
}
