package com.winiumdriver.utility;

import org.testng.annotations.DataProvider;

public class DataproviderRepository {

	private final String excelSheetPath = System.getProperty("user.dir") + "/Resources/Data.xlsx";

	/**
	 * Read the data for addition function from 'Add' excel sheet
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "Addition")
	public Object[][] addition() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(excelSheetPath, "Add");

		return (testObjArray);

	}

	/**
	 * Read the data for division function from 'Div' excel sheet
	 * 
	 * @return
	 * @throws Exception
	 */

	@DataProvider(name = "Division")
	public Object[][] division() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(excelSheetPath, "Div");

		return (testObjArray);

	}

	/**
	 * Read the data for modulus function from 'Mod' excel sheet
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "Modulus")
	public Object[][] mod() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(excelSheetPath, "Mod");

		return (testObjArray);

	}

	/**
	 * Read the data for square function from 'Square' excel sheet
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "square")
	public Object[][] square() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(excelSheetPath, "square");

		return (testObjArray);

	}
}
