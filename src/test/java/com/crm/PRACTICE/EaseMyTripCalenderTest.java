package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EaseMyTripCalenderTest {
	
	@Test
	public void calender() {
		String date="20";
		String monthAndYear="May 2022";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com/");
		
		Actions actions = new Actions(driver);
	    actions.moveByOffset(10, 10).click().perform();
	    
	    driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
	    
	    for(;;) {
			try {
				 driver.findElement(By.xpath("//div[text()='Mar 2022']/ancestor::div[@class='box']/descendant::li[@id='frth_5_25/03/2022']")).click();
				break;
			}catch (Exception e) {
				 driver.findElement(By.xpath("//img[@id=\"img2Nex\"]")).click();
				
			}
			
	    }
	    
	}
}
			
			
	    


