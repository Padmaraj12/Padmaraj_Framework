package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AllProperties;
import com.training.pom.LoginPOM;
import com.training.pom.Propertiestab;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AllPropertiesTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private Propertiestab propertiestab;
	private AllProperties allProperties;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		propertiestab = new Propertiestab(driver);
		allProperties = new AllProperties(driver);
		screenShot = new ScreenShot(driver);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		driver.get(baseUrl);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		// driver.quit();
	}

	@Test
	public void validLoginTest() throws InterruptedException {

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();

		propertiestab.clickProperties();
		Thread.sleep(5000);
		propertiestab.clickAddNew();
		propertiestab.sendenterTitle("new launch");
		propertiestab.clickPublish();
		Thread.sleep(5000);
		System.out.println(propertiestab.getnotificationMessage());

		allProperties.clickAllProperties();
		Thread.sleep(2000);
		allProperties.sendInputValue("new launch");
		Thread.sleep(3000);
		allProperties.clicksubmit();
		
	}
}
