package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class dataVerificationDB {
	@Test
	public void dataVerify() throws Throwable
	{
	
    String expData = "Chaitra";
    Driver driverRef = new Driver();
    DriverManager.registerDriver(driverRef);
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
    Statement state = con.createStatement();
    ResultSet result = state.executeQuery("select * from student;");
    while(result.next())
    {
    	String actdata = result.getString(1);
    	if(expData.equalsIgnoreCase(actdata))
    	{
    		System.out.println(actdata+" data is varified");
    		break;
    	}
    }
	}
     

 

}
