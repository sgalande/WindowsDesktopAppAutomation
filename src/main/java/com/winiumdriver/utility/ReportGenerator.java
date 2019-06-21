package com.winiumdriver.utility;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.winiumdriver.drivercreation.DriverHelperFactory;
import com.winiumdriver.drivercreation.TestBase;

public class ReportGenerator extends TestBase implements ISuiteListener,ITestListener{

	public void onTestStart(ITestResult result) {
	extentTest.set(getExtentReport().createTest("<h6 style=\"color:DodgerBlue;\">"+result.getMethod().getMethodName()+"<h6>","<br/>" +"<h5 style=\"color:DodgerBlue;\">"+result.getMethod().getDescription()+"<h5>"));
		
	}
	public void onTestSuccess(ITestResult result) {
		getExtentTest().log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName() +" is successful",ExtentColor.GREEN));
		
	}
	public void onTestFailure(ITestResult result) {
		getExtentTest().log(Status.FAIL, result.getMethod().getMethodName());
		getExtentTest().log(Status.FAIL, result.getThrowable().getLocalizedMessage());
		getExtentTest().log(Status.FAIL, MarkupHelper.createLabel("Failed to "+result.getMethod().getMethodName(), ExtentColor.RED));
		try {
			getExtentTest().addScreenCaptureFromPath(DriverHelperFactory.getDriver().captureScreenShot(result.getMethod().getMethodName()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				
	}
	public void onTestSkipped(ITestResult result) {
		getExtentTest().log(Status.SKIP, result.getMethod().getMethodName());
		getExtentTest().log(Status.SKIP, result.getThrowable().getLocalizedMessage());		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ITestContext context) {
		try {
			getExtentReport().flush();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}
	
	
}
