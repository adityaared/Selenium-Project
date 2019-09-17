package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewOrderHistory {
	private WebDriver driver; 
	
	
		
	
	@FindBy(linkText="View your order history")
	private WebElement OrderHist;
	
	
	public ViewOrderHistory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void confirmbutton()
	{
	     this.OrderHist.click();
	}

}
