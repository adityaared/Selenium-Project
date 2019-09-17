package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturnPOM {
	private WebDriver driver; 
	
	
		
	
	@FindBy(xpath="//a[@title='Return']")
	private WebElement Return;
	
	
	public ReturnPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void clickreturn()
	{
	     this.Return.click();
	}

}
