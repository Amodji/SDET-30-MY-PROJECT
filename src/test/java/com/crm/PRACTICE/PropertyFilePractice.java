package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice {
	@Test
	public void propertyFile() throws Throwable{
	
	//Step 1: read the file
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	//step 2: Create obj of Properties
	Properties pObj = new Properties();
	pObj.load(fis);
	
	//Stap 3: read the data
	String URL = pObj.getProperty("username");
	
	//Verification
	System.out.println(URL);

	}
}
	


