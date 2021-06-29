package com.todomvc.stepdefinitions;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.todomvc.constants.DataPlaceHolder;
import com.todomvc.pageobjects.ToDoMVCHomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageTest {
	WebDriver driver = DriverFactory.getChromeDriver();
	ToDoMVCHomePage homepage = new ToDoMVCHomePage(driver);
	String titleOfHomePage;
	int sizeoftodolist;
	String todoCount;
	String expectedTitleOfHomepage = "Vue.js • TodoMVC";

	@Given("User is on ToDoMVC Home Page")
	public void user_is_on_to_do_mvc_home_page() {
		titleOfHomePage = driver.getTitle();
		Assert.assertEquals("TO DO MVC HomePage is title is not as Expected", titleOfHomePage, expectedTitleOfHomepage);
	}

	@When("^User add task to ToDo list as (.+)$")
	public void user_add_task_to_to_do_list_as_validate(String task) {
		WebElement ele = homepage.txtToDoPlaceHolder();
		ele.click();
		todoCount = homepage.todoCount().getText().split("item")[0].trim();
		DataPlaceHolder.saveCount = "".equals(todoCount) ? 0 : Integer.parseInt(todoCount);
		ele.sendKeys(task);
		ele.sendKeys(Keys.ENTER);
	}

	@Then("^User Verify task is added under ToDo List as (.+)$")
	public void user_verify_task_is_added_under_to_do_list_as_validate(String task) {
		sizeoftodolist = homepage.dropdownToDoList().size();

		IntStream.range(0, sizeoftodolist)
				.filter(index -> homepage.dropdownToDoList().get(index).getText().equalsIgnoreCase(task)).forEach(i -> {
					Assert.assertEquals(homepage.dropdownToDoList().get(i).getText().equalsIgnoreCase(task), true);
				});
	}

	@Then("^User Verify task is displayed in Active Tab as (.+)$")
	public void user_verify_task_is_displayed_in_active_tab_as_validate(String task) {
		homepage.linkActive().click();

		IntStream.range(0, sizeoftodolist)
				.filter(index -> homepage.dropdownToDoList().get(index).getText().equalsIgnoreCase(task)).forEach(i -> {
					Assert.assertEquals(homepage.dropdownToDoList().get(i).getText().equalsIgnoreCase(task), true);
				});
	}

	@Then("^User Verify ToDo Count$")
	public void user_verify_to_do_count() {
		Integer currentToDoListCount = Integer.parseInt(homepage.todoCount().getText().split("item")[0].trim());
		Assert.assertEquals(currentToDoListCount == (DataPlaceHolder.saveCount + 1), true);
	}
	@When("User Select Task from ToDo list as (.+)$")
	public void user_select_task_from_to_do_list_validate(String task) {
		
		for(int i=0; i<sizeoftodolist; i++)
		{
			if(homepage.dropdownToDoList().get(i).getText().equalsIgnoreCase(task))
			{
				homepage.dropdownToDoList().get(i).click();
			}
		}
	}

	@Then("User verify Selected Task is displayed Under All Tab as (.+)$")
	public void user_verify_selected_task_is_displayed_under_all_tab_as_validate(String task) {
	  Assert.assertEquals(true, homepage.checkboxtodoCompleted().isSelected());
	}

	@Then("User verify Selected Task is displayed Under Completed Tab as (.+)$")
	public void user_verify_selected_task_is_displayed_under_completed_tab_as_validate(String task) {
	   homepage.linkCompleted().click();
	   Assert.assertEquals(true, homepage.checkboxtodoCompleted().isSelected());
	}

	@Then("User Click on Clear Button")
	public void user_click_on_clear_button() {
		homepage.btnClearCompleted().click();
	}

	@Then("User verify Task is not displayed Under All Tab as (.+)$")
	public void user_verify_task_is_not_displayed_under_all_tab_as_validate(String task) {
		homepage.linkAll().click();
		for(int i=0; i<sizeoftodolist; i++)
		{
			Assert.assertEquals(true, !homepage.dropdownToDoList().get(i).getText().equalsIgnoreCase(task));
		}
	}

	@Then("User verify Task is not displayed Under Completed Tab (.+)$")
	public void user_verify_task_is_not_displayed_under_completed_tab_validate(String task) {
		homepage.linkCompleted().click();
		for(int i=0; i<sizeoftodolist; i++)
		{
			Assert.assertEquals(true, !homepage.dropdownToDoList().get(i).getText().equalsIgnoreCase(task));
		}
	}

	@Then("User Remove task from the ToDo list as (.+)$")
	public void user_remove_task_from_the_to_do_list_as_validate(String task) {
		for(int i=0; i<sizeoftodolist; i++)
		{
			if(homepage.dropdownToDoList().get(i).getText().equalsIgnoreCase(task))
					{
				homepage.btnDestroy().click();
					}
		}
	}

	@Then("User verify task is removed from the List as (.+)$")
	public void user_verify_task_is_removed_from_the_list_as_validate(String task) {
		for(int i=0; i<sizeoftodolist; i++)
		{
			Assert.assertEquals(true, !homepage.dropdownToDoList().get(i).getText().equalsIgnoreCase(task));
		}
	}
	

}
