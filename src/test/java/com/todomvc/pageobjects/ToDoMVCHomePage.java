package com.todomvc.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class ToDoMVCHomePage {
	
	public WebDriver driver;
	
	public ToDoMVCHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private String txtToDoPlaceHolder = "//input[@placeholder='What needs to be done?']";
	private String dropdownToDoList = "//ul[@class='todo-list']/li";
	private String lblToDoCount = "//span[@class='todo-count']";
	private String linkAll = "//ul[@class='filters'] //a[text()='All']";
	private String linkActive = "//ul[@class='filters'] //a[text()='Active']";
	private String linkCompleted = "//ul[@class='filters'] //a[text()='Completed']";
	private String checkboxtodoCompleted = "//li[@class='todo completed']";
	private String btnClearCompleted = "//button[@class='clear-completed']";
	private String btnDestroy = "//div[@class='view']/button";
	
	public WebElement txtToDoPlaceHolder()
	{
		 return driver.findElement(By.xpath(txtToDoPlaceHolder));
	}
	public  List<WebElement> dropdownToDoList()
	{
		return driver.findElements(By.xpath(dropdownToDoList));
	}
	public WebElement todoCount()
	{
		return driver.findElement(By.xpath(lblToDoCount));
	}
	public WebElement linkAll()
	{
		return driver.findElement(By.xpath(linkAll));
	}
	public WebElement linkActive()
	{
		return driver.findElement(By.xpath(linkActive));
	}
	public WebElement linkCompleted()
	{
		return driver.findElement(By.xpath(linkCompleted));
	}
	public WebElement checkboxtodoCompleted()
	{
		return driver.findElement(By.xpath(checkboxtodoCompleted));
	}
	public WebElement btnClearCompleted()
	{
		return driver.findElement(By.xpath(btnClearCompleted));
	}
	public WebElement btnDestroy()
	{
		return driver.findElement(By.xpath(btnDestroy));
	}
	
}
