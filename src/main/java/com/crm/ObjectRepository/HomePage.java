package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Genericlibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	//step1: Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(linkText="More")
	private WebElement MoreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminisrtatorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	//step2: Initialization
	
	public HomePage(WebDriver driver) {
     
		PageFactory.initElements(driver,this);
	}
	
    //step3: generate Getter
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLink() {
		return contactsLnk;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLink() {
		return productsLnk;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLnk;
	}

	public WebElement getAdminisrtatorImg() {
		return adminisrtatorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLnk;
	}
	
	
    //Business Library
	public void ClickOnOrgLnk()
	{
		organizationLnk.click();
	}
	
	public void ClickOnContactLnk()
	{
		contactsLnk.click();
	}
		
    public void signOutOfApp(WebDriver driver)
    {
    	mouseHover(driver, adminisrtatorImg);
    	signOutLnk.click();
    }

}
