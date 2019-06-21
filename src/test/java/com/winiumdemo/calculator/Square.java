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

public class Square extends TestBase {
	
	@Test(dataProviderClass = DataproviderRepository.class , dataProvider="square",description = "Verify Sqaure of  Numbers")
	public void testSquare(double a,double result) {
		
			
		getExtentTest().info("Executing Test Case With Data a = " +a);
		getExtentTest().info("Entering first input " +a);
		DriverHelperFactory.getDriver().inputNumber(a);
		getExtentTest().info("Clicking on square operator");
		for (int i = 0; i <3; i++) {
			CalculatorOperator.clickSquareOperator();
		}
		
		double actualModulus = CalculatorOperator.getResult();
		System.out.println(actualModulus);
		Assert.assertEquals(actualModulus, result,"Actual square is "+actualModulus +" Expected square is "+result);
	}

}
