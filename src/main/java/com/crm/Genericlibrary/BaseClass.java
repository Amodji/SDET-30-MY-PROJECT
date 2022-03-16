package com.crm.Genericlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	//create Object  of all utility
	public DatabaseUtility dbLib = new DatabaseUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
    public WebDriver driver = null;
    public static WebDriver sDriver;
    
    @BeforeSuite(groups= "{regressionSuite,smokeSuite}")
    public void connectDataBase()
    {
    	//dbLib.connectionToDb();
    	Reporter.log("=== db connection successful===", true);
    }
    
    
      @BeforeClass(groups= "{regressionSuite,smokeSuite}")
   
  //  @Parameters("browser")
   // @BeforeTest
    public void launchTheBrowser() throws Throwable
    {
    	//read data from property
    	String BROWSER = pLib.readDateFromPropertyFile("browser");
    	pLib.readDateFromPropertyFile("url");
    	
    	//Create RunTime polymorphisum
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
    
    @BeforeMethod(groups= "{regressionSuite,smokeSuite}")
    public void Login() throws Throwable
    {
    	String USERNAME = pLib.readDateFromPropertyFile("username");
    	String PASSWORD = pLib.readDateFromPropertyFile("password");
    	LoginPage lp = new LoginPage(driver);
    	lp.loginToApp(USERNAME, PASSWORD);
    	Reporter.log("===login succesful===",true);
    }
    
    @AfterMethod(groups= "{regressionSuite,smokeSuite}")
    public void logout()
    {
    	HomePage hp = new HomePage(driver);
    	hp.signOutOfApp(driver);
    	Reporter.log("===logout successfull===",true);
    }
    
    @AfterClass(groups= "{regressionSuite,smokeSuite}")
    public void closeBrowser()
    {
    	driver.quit();
    	Reporter.log("===browser close successful", true);
    }
    
    @AfterSuite(groups= "{regressionSuite,smokeSuite}")
    public void closeDb()
    {
    	//dBLib.closeDB();
    	Reporter.log("===Database close successful", true);
    }
    
    
}






















