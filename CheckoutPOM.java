package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPOM {
	

		private WebDriver driver; 
		
		public CheckoutPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//a[@class='btn btn-primary']")
		private WebElement Checkout;
		
		
		public void Check()
		{
		     this.Checkout.click();
		}
		
	}


