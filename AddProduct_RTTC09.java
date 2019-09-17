




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



public class AddProduct_RTTC09 {

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
		//Actions clickvc=new Actions(driver);
		//clickvc.moveToElement(viewcart).click().build().perform();
		
		System.out.println("Click on view cart");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();",viewcart);
	    
		
		 
		
		
		
		
	}
}
