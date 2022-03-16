package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class PracticeTestNG {
	
	@Test(invocationCount=4)
    public void createOrg()
	{
		System.out.println("organization is created");
	}
	
	@Test(priority=1)
	public void nodifyOrg()
	{
		System.out.println("organization is modified");
	}
	
	@Test
	public void deleteOrg()
	{
		System.out.println("organization is deleted");
	}
	
	

}
