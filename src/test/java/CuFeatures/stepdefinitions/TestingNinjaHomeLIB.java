package CuFeatures.stepdefinitions;
import org.openqa.selenium.By;

import com.aventstack.extentreports.GherkinKeyword;

import CommonLIB.CommonFunctionLib;
import CommonLIB.GetBrowserElement;

import Reports.ExtentReportUtil;
import Repositories.CommonRepository;
import Repositories.TestingNinjaHome;
import io.cucumber.java.en.*;


public class TestingNinjaHomeLIB {
	CommonFunctionLib ComLiB = new CommonFunctionLib();
	@Given("^Customer is opened the Testninja ecom site$")
	public void openSite() throws Exception {
		ExtentReportUtil.StepReportCreation(new GherkinKeyword("Given"), "Customer is opened the Testninja ecom site");// Reporting....
		
		ComLiB.FocusOnUrl(CommonRepository.testingInija);	
	}
	@Then("^Customer changes currency to \"([^\"]*)\"$")
	public void Customer_changes_currency(String Value) throws Exception {
		ExtentReportUtil.StepReportCreation(new GherkinKeyword("Then"), "Customer changes currency to "+Value);// Reporting....
		GetBrowserElement.PageReadyStateCheck(10);

		ComLiB.ClickObject(GetBrowserElement.getWebElementByXpath(TestingNinjaHome.CurrencyDropDownFlag));
		System.out.println(Value);
		ComLiB.ClickObject(GetBrowserElement.getWebElementByXpath(TestingNinjaHome.CurrencyDropDownSelect).findElement(By.xpath("//li/button[contains(text(),\""+Value.toString()+"\")]")));
	}

	@And("^Customer search for \"([^\"]*)\" and hit search button$")
	public void Search(String Value) throws Exception {
		ExtentReportUtil.StepReportCreation(new GherkinKeyword("And"), "Customer search for "+Value+" and hit search button");// Reporting....
		GetBrowserElement.PageReadyStateCheck(100);
		ComLiB.SetOnparam(GetBrowserElement.getWebElementByXpath(TestingNinjaHome.searchtype), Value);
		ComLiB.ClickObject(GetBrowserElement.getWebElementByXpath(TestingNinjaHome.searchButton));
	}
	


}
