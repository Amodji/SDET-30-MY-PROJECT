package com.crm.Compaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Genericlibrary.ExcelFileUtility;
import com.crm.Genericlibrary.JavaUtility;
import com.crm.Genericlibrary.PropertyFileUtility;
import com.crm.Genericlibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CteateProductWithCreateCampaignWithUtilityLib {
	
	@Test
	public void CteateProductWithCreateCampaignWithUtilityLib() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		/*read data*/
		PropertyFileUtility pLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		/*Step 1: read all necessary data*/
		String BROWSER = pLib.readDateFromPropertyFile("browser");
		String URL = pLib.readDateFromPropertyFile("url");
		String USERNAME = pLib.readDateFromPropertyFile("username");
		String PASSWORD = pLib.readDateFromPropertyFile("password");
		
		String campaignName = eLib.readDataFromExcel("Campaigns", 1, 2)+"_"+jLib.getRandomNumber();
		String prodName = eLib.readDataFromExcel("Campaigns", 1, 3);
		String catType = eLib.readDataFromExcel("Campaigns", 1, 4);
	
		/*Step 2: launch the browser*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		wLib.maximizeWindow(driver);
		wLib.WaitForPageLode(driver);
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(prodName);
		
		WebElement pCategory = driver.findElement(By.name("productcategory"));
		wLib.select(pCategory, catType);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		wLib.switchToWindow(driver, "Products");
		
		driver.findElement(By.name("search_text")).sendKeys(prodName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(prodName)).click();
		
		wLib.switchToWindow(driver, "Campaigns");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
	}

}
