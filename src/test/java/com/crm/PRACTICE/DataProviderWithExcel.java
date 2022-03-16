package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.Genericlibrary.ExcelFileUtility;

public class DataProviderWithExcel {
	
	@Test(dataProvider = "data")
	public void data(String orgname, String indType)
	{
		System.out.println(orgname +"   "+indType);
	}
	
	@DataProvider(name = "data")
	public Object[][] getData() throws Throwable
	{
		ExcelFileUtility eLib = new ExcelFileUtility();
		Object [][] value = eLib.readmultipleDataFromExcel("OrgMultipleData");
		return value;
	}

}
