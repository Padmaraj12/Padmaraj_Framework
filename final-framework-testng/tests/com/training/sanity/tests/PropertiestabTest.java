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
import com.training.pom.LoginPOM;
import com.training.pom.Propertiestab;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PropertiestabTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private Propertiestab propertiestab;

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
		screenShot.captureScreenShot("First");

		propertiestab.clickProperties();
		Thread.sleep(5000);
		propertiestab.clickAddNew();
		propertiestab.sendenterTitle("new launch");
		propertiestab.clickPrice();
		Thread.sleep(5000);
		propertiestab.sendPriceAmount(5000);
		propertiestab.sendpricepersq(200);
		propertiestab.clickMainDetails();
		propertiestab.sendstatus("New");
		propertiestab.sendLocation("Electronic city");
		propertiestab.sendPossessio("immediate");
		propertiestab.clickLocation();
		propertiestab.sendAddress("yeshwanthapur");
		propertiestab.sendGoogleMapsAddress("yeshwanthapur");
		propertiestab.sendLatitude(120);
		propertiestab.sendLongitude(56);
		propertiestab.clickDetails();
		propertiestab.sendStorageRoom(2);
		propertiestab.selectCentralBangalore();
		propertiestab.clickPublish();
		Thread.sleep(5000);
		System.out.println(propertiestab.getnotificationMessage());

	}
}
