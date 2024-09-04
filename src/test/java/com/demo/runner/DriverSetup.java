package com.demo.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {
	private String browserName;
	WebDriver driver;

	public DriverSetup(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver initDriver() {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
//			options.addArguments("--start-maximized");
			options.addArguments("--disable-popup-blocking");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
//			driver.navigate().to(url);
			return driver;
		} else {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
//			options.setCapability("Capability.Notifications", false);
//			options.addArguments("--start-maximized");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-notification");
			driver = new EdgeDriver(options);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
//			driver.navigate().to(url);
			return driver;
		}
	}

	public void closeDriver() {
		driver.close();
	}

}
