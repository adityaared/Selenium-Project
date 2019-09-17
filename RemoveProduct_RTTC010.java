




import static org.testng.Assert.assertTrue;
import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddProduct_RTTC009;
import com.training.pom.ChangePasswordPOM;
import com.training.pom.LoginPOM;
import com.training.pom.EnterNewPassword_RTTC006;
import com.training.pom.EnterNewPassword_RTTC007;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import common.Assert;



public class RemoveProduct_RTTC010 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddProduct_RTTC009 AddProductPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		AddProductPOM = new AddProduct_RTTC009(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/
	@Test
	public void ChangePasswordTest() throws InterruptedException {
		loginPOM.sendUserName("adityaared@gmail.com");
		loginPOM.sendPassword("Ixz@2019");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(5000);
		screenShot.captureScreenShot("First");
		AddProductPOM.homeclick();
		Thread.sleep(10000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
		AddProductPOM.ClickProduct();
		Thread.sleep(5000);
		AddProductPOM.Addcart();
		Thread.sleep(5000);
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.id("cart"))).build().perform();
		WebElement viewcart=driver.findElement(By.linkText("View Cart"));
		/*Actions clickvc=new Actions(driver);
		clickvc.moveToElement(viewcart).click().build().perform();*/
		
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();",viewcart);
	    
	    
	    Thread.sleep(5000);
        driver.findElement(By.cssSelector("body.checkout-cart.tb_width_1200.tb_lang_ltr.tb_page_checkout_cart.head_glob_intro_glob_cont_glob_foot_glob_ar_head_glob_ar_intro__def_ar_cont_sys_checkout_cart_ar_col_l_glob_ar_foot_glob_en-gb_733d2.no_touch:nth-child(2) div.container-fluid:nth-child(2) section.tb_area_content.row-wrap.lazyloaded:nth-child(4) div.row.tb_separate_columns.tb_ip_50 div.main.col.col-xs-12.col-sm-fill.col-md-fill div.row_aPJdL.row-wrap.lazyloaded div.row.tb_gut_xs_30.tb_gut_sm_30.tb_gut_md_50.tb_gut_lg_50 div.col_qqWt1.col.col-xs-12.col-sm-12.col-md-12.col-lg-12.col-align-default.col-valign-top.tb_pt_0.tb_pr_0.tb_pb_0.tb_pl_0 div.tb_wt.tb_wt_system.display-block.tb_system_page_content:nth-child(1) div.cart-info.tb_min_w_500 table.table tbody:nth-child(2) tr:nth-child(1) td.quantity div.input-group.btn-block > input.form-control")).clear();
	    driver.findElement(By.cssSelector("body.checkout-cart.tb_width_1200.tb_lang_ltr.tb_page_checkout_cart.head_glob_intro_glob_cont_glob_foot_glob_ar_head_glob_ar_intro__def_ar_cont_sys_checkout_cart_ar_col_l_glob_ar_foot_glob_en-gb_733d2.no_touch:nth-child(2) div.container-fluid:nth-child(2) section.tb_area_content.row-wrap.lazyloaded:nth-child(4) div.row.tb_separate_columns.tb_ip_50 div.main.col.col-xs-12.col-sm-fill.col-md-fill div.row_aPJdL.row-wrap.lazyloaded div.row.tb_gut_xs_30.tb_gut_sm_30.tb_gut_md_50.tb_gut_lg_50 div.col_qqWt1.col.col-xs-12.col-sm-12.col-md-12.col-lg-12.col-align-default.col-valign-top.tb_pt_0.tb_pr_0.tb_pb_0.tb_pl_0 div.tb_wt.tb_wt_system.display-block.tb_system_page_content:nth-child(1) div.cart-info.tb_min_w_500 table.table tbody:nth-child(2) tr:nth-child(1) td.quantity div.input-group.btn-block > input.form-control")).sendKeys("0");
	    driver.findElement(By.xpath("//*[@title='Update']")).click();
	    
	    
		
		
		
	}
}
