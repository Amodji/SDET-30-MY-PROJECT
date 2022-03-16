package com.crm.BaseClassImplimentation;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Genericlibrary.BaseClass;
import com.crm.Genericlibrary.DatabaseUtility;
import com.crm.Genericlibrary.ExcelFileUtility;
import com.crm.Genericlibrary.JavaUtility;
import com.crm.Genericlibrary.PropertyFileUtility;
import com.crm.Genericlibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.Genericlibrary.ListnerImplementationClass.class)

public class CreateOrgTestWithBaseClass extends BaseClass {
	
	//create Object  of all utility
	public DatabaseUtility dbLib = new DatabaseUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
    public WebDriver driver = null;
	
	
	@Test
	public void createOrgTest() throws Throwable
	{
		
		
		//read data from property file
		
		String BROWSER = pLib.readDateFromPropertyFile("browser");
    	pLib.readDateFromPropertyFile("url");
		
		/*Step 2: launch the browser*/
    	//Create RunTime polymorphism
    	if(BROWSER.equalsIgnoreCase("chrome"))
    	{
    		//WebDriverManager.chromedriver().setup();
    		driver= new ChromeDriver();
    	}
    	else if(BROWSER.equalsIgnoreCase("firefox"))
    	{
    			WebDriverManager.firefoxdriver().setup();
    			driver = new FirefoxDriver();
    	}
    	else
    	{
    		System.out.println("invalid browser");
    	}
    	
    	wLib.maximizeWindow(driver);
    	wLib.WaitForPageLode(driver);
    	driver.get("URL");
    	Reporter.log("===browser launch successful===",true);
		
	}	
		/*Step 3: login to application*/
    	  @BeforeMethod
    	    public void Login() throws Throwable
    	    {
    	    	String USERNAME = pLib.readDateFromPropertyFile("username");
    	    	String PASSWORD = pLib.readDateFromPropertyFile("password");
    	    	LoginPage lp = new LoginPage(driver);
    	    	lp.loginToApp(USERNAME, PASSWORD);
    	    	Reporter.log("===login succesful===",true);
    	    }
		
    	   @AfterMethod
    	    public void logout()
    	    {
    	    	HomePage hp = new HomePage(driver);
    	    	hp.signOutOfApp(driver);
    	    	Reporter.log("===logout successfull===",true);
    	    }
    	    
    	    @AfterClass
    	    public void closeBrowser()
    	    {
    	    	driver.quit();
    	    	Reporter.log("===browser close successful", true);
    	    }
    	    
    	    @AfterSuite
    	    public void closeDb()
    	    {
    	    	//dBLib.closeDB();
    	    	Reporter.log("===Database close successful", true);
    	    }
    	    
	}	    
    	    
    	    
	


