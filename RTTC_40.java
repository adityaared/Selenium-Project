import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class RTTC_40 {
	
	private WebDriver driver;
	private String BaseUrl;
	private LoginAdminPOM LoginAdminPOM;
	private CategoryAdminPOM CategoryAdminPOM;
	private AddCategoryPOM AddCategoryPOM;
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
	CategoryAdminPOM = new CategoryAdminPOM(driver);
	AddCategoryPOM = new AddCategoryPOM(driver);
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
	LoginAdminPOM.sendUserName("admin");
	LoginAdminPOM.sendPassword("admin@123");
	LoginAdminPOM.clickLoginBtn();
	//CategoryAdminPOM.catalogclick();
	//Thread.sleep(3000);
	//CategoryAdminPOM.categories();
    Actions a=new Actions(driver);
    a.moveToElement(driver.findElement(By.id("button-menu"))).click().build().perform();
    Thread.sleep(2000);
    a.moveToElement(driver.findElement(By.id("button-menu"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).click().build().perform();
    Thread.sleep(3000);
    //a.moveToElement(driver.findElement(By.xpath("//ul[@id='menu']/li[3]/ul/li[1]/a[text()='Categories']"))).click().build().perform();
	//driver.findElement(By.xpath("//ul[@id='menu']/li[3]/ul/li[1]/a[text()='Categories']")).click();
    CategoryAdminPOM.categories();
    /*driver.findElement(By.xpath("//a[@data-original-title='Add New']")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.id("input-name1")).sendKeys("ORNAMENTS");
    driver.findElement(By.xpath("//div[@class='note-editable panel-body']")).sendKeys("ornaments for ladies");
    driver.findElement(By.id("input-meta-title1")).sendKeys("ORNAMENTS");
    driver.findElement(By.id("input-meta-description1")).sendKeys("Ornament for ladies");
    driver.findElement(By.xpath("//button[@type='submit']")).click();*/
    
    Thread.sleep(3000);
   // AddCategoryPOM.Edit();
    
    
	int count=driver.findElements(By.xpath("//input[@type='checkbox']")).size();
	System.out.println(count);
	
	for(int i=0;i<count;i++)
	{
		String txt=driver.findElements(By.xpath("//td[@class='text-left']")).get(i).getText();
		if(txt.equals("ORNAMENTS"))
		{
			driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();
			
		}
		
	}
    driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
    driver.switchTo().alert();
    driver.switchTo().alert().accept();
    
	

}
    
    
}

