package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPOM {
	private WebDriver driver; 
	
	public AddCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	@FindBy(xpath="//a[@data-original-title='Add New']")
	private WebElement Plus;
	
	@FindBy(id="input-name1")
	private WebElement Catname;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement CatDesc;
	
	@FindBy(id="input-meta-title1")
	private WebElement metatitle;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath="//a[@data-original-title='Edit']")
	private WebElement Edit;
	
	
	@FindBy(id="input-meta-description1")
	private WebElement metadesc	;
	
	public void CatDesc(String desc) {
		this.CatDesc.sendKeys(desc); 
	}
	public void metatitle(String desc) {
		this.metatitle.sendKeys(desc); 
	}
	
	public void metatitleclear() {
		this.metatitle.clear(); 
	}
	
	
	public void metadesc(String desc) {
		this.metadesc.sendKeys(desc); 
	}
	
	public void CatName(String Catname) {
		this.Catname.sendKeys(Catname); 
	}
	
	
	public void AddNew() {
		this.Plus.click(); 
	}
	
	public void Edit() {
		this.Edit.click(); 
	}
	
	public void submit() {
		this.submit.click(); 
	}
}
