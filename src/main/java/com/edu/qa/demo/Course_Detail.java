package com.edu.qa.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Course_Detail extends BaseClass{
	
	// locate the element using findBy annotation
	 @FindBy(xpath="//a[@href='/Courses-in-India.aspx']")
	 WebElement Cour_Link;
	 
	 @FindBy(xpath="//select[@id='ddl_Category']")
	 WebElement dd;
	 
	 @FindBy(xpath="//input[@id='btnSearch']")
	 WebElement Btn;
	
	//Load the properties file which is define in BaseClass
	 @BeforeTest
	  public void define_classprop() 
	  {
		 define_Property_class() ; 
	  }
	  
	//call the method for lunch the Url which is define in BaseClass
	 @BeforeClass
	  public void browser_initialization()
	  {
		 intilize_browser();
	  }
	 
	
	 //Select the course from dropDown
	 @Test(priority=1)
	 public void courseLink()
	 {
		 
		 PageFactory.initElements(driver, this);
		 
		 Cour_Link.click();
	  
		 Select select=new Select(dd);
		
		 select.selectByValue("22");
	  
		 Btn.click();
	 }
     
	 //close the driver
	 @AfterClass
	 public void tearDown()
	 {
		 driver.close();
	 }
  
}
