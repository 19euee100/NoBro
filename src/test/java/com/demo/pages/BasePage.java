package com.demo.pages;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class BasePage  
	{
		 WebDriver driver;
		 WebDriverWait wait;
 
	  public BasePage(WebDriver driver)
	    {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        PageFactory.initElements(driver, this);
//	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    }
		public void waitUntilVisibility(WebElement ele) 
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
	}