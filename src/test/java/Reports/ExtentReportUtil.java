package Reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import CommonLIB.GetBrowserElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Calendar;




public class ExtentReportUtil extends GetBrowserElement {
	public static ExtentReports Roport;

	public static ExtentHtmlReporter htmlReporter;

	public static ExtentTest parentTest;
	public static ExtentTest childTest ;


	

    public static void ExtentReport() {
        //First is to create Extent Reports
    	Roport = new ExtentReports();
    	Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String timeStamp =formater.format(calendar.getTime());
        
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/extentreport_"+timeStamp+".html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Test report for Selenium Basic");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test report");
        htmlReporter.setAppendExisting(true);
       
    }
	public static synchronized void ReportCreation(String scenarioName) {
		Roport.attachReporter(htmlReporter);
		parentTest = Roport.createTest(scenarioName);
	
	}
	public static synchronized void StepReportCreation(GherkinKeyword gherkinKeyword, String result) {

		childTest = parentTest.createNode(gherkinKeyword,result);
	}
    public void ExtentReportScreenshot() throws IOException {
      //  childTest.createNode(""+ " PASSED Screen Shot").addScreenCaptureFromPath("")
    }


    public static void FlushReport(){
    	Roport.flush();
    	
    	htmlReporter.flush();
    }
    
    public static String TakeScreenShot(String Name) {
    	String reportsPath1 = "";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String timeStamp =formater.format(calendar.getTime()); // get timestamp
		
		String screenShotName = timeStamp+"_"+Name+ ".png";

		String reportsPath = System.getProperty("user.dir") + "/screenshots";
		try{
			File file = new File(reportsPath); // Set
			if (!file.exists()) {
				if (file.mkdirs()) {
					System.out.println("Path created");
				} else {
					System.out.println("Path exists");
				}

			}

			File screenshotFile = ((TakesScreenshot) GetBrowserElement.getDriver()).getScreenshotAs(OutputType.FILE);
			 reportsPath1 = reportsPath +  "/" + screenShotName;// define
			// location
			File targetFile = new File(reportsPath1);

			FileHandler.copy(screenshotFile, targetFile);

		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return reportsPath1;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
