package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPagePOM {
	

		private WebDriver driver; 
		
		public CheckoutPagePOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="button-payment-address")
		private WebElement billingnext;
		

		@FindBy(id="button-shipping-address")
		private WebElement deliverynext;
		
		@FindBy(id="button-shipping-method")
		private WebElement deliverymethod;
		
		@FindBy(id="button-payment-method")
		private WebElement paymentmethod;
		
		@FindBy(xpath="//input[@name='agree']")
		private WebElement Checkbox;
		
		@FindBy(id="button-confirm")
		private WebElement confirm;
		
		
		public void billingnext()
		{
		     this.billingnext.click();
		}
		
		public void deliverynext()
		{
		     this.deliverynext.click();
		}
		
		public void deliverymethod()
		{
		     this.deliverymethod.click();
		}
		
		public void paymentmethod()
		{
		     this.paymentmethod.click();
		}
		
		public void checkboxclick()
		{
		     this.Checkbox.click();
		}
		
		public void confirmbutton()
		{
		     this.confirm.click();
		}
	}


