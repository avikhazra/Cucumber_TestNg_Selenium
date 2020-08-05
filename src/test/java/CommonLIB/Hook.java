package CommonLIB;

import Reports.ExtentReportUtil;

import io.cucumber.java.Scenario;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import CommonLIB.GetBrowserElement;
import io.cucumber.java.*;

public class Hook {
	


	@Before
	public void InitializeTest(Scenario scenario) {
		ExtentReportUtil.ReportCreation(scenario.getName());
	}
		
	@After
	public void TearDownTest(Scenario scenario) {
		ExtentReportUtil.FlushReport();
	}




}