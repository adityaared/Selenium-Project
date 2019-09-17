package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturnReasonPOM {
	private WebDriver driver; 
	
	
		
	
	@FindBy(xpath="//div[@class='col-sm-10']//div[1]//label[1]//input[1]")
	private WebElement Returnreason;
	
	@FindBy(xpath="//body[@class='account-return-add-891 tb_width_1200 tb_lang_ltr tb_page_account_return_add is_logged head_glob_intro_glob_cont_glob_foot_glob_ar_head_glob_ar_intro__def_ar_cont__def_ar_col_l_glob_ar_foot_glob_en-gb_733d2 no_touch']/div[@id='wrapper']/section[@id='content']/div[@class='row tb_separate_columns tb_ip_50']/div[@class='main col col-xs-12 col-sm-fill col-md-fill']/div[@class='row_8rjbB row-wrap lazyloaded']/div[@class='row tb_gut_xs_30 tb_gut_sm_30 tb_gut_md_50 tb_gut_lg_50']/div[@class='col_hJRg2 col col-xs-12 col-sm-12 col-md-12 col-lg-12 col-align-default col-valign-top tb_pt_0 tb_pr_0 tb_pb_0 tb_pl_0']/div[@id='System_s3bhXNDb']/form[@id='return_request_form']/fieldset/div[@class='form-group required']/div[@class='col-sm-10']/label[1]")
	private WebElement ProdOpen;
	
	@FindBy(id="input-comment")
	private WebElement Comments;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	public ReturnReasonPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void clickreturnreason()
	{
	     this.Returnreason.click();
	}
	public void ProdOpen()
	{
	     this.ProdOpen.click();
	}
	public void Comments(String faulttext)
	{
	     this.Comments.sendKeys(faulttext);
	}
	public void submit()
	{
	     this.submit.click();
	}


	
}
