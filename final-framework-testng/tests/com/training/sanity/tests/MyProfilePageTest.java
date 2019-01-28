package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.MyProfilePage;
import com.training.pom.RegisterPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MyProfilePageTest {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private MyProfilePage myProfilePage;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		myProfilePage = new MyProfilePage(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("implicitWait")), TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void validLoginTest() throws InterruptedException {
		
		loginPOM.sendUserName("agcistns04aa@gmail.com");
		loginPOM.sendPassword("Veer@123");
		loginPOM.clickLoginBtn(); 
		
		myProfilePage.clickmyProfile();
		myProfilePage.sendagentTitle("manzoor");
		myProfilePage.sendPhone("9876543210");
		myProfilePage.clicksaveChanges();
		
	}


}
