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

public class Division extends TestBase {
	
	@Test(dataProviderClass = DataproviderRepository.class , dataProvider="Division",description = "Verify Division of Two Numbers")
	public void testDivision(double a,double b,double result) {
		
		getExtentTest().info("Executing Test Case With Data a =  " +a+ " and b =  "+b);
		getExtentTest().info("Entering first input " +a);
		DriverHelperFactory.getDriver().inputNumber(a);
		getExtentTest().info("Clicking on division operator");
		CalculatorOperator.clickDivisionOperator();
		getExtentTest().info("Entering second input " +b);
		DriverHelperFactory.getDriver().inputNumber(b);
		getExtentTest().info("Clicking on equal to operator");
		CalculatorOperator.clickEqualToOperator();
		double actualDivision = CalculatorOperator.getResult();
		Assert.assertEquals(actualDivision, result,"Actual division is "+actualDivision +" Expected Division is "+result);
	}
	
}
