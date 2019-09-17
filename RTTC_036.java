

	





import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.training.pom.CheckoutPagePOM;
import com.training.pom.EnterNewPassword_RTTC007;
import com.training.pom.CheckoutPOM;
import com.training.pom.*;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import common.Assert;



public class RTTC_036 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddProduct_RTTC009 AddProductPOM;
	private CheckoutPOM CheckoutPOM;
	private CheckoutPagePOM CheckoutPagePOM;
	private ViewOrderHistory ViewOrderHistory;
	private ClickView ClickView;
	private ReturnPOM ReturnPOM;
	private ReturnReasonPOM ReturnReasonPOM;
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
		CheckoutPOM =new CheckoutPOM(driver);
		CheckoutPagePOM = new CheckoutPagePOM(driver);
		ViewOrderHistory = new ViewOrderHistory(driver);
		ClickView=new ClickView(driver);
		ReturnPOM = new ReturnPOM(driver);
		ReturnReasonPOM = new ReturnReasonPOM(driver);
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
		//Actions clickvc=new Actions(driver);
		//clickvc.moveToElement(viewcart).click().build().perform();
		
		System.out.println("Click on view cart");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();",viewcart);
	    Thread.sleep(5000);
	    CheckoutPOM.Check();
	    
	    Thread.sleep(5000);
	    CheckoutPagePOM.billingnext();
	    Thread.sleep(5000);
	    CheckoutPagePOM.deliverynext();
	    Thread.sleep(5000);
	    CheckoutPagePOM.deliverymethod();
	    Thread.sleep(5000);
	    CheckoutPagePOM.checkboxclick();
	    Thread.sleep(5000);
	    CheckoutPagePOM.paymentmethod();//Adding Product completed.
	    Thread.sleep(5000);
	    CheckoutPagePOM.confirmbutton();
	    Thread.sleep(10000);
	    Actions ack=new Actions(driver);
	    ack.moveToElement(driver.findElement(By.xpath("//i[@class='fa fa-user-o']"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).click().build().perform();
	    ViewOrderHistory.confirmbutton();
	    Thread.sleep(5000);
	    ClickView.clickeye();
	    Thread.sleep(5000);
	    ReturnPOM.clickreturn();
	    Thread.sleep(5000);
	    ReturnReasonPOM.clickreturnreason();
	    ReturnReasonPOM.ProdOpen();
	    ReturnReasonPOM.Comments("Product is fault");
	    Thread.sleep(3000);
	    ReturnReasonPOM.submit();
	    
		
		 
		
		
		
		
	}

}
