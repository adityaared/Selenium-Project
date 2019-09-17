package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EnterNewPassword_RTTC007 {
	private WebDriver driver; 
	
	public EnterNewPassword_RTTC007(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-password")
	private WebElement newPwd;
	
	@FindBy(id="input-confirm")
	private WebElement newPwd1;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement cont;
	
	
	public void Enterpwd()
	{
	     this.newPwd.sendKeys("Ixz@2019");
	     
	}
	
	public void Enterpwdagain()
	{
	     this.newPwd1.sendKeys("IxZ@2019");
	     
	}
	
	public void clickcontinue()
	{
		this.cont.click();
	}

	
	
}


