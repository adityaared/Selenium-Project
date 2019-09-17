package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryAdminPOM {
	private WebDriver driver; 
	
	public CategoryAdminPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	@FindBy(xpath="//ul[@id='menu']/li[3]/ul/li[1]/a[text()='Categories']")
	private WebElement categories;
	
	
	
	
	
	public void categories() {
		this.categories.click(); 
	}
}
