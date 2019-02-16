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

import com.training.dataproviders.DataProvidersRegister;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterDBTest {
	private WebDriver driver;
	private String baseUrl;
	private RegisterPage registerPage;

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
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPage = new RegisterPage(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dataProvider = "db-inputs", dataProviderClass = DataProvidersRegister.class)
	public void loginDBTest(String eMail, String FirstName, String LastName) throws InterruptedException {
		

		registerPage.clickRegisterLink();
		Thread.sleep(2000);
		Assert.assertEquals("First name", registerPage.getFirstNameLabel());
		registerPage.sendEmail(eMail);
		registerPage.sendFirstName(FirstName);
		registerPage.sendLastName(LastName);
		registerPage.clickRegister();

	}
}
