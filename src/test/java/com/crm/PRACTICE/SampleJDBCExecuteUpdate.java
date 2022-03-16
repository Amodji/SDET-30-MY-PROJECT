package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	@Test
	public void SampleJDBCExecuteUpdate() throws Throwable
	{
		Connection con= null;
		try
		{
	
	//Step 1: register the Database
	 Driver driverRef= new Driver();
	 DriverManager.registerDriver(driverRef);
	 
	 //step 2: get connection fro database
	Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb","root","root");
	
	//step 3: issue create statement
	Statement stat = con1.createStatement();
	
	//step 4: execute a query
	int result = stat.executeUpdate("insert into studinfo values('Adarsh',11,'japan');");
	
	if(result==1)
	{
		System.out.println("data add successfully");
	}
	else
	{
		System.out.println("data not added");
	}
    }
    catch(Exception e) {
    	
    }
    finally
    {
    	//Step 5: close the database
    	con.close();
    	System.out.println("connection closed");
    }
	}
}
    
 
	
	

