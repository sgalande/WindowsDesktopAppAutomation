package com.winiumdriver.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.winiumdriver.drivercreation.DriverHelperFactory;

/**
 * 
 * This class is used to perform all calculator operation
 *
 */
public class CalculatorOperator {
	
	private static By PLUSOPERATOR = By.id("plusButton");
	private static By EQUALOPERATOR = By.id("equalButton");
	private static By DIVISIONOPERATOR = By.id("divideButton");
	private static By RESULTS = By.id("CalculatorResults");
	private static By MODULUSOPERATOR = By.id("modButton");
	private static By CALCULATOR_TOGGLE_BUTTON = By.id("TogglePaneButton");
	private static By SCIENTIFIC_CALCULATOR = By.id("Scientific");
	private static By SQUAREOPERATOR = By.id("xpower2Button");
	
	
	/**
	 * Click on plus operator
	 */
	public static void clickPlusOperator() {
		DriverHelperFactory.getDriver().findElement(PLUSOPERATOR).click();
	}
	
	/**
	 * Click on equal to operator
	 */
	public static void clickEqualToOperator() {
		DriverHelperFactory.getDriver().findElement(EQUALOPERATOR).click();;
	}
	
	/**
	 * Click on division operator
	 */
	public static void clickDivisionOperator() {
		DriverHelperFactory.getDriver().findElement(DIVISIONOPERATOR).click();

	}
	
	/**
	 * Click on modulus operator
	 */
	public static void clickModulusOperator() {
		DriverHelperFactory.getDriver().findElement(MODULUSOPERATOR).click();
	}
	
	/**
	 * Click on square operator
	 */
	public static void clickSquareOperator() {
		DriverHelperFactory.getDriver().findElement(SQUAREOPERATOR).click();
		
	}
	
	/**
	 * Open scientific calculator
	 */
	public static void openScientificCalculator() {
		DriverHelperFactory.getDriver().findElement(CALCULATOR_TOGGLE_BUTTON).click();
		DriverHelperFactory.getDriver().findElement(SCIENTIFIC_CALCULATOR).click();

	}
	
	public static double getResult() {
		double result = 0d;
		WebElement element = DriverHelperFactory.getDriver().findElement(RESULTS);
		if(element !=null) {
		result = Double.parseDouble(element.getAttribute("Name").replaceAll("[^0-9]", ""));
		
		}
		return result;
		
	}

	
}
