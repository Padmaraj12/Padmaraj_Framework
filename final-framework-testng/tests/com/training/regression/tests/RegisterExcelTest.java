package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.RegisterDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterExcelTest {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RegisterPage registerPage;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPage = new RegisterPage(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
 
	@Test(dataProvider = "RETD_001", dataProviderClass = RegisterDataProviders.class)
	public void RegisterTest(String EMail, String firstName, String lastName) throws InterruptedException {
		Assert.assertTrue(registerPage.isLoginTABDisplayed());
		registerPage.clickRegisterLink();
		Thread.sleep(2000);
		Assert.assertEquals("First name", registerPage.getFirstNameLabel());
		registerPage.sendEmail(EMail);
		registerPage.sendFirstName(firstName);
		registerPage.sendLastName(lastName);
		registerPage.clickRegister();

	}

}
