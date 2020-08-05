package Reports;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import CommonLIB.Hook;

import java.io.IOException;


public class TestListener implements ITestListener  {

    ExtentReportUtil extentReportUtil = new ExtentReportUtil();
    
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test start");
        
		 
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    	ExtentReportUtil.childTest.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName() ,  ExtentColor.GREEN));
    	//try {
			try {
				ExtentReportUtil.childTest.pass(iTestResult.getName()).addScreenCaptureFromPath(ExtentReportUtil.TakeScreenShot("PASSED"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//} catch (IOException e) {
		//}
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On test failure");
        ExtentReportUtil.childTest.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName() ,  ExtentColor.RED));
    	try {
			ExtentReportUtil.childTest.pass(iTestResult.getName()).addScreenCaptureFromPath(ExtentReportUtil.TakeScreenShot("FAILED"));
		} catch (IOException e) {
		}
 
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test skipped");
        ExtentReportUtil.childTest.log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getName() ,  ExtentColor.BROWN));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On start");
      
		
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    	
    	System.gc();
    }
}