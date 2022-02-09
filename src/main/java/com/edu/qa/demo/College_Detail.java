package com.edu.qa.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class College_Detail extends BaseClass {
	
	// locate the element using findBy annotation
	 @FindBy(xpath="//a[@href='/Colleges-in-India.aspx']")
	 WebElement classLink;
	 
	 @FindBy(className="dropbox")
	 WebElement ddown;
	 
	 @FindBy(xpath="//select[@name='ctl00$cp_left$ddl_City']")
	 WebElement ddown1;
	 

	 //Load the properties file which is define in BaseClass
    @ BeforeTest
    public void define_propclass() 
    {
    	 define_Property_class();	 
    }
  
   //call the method for lunch the Url which is define in BaseClass
   @BeforeClass
   public void lunch_browser()
   {
	   intilize_browser();
   }
 
   @Test(priority=1)
   public void college_Detail()
   	{
	    //Fetch the path of current page using page factory
	     PageFactory.initElements(driver,this);
	 
	     //locate the webElement and click on it
	    classLink.click();
		
		//create the Object of Select class
		Select select=new Select(ddown);
		
		select.selectByValue("22");
		
		//create the Object of Select class for city
		Select select1=new Select(ddown1);
			
		select1.selectByVisibleText("Chennai");
		
		//Searchbtn.click();
		
   }
   
   //check that button is clickable or not
   @Test(priority=2)
   public static void displaysearch_result()
   {
      WebElement status=driver.findElement(By.xpath("//input[@id='btnSearch']"));
      System.out.println((status.isDisplayed()));
      status.click();
    
   }
 
   //close the driver
   @AfterClass()
   public void tearDown()
   {
	  driver.close();
   }
 

 }
  

