package com.crm.OrgenizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Genericlibrary.ExcelFileUtility;
import com.crm.Genericlibrary.JavaUtility;
import com.crm.Genericlibrary.PropertyFileUtility;
import com.crm.Genericlibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateOrgTestWithPom {
	
	@Test
	public void createOrgTest() throws Throwable
	{
	PropertyFileUtility pLib = new PropertyFileUtility();
	JavaUtility jLib = new JavaUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
		
	/*Step 1: read all necessary data*/
			
		String BROWSER = pLib.readDateFromPropertyFile("browser");
		String URL = pLib.readDateFromPropertyFile("url");
		String USERNAME = pLib.readDateFromPropertyFile("username");
		String PASSWORD = pLib.readDateFromPropertyFile("password");
		
		String OrgName = eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
		
		/*Step 2: launch the browser*/
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		
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
			System.out.println("invalid browser");
		}
		
		wLib.maximizeWindow(driver);
		wLib.WaitForPageLode(driver);
		driver.get(URL);
		
		/*Step 3: login to application*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		/*Step 4: Navigate to Organizations Link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();
		
		/*Step 5: click on create organization btn*/
		OrganizationsPage op = new OrganizationsPage(driver);
		op.ClickOnCreateOrgImg();
		
		/*Step 6: enter mandatory fields and save*/
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName);
		
		/* verification     */

		OrganizationInfoPage  oip = new  OrganizationInfoPage(driver);
		String actOrgName = oip.OrgNameInfo();
		
		if(actOrgName.contains(OrgName))
		{
			System.out.println(actOrgName+"---> data verified");
		}
		else
		{
			System.out.println("data invalid");
		}
		
	/*	@Test(group="regressionSuite")
		public void testScript2()
		{
			System.out.println("This is test script 2");
		}
	*/	
		
		
		/* Step7: Logout of application*/
		hp.signOutOfApp(driver);
		
		/* Step8: close the browser*/
		   driver.quit();
		   
	}
	
}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


	

	
	
		