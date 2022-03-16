package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Genericlibrary.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {
	
	//Step1: Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//Step2: initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getHeaderText() {
		return headerText;
	}
	
	//Business Library
	public String OrgNameInfo()
	{
		String OrgInfo = headerText.getText();
		return OrgInfo;
	}


}
