package com.winiumdriver.drivercreation;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.winiumdriver.utility.CalculatorOperator;
import com.winiumdriver.utility.ExtentManager;
import com.winiumdriver.utility.WiniumServer;

public class TestBase {
	
	
	ExtentManager extentmanager = new ExtentManager();
	protected static ThreadLocal<ExtentReports> extentReports = new ThreadLocal<ExtentReports>();
	protected static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	/**
	 * This method used to get extent report object
	 * 
	 * @return Extent report object
	 */
	public synchronized static ExtentReports getExtentReport() {
		return extentReports.get();
	}

	/**
	 * This method used to get extent test object
	 * 
	 * @return
	 */
	public synchronized static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	/**
	 * This is called before suite to set log4jProperty and winium server
	 */
	@BeforeSuite(alwaysRun = true)
	public void setUpBeforeSuite() {
		try {
			WiniumServer.startWiniumServer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure("./log4j.properties");
	}

	/**
	 * This is called before test to create automation report
	 */
	@BeforeTest(alwaysRun = true)
	public void setUp() {
		extentReports.set(extentmanager
				.createInstance(System.getProperty("user.dir") + "/reports/" + "Calculator.html"));
		DriverHelperFactory.init();
		CalculatorOperator.openScientificCalculator();

	}
	
	/**
	 * Close the calculator app
	 */
	@AfterTest
	public void tearDown() {
		DriverHelperFactory.getDriver().close();
	}
	

}
