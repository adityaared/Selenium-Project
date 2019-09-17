package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickView {
	private WebDriver driver; 
	
	
		
	
	@FindBy(xpath="//a[@title='View']")
	private WebElement eye;
	
	
	public ClickView(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void clickeye()
	{
	     this.eye.click();
	}

}
