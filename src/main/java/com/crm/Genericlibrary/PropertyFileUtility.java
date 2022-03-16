package com.crm.Genericlibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class will read data from property file and return value to user
 * @author AMIT KUMAR
 *
 */

public class PropertyFileUtility {
	
	/**
	 * This method will read data from property file for the key given by user
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readDateFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pLib = new Properties();
		pLib.load(fis);
		String value = pLib.getProperty(key);
		return value;
		
	}

}
