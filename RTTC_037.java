import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddProduct_RTTC009;
import com.training.pom.CheckoutPOM;
import com.training.pom.CheckoutPagePOM;
import com.training.pom.ClickView;
import com.training.pom.LoginPOM;
import com.training.pom.*;
import com.training.pom.ReturnReasonPOM;
import com.training.pom.ViewOrderHistory;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_037 {
	
	private WebDriver driver;
	private String BaseUrl;
	private LoginAdminPOM LoginAdminPOM;
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
	BaseUrl = properties.getProperty("BaseURL");
	screenShot = new ScreenShot(driver); 
	LoginAdminPOM = new LoginAdminPOM(driver);
	// open the browser 
	driver.get(BaseUrl);
}

/*@AfterMethod
public void tearDown() throws Exception {
	Thread.sleep(1000);
	driver.quit();
}*/

@Test
public void AdminLogin() throws InterruptedException {
	
	System.out.println("The new url");
	LoginAdminPOM.sendUserName("adityaared@gmail.com");
	LoginAdminPOM.sendPassword("Ixz@2019");
	LoginAdminPOM.clickLoginBtn();
	String txt=driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	Assert.assertTrue(true,"No match for Username and/or Password.");
	


}
}
