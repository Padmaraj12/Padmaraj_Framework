package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.EndtoEnd;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EndtoEndTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private EndtoEnd endtoEnd;

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
		endtoEnd = new EndtoEnd(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		driver.get(baseUrl);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}

	@Test
	public void validLoginTest() throws InterruptedException {

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("First");

		endtoEnd.clickPosts();
		Thread.sleep(5000);
		endtoEnd.clickCategories();
		endtoEnd.sendTagName("New Launches");
		endtoEnd.sendSlug("launch");
		endtoEnd.sendDescription("New Launches of villas, apartments, flats");
		endtoEnd.clickAddNew();
		endtoEnd.clickAllposts();
		endtoEnd.clickAddNew();
		endtoEnd.sendTitle("New Launches");
		endtoEnd.sendTextBox(" New Launch in Home");
		endtoEnd.clickAllCategories();
		endtoEnd.clickPublish();
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@class='avatar avatar-26 photo']"))).build().perform();
		endtoEnd.clickLogOut();
	
	}
	
}
