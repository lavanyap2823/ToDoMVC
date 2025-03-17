package com.pages;

import com.utils.Utilities;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

public class HomePage {
    private final By textbox_input = By.xpath("//input[@id='todo-input']");
    private final By dd_todolist =  By.xpath("//label[@data-testid='todo-item-label']");
    private final By checkbox_todo = By.xpath("//input[@data-testid='todo-item-toggle']");
    private final By status_completed = By.xpath("//li[@class='completed']/div/label");
    private final By link_All = By.xpath("//a[text()='All']");
    private final By link_Active = By.xpath("//a[text()='Active']");
    private final By link_Completed = By.xpath("//a[text()='Completed']");
    private final By link_ClearCompleted = By.xpath("//button[text()='Clear completed']");
    private final By link_TodoCount = By.xpath("//span[@class='todo-count']");

    private static final Logger log = Logger.getLogger(String.valueOf(HomePage.class));

    public void clickAddToDo(){
        Driver.getdriver.findElement(textbox_input).click();
    }

    public void addNewTodo(String newtodo){
        Driver.getdriver.findElement(textbox_input).sendKeys(newtodo);
    }

    public void enter(){
        Driver.getdriver.findElement(textbox_input).sendKeys(Keys.ENTER);
    }

    public String listOfTodos(String todos){
        String verifytodo = null;
        try{
       List<WebElement> todolist = Driver.getdriver.findElements(dd_todolist);
         for(WebElement todo : todolist){
             log.info(todo.getText());
             if (todo.getText().contains(todos)){
                 verifytodo = todo.getText();
                 break;
             }
         }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return verifytodo;
    }

    public boolean verifyTodoList(String todos){
        boolean isTodoPresent = false;
        try {
            List<WebElement> todolist = Driver.getdriver.findElements(dd_todolist);
            for (WebElement todo : todolist) {
                if (todo.getText().contains(todos)) {
                    isTodoPresent = true;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isTodoPresent;
    }

    public void clickOnTodoCheckbox(String completedtodo){
        List<WebElement> completedtodolist = Driver.getdriver.findElements(checkbox_todo);
        completedtodolist.get(0).click();
        }

    public String verifyCompletedTodo(String completedtodo){
        String todocompleted = null;
        try{
        List<WebElement> completedtodolist = Driver.getdriver.findElements(status_completed);
        for(WebElement todo : completedtodolist){
            if(todo.getText().contains(completedtodo)){
                todocompleted = todo.getText();
                break;
            }
        }}
        catch (Exception e) {
            e.printStackTrace();
        }
        return todocompleted;
    }

    public void clickActiveLink(){
        Driver.getdriver.findElement(link_Active).click();
    }

    public void clickCompletedLink(){
        Driver.getdriver.findElement(link_Completed).click();
    }

    public void clickAllLink(){
        Driver.getdriver.findElement(link_All).click();
    }

    public void clickClearCompletedLink(){
        Driver.getdriver.findElement(link_ClearCompleted).click();
    }

    public void doubleClickonTodo(String todos, String updatedtodo){
        String verifytodo = null;
        try{
            List<WebElement> todolist = Driver.getdriver.findElements(dd_todolist);
            for(WebElement todo : todolist){
                log.info(todo.getText());
                log.info(todos);
                if (todo.getText().contains(todos)){
                    Utilities.doubleClickUsingActions(todo);
                    todo.sendKeys(Keys.BACK_SPACE);
                    todo.sendKeys(updatedtodo);
                    todo.sendKeys(Keys.ENTER);
                    break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTodoCount(){
        String todoCountText =  Driver.getdriver.findElement(link_TodoCount).getText().split("item")[0].trim();
        log.info("Todo Count is: "+todoCountText);
        return todoCountText;
    }

}
