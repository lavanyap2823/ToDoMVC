package com.todomvc.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.todomvc.constants.FrameworkConstants;
import com.todomvc.utilities.ReadPropertyFile;

public class DriverFactory {

	public static WebDriver driver;

	public static WebDriver getChromeDriver() {
		if(driver==null)
		{
			System.out.println("Initialization of Chrome Browser");
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverPath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(ReadPropertyFile.getPropertyValue("url"));
		}
		return driver;
	}

	public void tearDown() {
		driver.quit();
	}

}
