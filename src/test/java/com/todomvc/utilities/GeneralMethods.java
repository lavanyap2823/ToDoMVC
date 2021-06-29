package com.todomvc.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.todomvc.driver.WebDriverHelper;
import com.todomvc.stepdefinitions.DriverFactory;

public class GeneralMethods extends DriverFactory {
	
	public static void waitVisiblityOfElementLocated(By ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}

}
