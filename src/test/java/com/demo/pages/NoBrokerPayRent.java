package com.demo.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class NoBrokerPayRent extends BasePage {
	
	JavascriptExecutor js;
	Robot r;

	public NoBrokerPayRent(WebDriver driver) {
		super(driver);
		this.js=(JavascriptExecutor) driver;
		try {
			this.r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//-----------------------------------------CREDIT CARD LOCATORS-----------------------------------------------------------------	
	
	@FindBy(xpath="//div[@id='rentPayment']")
	WebElement payRent;
	
	@FindBy(xpath="//input[@id='tenant_name']")
	WebElement yourName;

	@FindBy(xpath="//input[@id='tenant_phone']")
	WebElement yourPhone;

	@FindBy(xpath="//input[@id='tenant_email']")
	WebElement Email;

	@FindBy(xpath="//button[@type='submit']")
	WebElement getStartbtn;

	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	WebElement checkBox;
	
	@FindBy(xpath="(//div[contains(text(),'Verification Code')])[1]")
	WebElement verify;
	
//-------------------------------------METHODS FOR CREDIT CARD----------------------------------------------------------	
	
	public void clickPayRent() 
	{
//		waitUntilVisibility(payRent);
		wait.until(ExpectedConditions.elementToBeClickable(payRent));
		payRent.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowHandle = driver.getWindowHandles();
		// Iterate through handles
				for (String windowHandle : allWindowHandle) 
				{
				    // Switch to the window that is not the parent window
				    if (!windowHandle.equals(parentWindow)) 
				    {
				        driver.switchTo().window(windowHandle);
				        break;
				    }
				}
	}
	
	public void enterDetails(String name, String mobileNumber, String mail) {
		js.executeScript("window.scrollBy(0,250)");
		waitUntilVisibility(yourName);
		yourName.sendKeys(name);
		
		waitUntilVisibility(yourPhone);
		yourPhone.sendKeys(mobileNumber);
		
		waitUntilVisibility(Email);
		Email.sendKeys(mail);
		
		waitUntilVisibility(checkBox);
		r.delay(500);
		r.mouseMove(750, 493);
		r.delay(1000);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		r.delay(1000);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		waitUntilVisibility(getStartbtn);
		getStartbtn.click();	
	}

//--------------------------------------------ASSERT--------------------------------------------------------------------
	
	public void assertVerify() 
	{
		waitUntilVisibility(verify);
		String act = verify.getText();
		System.out.println(act);
		Assert.assertEquals(act, "Verification Code");
	}
}
