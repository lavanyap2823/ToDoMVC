package com.todomvc.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.todomvc.constants.FrameworkConstants;

public class ReadPropertyFile {
	
	private static Properties prop;
	public static ReadPropertyFile driver;
	static
	{
		
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Config.properties");
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String getPropertyValue(String key)
	{
		return prop.getProperty(key);
	}

}
