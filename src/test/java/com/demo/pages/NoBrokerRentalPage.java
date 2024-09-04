package com.demo.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.demo.files.ExcelReader;

public class NoBrokerRentalPage extends BasePage 
{
	JavascriptExecutor js;
	Robot robot;
	Actions act;
	String[][] data;

	public NoBrokerRentalPage(WebDriver driver) 
	{
		super(driver);
		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		this.js = (JavascriptExecutor) driver;
	}
//---------------------------------------LOCATORS FOR LOGIN-------------------------------------------------------
	
	@FindBy(xpath = "//div[@class='px-1p border-l-1 border-l-solid border-l-header-grey cursor-pointer']")
	WebElement loginBtn;

	@FindBy(xpath = "//input[@id='signUp-phoneNumber']")
	WebElement phoneNumberInput;

	@FindBy(id = "signUpSubmit")
	WebElement continueBtn;
	
	@FindBy(xpath="//div[@class='text-error-color nb__1ZaHg']")
	WebElement invalidOtp;
	
	@FindBy(xpath="//header/div[@id='navHeader']/div[2]/div[1]/img[1]")
	WebElement noBrokerLogo;
	
//-------------------------------------LOCATORS FOR RENT RECEIPT-----------------------------------------------------
	
	@FindBy(xpath = "//header/div[@id='navHeader']/div[5]/div[3]/div[3]/div[1]")
	WebElement menuTabClick;

	@FindBy(xpath = "//a[contains(text(),'Rent Receipts')]")
	WebElement rentReceiptsClick;

	@FindBy(id = "rentrecipt-form-tenant_name-nbInput")
	WebElement tenantName;

	@FindBy(id = "rentrecipt-form-owner_name-nbInput")
	WebElement ownerName;

	@FindBy(id = "rentrecipt-form-tenant_phone-nbInput")
	WebElement tenantPhone;

	@FindBy(id = "rentrecipt-form-owner_phone-nbInput")
	WebElement ownerPhonone;

	@FindBy(id = "rentrecipt-form-rent-nbInput")
	WebElement rentAmount;

	@FindBy(id = "rentrecipt-form-owner_pan-nbInput")
	WebElement ownerPANNum;

	@FindBy(id = "rentrecipt-form-tenant_address-nbInput")
	WebElement rentPropertyAddress;

	@FindBy(id = "rentrecipt-form-owner_address-nbInput")
	WebElement ownerAddress;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement receiptStartDate;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/form[1]/div[10]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement receiptEndDate;

	@FindBy(id = "rentrecipt-form-email-nbInput")
	WebElement emailInput;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement startDateBar;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/form[1]/div[10]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement endDateBar;

	@FindBy(xpath = "//div[contains(text(),'17')]")
	WebElement startReceiptDate;

	@FindBy(xpath = "//div[contains(text(),'25')]")
	WebElement endReceiptDate;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement generateReceiptClick;
	
	@FindBy(xpath="//div[contains(text(),'Please Select Stamp Paper Amount')]")
	WebElement validation;

//-------------------------------------LOCATORS FOR RENTAL AGREEMENT---------------------------------------------------

	@FindBy(xpath = "//span[text()='Rental Agreement']")
	WebElement rentalAgree;

	@FindBy(xpath = "//body/div[@id='modal-root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/img[1]")
	WebElement citySelection;
	
	@FindBy(xpath="//body/div[@id='modal-root']/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/input[1]")
	WebElement citySearchBar;
	
	@FindBy(xpath="//body/div[@id='modal-root']/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]")
	WebElement bangloreCity;

	@FindBy(xpath="//div[@class='nb__3W21B']/child::button[@type='button' and @class='btn btn-primary' ]")
	WebElement checkPrices;

	@FindBy(xpath="//body/div[@id='appPortal']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]")
	WebElement selectPackage;

	@FindBy(xpath = "//body/div[@id='appPortal']/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]")
	WebElement selectDate;

	@FindBy(xpath = "//button[@class='default-footer-button btn btn-default']")
	WebElement saveAndContinue;
		
	@FindBy(xpath="//button[@id='signUpSubmit']")
	WebElement signUp;
	
	@FindBy(xpath ="//div[contains(text(),'Congratulations')]")
	WebElement congo;

//-------------------------------------------------METHODS FOR LOGIN--------------------------------------------------------------------------
	public void loginBtnClick()
	{
		loginBtn.click();
	}
	public void enterPhoneNumber()
	{
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(
					"C:\\Users\\keerthar\\eclipse-workspace1\\NoBrokerPrjt\\src\\test\\java\\com\\demo\\properties\\LoginNoBroker.properties");
			Properties props = new Properties();
			try {
				props.load(fis);
				waitUntilVisibility(phoneNumberInput);
				phoneNumberInput.sendKeys(props.getProperty("PhoneNumber"));
				} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public void enterOTPNumber(){
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	public void clickContinueButton() {
		continueBtn.click();
	}

//-------------------------------------------METHODS FOR RENT RECEIPTS---------------------------------------------------------------------

	public void clickMenu() 
	{
		robot.delay(3000);
		robot.mouseMove(1200,150);
		robot.delay(2000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	public void selectRentReceipt() 
	{
		waitUntilVisibility(rentReceiptsClick);
		rentReceiptsClick.click();
	}
	public void InputForReceipt()
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream(
					"C:\\Users\\keerthar\\eclipse-workspace1\\NoBrokerPrjt\\src\\test\\java\\com\\demo\\properties\\ValidCredential.properties");
			try {
				Properties props = new Properties();
				props.load(fis);
				waitUntilVisibility(tenantName);
				tenantName.sendKeys(props.getProperty("TenantName"));
				ownerName.sendKeys(props.getProperty("OwnerName"));
				tenantPhone.sendKeys(props.getProperty("TenantPhone"));
				ownerPhonone.sendKeys(props.getProperty("OwnerPhone"));
				rentAmount.sendKeys(props.getProperty("Rent"));
				ownerPANNum.sendKeys(props.getProperty("OwnerPAN"));
				rentPropertyAddress.sendKeys(props.getProperty("RentedPropertyAddress"));
				ownerAddress.sendKeys(props.getProperty("OwnerAdress"));
		//Start Date Selection		
				wait.until(ExpectedConditions.elementToBeClickable(startDateBar));
				startDateBar.click();
				wait.until(ExpectedConditions.elementToBeClickable(startReceiptDate));
				startReceiptDate.click();
	   //End Date Selection		
				wait.until(ExpectedConditions.elementToBeClickable(endDateBar));
				endDateBar.click();
				wait.until(ExpectedConditions.elementToBeClickable(endReceiptDate));
				endReceiptDate.click();
				
				js.executeScript("window.scrollBy(0,200)","");
				waitUntilVisibility(emailInput);
				emailInput.clear();
//				emailInput.sendKeys(props.getProperty("Email"));
				emailInput.sendKeys("emi@gmail.com");
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

	}


	public void clickGenerateReceiptButton() {
		wait.until(ExpectedConditions.visibilityOf(generateReceiptClick));
		js.executeScript("arguments[0].click();", generateReceiptClick);
	}

//------------------------------------METHOD FOR INVALID RECEIPT-----------------------------------------------------
	
	public void InputForInvalidReceipt()
	{
		try {
			data = ExcelReader.getData();
			String tenName = data[0][0];
			String ownName = data[0][1];
			String tenPhone = data[0][2];
			String ownerPhn = data[0][3];
			String renAmount = data[0][4];
			String ownPAn = data[0][5];
			String rentProp = data[0][6];
			String ownerAds = data[0][7];
			String emailInp = data[0][8];
			
			waitUntilVisibility(tenantName);
			tenantName.sendKeys(tenName);
			ownerName.sendKeys(ownName);
			tenantPhone.sendKeys(tenPhone);
			ownerPhonone.sendKeys(ownerPhn);
			rentAmount.sendKeys(renAmount);
			ownerPANNum.sendKeys(ownPAn);
			rentPropertyAddress.sendKeys(rentProp);
			ownerAddress.sendKeys(ownerAds);
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

//----------------------------------METHOD FOR RENTAL AGREEMENT--------------------------------------------------------

	public void clickRentalagree() 
	{
		js.executeScript("window.scrollBy(0,350)","");
		wait.until(ExpectedConditions.visibilityOf(rentalAgree));
		rentalAgree.click();
	}

	public void selectCity() 
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowHandle = driver.getWindowHandles(); 
		for (String windowHandle : allWindowHandle) 
		{
// Switch to the window that is not the parent window
		    if (!windowHandle.equals(parentWindow)) 
		    {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		robot.delay(3000);
		robot.mouseMove(475, 400);
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public void selectCheckPrices() 
	{
		robot.delay(3000);
		robot.mouseMove(825, 550);
		robot.delay(3000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	public void selectPackageAgree() 
	{
		robot.delay(2000);
		robot.mouseMove(900, 260);
		robot.delay(4000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public void selectSave() {
		waitUntilVisibility(saveAndContinue);
		saveAndContinue.click();
	}
//---------------------------------------ASSERTS--------------------------------------------------------------------------
	
	public void assertInvalidOtp() 
	{
		waitUntilVisibility(invalidOtp);
		String act = invalidOtp.getText();
		System.out.println(act);
		Assert.assertEquals(act, "Please enter valid OTP");
	}
	
	public void assertValidOtp() 
	{
		wait.until(ExpectedConditions.visibilityOf(noBrokerLogo));
		boolean expected = true;
		boolean act;
		if(noBrokerLogo.isDisplayed()) {
			act = true;
		}else {
			act = false;
		}
		System.out.println(act);
		Assert.assertEquals(act,expected);
	}
	public void assertRentalAgreement() 
	{
		waitUntilVisibility(validation);
		String act = validation.getText();
		System.out.println(act);
		Assert.assertEquals(act, "Please Select Stamp Paper Amount");
	} 
	public void assertValidReceipt() {
		waitUntilVisibility(congo);
		String act = congo.getText();
		System.out.println(act);
		Assert.assertEquals(act, "Congratulations");
	}
	
}
