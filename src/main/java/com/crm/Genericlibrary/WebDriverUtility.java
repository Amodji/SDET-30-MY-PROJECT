package com.crm.Genericlibrary;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all generic methods related to webDriverAction
 * @author AMIT KUMAR
 *
 */

public class WebDriverUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}

/**
 * This method will wait for 20 seconds for the page load
 * @param driver
 */
public void WaitForPageLode(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

/**
 * This method will wait for 10 seconds for an element to be Clickable
 * @param driver
 * @param element
 */
public void waitForElementToBeClickable(WebDriver driver, WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

/**
 * This method will wait for 20 seconds for the element to be visible
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver, WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(element));
}

/**
 * This method will select data from dropdown using index
 * @param element
 * @param index
 */
public void select(WebElement element, int index)
{
	Select sel = new Select(element);
	sel.selectByIndex(index);
}

/**
 * This method will select data from dropdown using visible text
 * @param element
 * @param text
 */
public void select(WebElement element, String text)
{
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}

/**
 * This method will select data from dropdown using value
 * @param value
 * @param element
 */
public void select(String value, WebElement element)
{
	Select sel = new Select(element);
	sel.selectByValue(value);
}

/**
 * This method will perform mouse Hover action
 * @param driver
 * @param element
 */
public void mouseHover(WebDriver driver, WebElement element)
{
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}

/**
 * This method will perform drag and drop action
 * @param driver
 * @param src
 * @param target
 */
public void dragAndDrop(WebDriver driver, WebElement src, WebElement target)
{
	Actions act = new Actions(driver);
	act.dragAndDrop(src, target).perform();
}

/**
 * This method will double click on element
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver, WebElement element)
{
	Actions act = new Actions(driver);
	act.doubleClick(element);
}

/**
 * This method will double click on webpage
 * @param driver
 */
public void doubleClickAction(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.doubleClick().perform();
}

/**
 * This method will right click on webpage
 * @param driver
 */
public void rightClick(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.contextClick().perform();
}

/**
 * This method will right click on element
 * @param driver
 * @param element
 */
public void rightClick(WebDriver driver, WebElement element)
{
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
}

/**
 * This method will press enter key
 * @param driver
 */
public void enterKeyPress(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
}
/*
// This method will press ENTER key
public void enterKey() //Robot class is not present inEclipse(2021-9) version
{
	Robot rb =new Robot();
	rb.keyPress(KeyEvent.VK_ENTER);
}

//This method will release ENTER key
public void enterRelease()
{
    Robot rb =new Robot();
    rb.keyRelease(KeyEvent.VK_ENTER);
}
*/

/**
 * This method will switch the frame based on index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
}

/**
 * This method will switch the frame based on name or Id
 * @param driver
 * @param nameOrId
 */
public void switchToFrame(WebDriver driver, String nameOrId)
{
	driver.switchTo().frame(nameOrId);
}


/**
 *  This method will switch the frame based on address of the element
 * @param driver
 * @param address
 */
public void switchToFrame(WebDriver driver, WebElement address)
{
	driver.switchTo().frame(address);
}

/**
 * Accept alert
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

/**
 * Cancel Alert
 * @param driver
 */
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}


public void switchToWindow(WebDriver driver, String partialWinTitle)
{
	//Step1: use getWindowHandles to capture all window ids
	Set<String> windows = driver.getWindowHandles();
	
	//Step2: iterate throw the window
	Iterator<String> it = windows.iterator();
	
	//Step3: check whether there is next window
	while(it.hasNext())
	{
		String winId = it.next();
		
		String currentWinTitle = driver.switchTo().window(winId).getTitle();
		
		if(currentWinTitle.contains(partialWinTitle))
		{
			break;
		}
	}
}
	
	public String getScreenshot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
	    //String path="./screenshots/"+screenshotName+".PNG"
		File dst = new File("./screenshots/"+screenShotName+".PNG");
		Files.copy(src,dst);
		return dst.getAbsolutePath();
	}
	
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	
	public void scrollToWebElement(WebDriver driver, WebElement element)
	{	
        JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	 // js.executeScript("argument[0].scrollIntoView()",element);
	}
	
}


	



























