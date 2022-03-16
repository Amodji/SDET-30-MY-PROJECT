package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectAnyDateGoibiboCalenderTest {
	@Test
	public void calender() {
		String date="20";
		String monthAndYear="April 2022";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/flights/");
		
		Actions actions = new Actions(driver);
	    actions.moveByOffset(10, 10).click().perform();
	    
	    driver.findElement(By.xpath("//span[text()='Departure']")).click();
	    
	    driver.findElement(By.xpath("//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='20']")).click();
		
	}

}
