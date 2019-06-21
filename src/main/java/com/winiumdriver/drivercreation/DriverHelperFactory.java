package com.winiumdriver.drivercreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class DriverHelperFactory {
	
	public static DriverHelperFactory driverHelperFactory;
	
	public static DriverHelperFactory getDriver() {
		
		return driverHelperFactory;
	}
	
	public static void init() {
		driverHelperFactory = new DriverController();

	}
	
	public abstract WebElement findElement(By by);
	public abstract void click(WebElement element);
	public abstract void inputNumber(double a);
	public abstract void close();
    public abstract String captureScreenShot(String methodName);
	
}
