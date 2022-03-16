package com.crm.ContactTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContactTest{


	
	//Step 2: launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		//Step 3: login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 4: Navigate to Organizations Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5: click on create org swanization btn
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 6: enter mandatory fields and save
		driver.findElement(By.name("accountname")).sendKeys(OrgName+" "+random);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step 7: logout of application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
		
		//Step 8: close the browser
		driver.quit();

	    }
}


