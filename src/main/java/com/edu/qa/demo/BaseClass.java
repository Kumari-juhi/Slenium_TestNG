package com.edu.qa.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	
  
	 public static WebDriver driver;
	 static Properties prop;
	 final static String propertyFilePath= "C:\\Users\\juhikumari\\eclipse-workspace\\New_Mini_Project\\src\\main\\resources\\com\\edu\\qa\\config\\config.properties";
	 
	//Create the object of Property class and load the config file
	  public void define_Property_class() 
	  {
		 
			BufferedReader reader;
		 try
		  {
			 prop=new Properties();
			 reader = new BufferedReader(new FileReader(propertyFilePath));
			 prop.load(reader);
			 System.out.println(prop.getProperty("browser"));
			 System.out.println(prop.getProperty("url"));
		  }
		 
		 catch (FileNotFoundException e)
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		 catch (IOException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	  }
	  
	 //Initialize the browser and  lunch URl
	  public void intilize_browser()
	  {
		  String Browser=prop.getProperty("browser");
		  if(Browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(Browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		  
		  driver.get(prop.getProperty("url"));
		//maximize the window
			
		driver.manage().window().maximize();
	  }
	  

}
