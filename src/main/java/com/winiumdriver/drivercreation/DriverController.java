package com.winiumdriver.drivercreation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class DriverController extends DriverHelperFactory {

	WiniumDriver driver;
	WebDriverWait wait;
	private static Logger logger = Logger.getLogger(DriverController.class);

	/**
	 * create winium driver to start calculator app
	 */
	public DriverController() {

		logger.info("Starting Calculator Application");
		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		try {
			driver = new WiniumDriver(new URL("http://localhost:9999"), options);
			wait = new WebDriverWait(driver, 30);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public WebElement findElement(By by) {
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			logger.info("Unable to find element ::" + by);
		}

		return element;

	}

	/**
	 * Clicking on element
	 */
	@Override
	public void click(WebElement element) {
		if (element != null) {
			element.click();
		}
	}

	/**
	 * Closing the calculator application
	 */
	@Override
	public void close() {
		try {
			logger.info("Closing the calulator App");
			Runtime.getRuntime().exec("TASKKILL /F /IM calculator.exe");
		} catch (IOException e) {
			logger.info("Failed to close calculator App");
			e.printStackTrace();
		}
	}

	@Override
	public void inputNumber(double value) {
//		logger.info("Sending input "+value);
//		char[] digits = String.valueOf(value).toCharArray();
//		for (int i = 0; i < digits.length; i++) {
//			String input = "num" + digits[i] + "Button";
//			DriverHelperFactory.getDriver().findElement(By.id(input)).click();
//		}
		
		findElement(By.id("CalculatorResults")).sendKeys(String.valueOf(value));
	}

	@Override
	public String captureScreenShot(String screenshotName) {

		logger.info("Capturing Screenshot");
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		screenshotName += dateFormat.format(date);
		String userDirectory = System.getProperty("user.dir");
		String destination = userDirectory + "/screenshots/" + screenshotName + ".png";
		try {
			FileUtils.copyFile(scr, new File(destination));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return destination;

	}

}
