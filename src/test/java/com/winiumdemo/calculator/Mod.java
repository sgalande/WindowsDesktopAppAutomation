package com.winiumdemo.calculator;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.winiumdriver.drivercreation.DriverHelperFactory;
import com.winiumdriver.drivercreation.TestBase;
import com.winiumdriver.utility.CalculatorOperator;
import com.winiumdriver.utility.DataproviderRepository;
import com.winiumdriver.utility.ReportGenerator;
@Listeners(ReportGenerator.class)

public class Mod extends TestBase {
	
	@Test(dataProviderClass = DataproviderRepository.class , dataProvider="Modulus",description = "Verify Mod of Two Numbers")
	public void testMod(double a,double b,double result) {
		
			
		getExtentTest().info("Executing Test Case With Data a =  " +a+ " and b = "+b);
		getExtentTest().info("Entering first input " +a);
		DriverHelperFactory.getDriver().inputNumber(a);
		getExtentTest().info("Clicking on modulus operator");
		CalculatorOperator.clickModulusOperator();
		getExtentTest().info("Entering second input " +b);
		DriverHelperFactory.getDriver().inputNumber(b);
		getExtentTest().info("Clicking on equal to operator");
		CalculatorOperator.clickEqualToOperator();
		double actualModulus = CalculatorOperator.getResult();
		Assert.assertEquals(actualModulus, result,"Actual modulus is "+actualModulus +" Expected modulus is "+result);
	}
	
}
