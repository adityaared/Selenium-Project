package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddProduct_RTTC009 {
	private WebDriver driver; 
	
	public AddProduct_RTTC009(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Home')]")
	private WebElement homeclick;
	
	@FindBy(xpath="//div[@class='clear2 clear3 clear4 clear5 clear6 clear7 clear8 clear9 clear10 clear11 clear12 tb_size_4_last tb_size_5_last tb_size_6_last tb_size_7_last tb_size_8_last tb_size_9_last tb_size_10_last tb_size_11_last tb_size_12_last']//div[@class='product-thumb product-thumb_style1']//div[@class='thumbnail']//div[@class='image tb_overlay']//div[@class='image tb_front']//a//span//span//img[contains(@class,'lazyloaded')]")
	private WebElement clickProduct;
	
	@FindBy(id="button-cart")
	private WebElement Addcart;
	
	

	public void homeclick()
	{
		this.homeclick.click();
	}

	public void ClickProduct()
	{
		this.clickProduct.click();
	}
	
	public void Addcart()
	{
		this.Addcart.click();
	}
	
	
}


