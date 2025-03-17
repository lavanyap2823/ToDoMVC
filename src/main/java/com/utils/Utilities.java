package com.utils;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utilities {


    public static void doubleClickUsingActions(WebElement element){
        Actions actions = new Actions(Driver.getdriver);
        actions.doubleClick(element).perform();
    }
}
