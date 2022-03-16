package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
	@Test
	public void  SampleJDBCExecuteQuery() throws Throwable{
		
		//Step 1: register the database
		 Driver driverRef = new Driver();
		 DriverManager.registerDriver(driverRef);
		 
		 //Step 2: get connector from database-provide db name
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		 
		//step 3: issue creat statement		 
		 Statement state = con.createStatement();
		 
		//Step 4: execute Query--provide table name 
		 ResultSet result = state.executeQuery("select * from studentinfo;");
		 while(result.next())
		 {
			 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		 }
		 
		 con.close();
		 
	}


}
