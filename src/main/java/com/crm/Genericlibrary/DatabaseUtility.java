package com.crm.Genericlibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
    Connection Con = null;
	public void  connectToDb() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection(IPathConstants.dbUrl, IPathConstants.dbUsername, IPathConstants.dbPassword);
		
	}
	public void closeDB() throws Throwable
	{
		Con.close();
	}
	
	public String executeQueryAndGetData(String query,int coulumnIndex,String expData) throws Throwable
	{
		String data=null;
		boolean flag=false;
		ResultSet result = Con.createStatement().executeQuery(query);
		while(result.next())
		{
			data = result.getString(coulumnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;//flag rising
				break;
			}
		}
		return data;
	     
	}

}
