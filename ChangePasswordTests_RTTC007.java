package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangePasswordPOM;
import com.training.pom.LoginPOM;
import com.training.pom.EnterNewPassword_RTTC006;
import com.training.pom.EnterNewPassword_RTTC007;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import common.Assert;



public class ChangePasswordTests_RTTC007 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ChangePasswordPOM ChgPwdPOM;
	private EnterNewPassword_RTTC007 EnterNewPasswordPOM007;
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
		ChgPwdPOM = new ChangePasswordPOM(driver);
		EnterNewPasswordPOM007 = new EnterNewPassword_RTTC007(driver);
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
		ChgPwdPOM.Changepwd();
		EnterNewPasswordPOM007.Enterpwd();
		EnterNewPasswordPOM007.Enterpwdagain();
		 EnterNewPasswordPOM007.clickcontinue();
		 
		
		
		
		
	}
}
