package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.Genericlibrary.JavaUtility;
import com.crm.Genericlibrary.PropertyFileUtility;

public class PracticeForGenericUtils {
	
	@Test
	public void practice() throws Throwable 
	{
		JavaUtility jLib = new JavaUtility();
	    int ran = jLib.getRandomNumber();
	    String dat = jLib.getSystemDateInFormat();
        String date = jLib.getSystemDate();
	    System.out.println(ran + date);
	    System.out.println(dat);
		 
	    PropertyFileUtility pLib = new PropertyFileUtility();
	   	String brow = pLib.readDateFromPropertyFile("browser");
	    System.out.println(brow);
	}

}
