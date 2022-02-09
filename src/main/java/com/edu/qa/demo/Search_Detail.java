package com.edu.qa.demo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Search_Detail extends BaseClass{
	
	
	
	 @FindBy(xpath="//form[@id=\'cse-search-box\']")
	 WebElement form;
	 
	 @FindBy(xpath="//input[@type='text']")
	 WebElement Searh_textField;
	 
	 @FindBy(className="btnSubmit")
	 WebElement Btn;
	
	  //Load the properties file which is define in BaseClass
	  @BeforeTest
	  public void define_prop_class() 
	  {
		 define_Property_class() ; 
	  }
	 
	 //call the method for lunch the Url which is define in BaseClass
	 @BeforeClass
	  public void lunchs_browser()
	  {
		 intilize_browser();
	  }
	 
	 //Search the college for specific name
	 @Test
	 public void search_for_college() 
	 {
		 PageFactory.initElements(driver,this);
		 form.click();
		 Searh_textField.sendKeys("Top MCA College");
		 Btn.click();
	 }
  
	 //close driver
	 @AfterClass
	 public void tearDown()
	 {
		 driver.close();
	 }
}
