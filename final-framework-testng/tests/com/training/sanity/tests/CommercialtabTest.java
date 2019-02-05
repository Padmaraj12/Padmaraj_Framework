package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Commercialtab;
import com.training.pom.LoginPOM;
import com.training.pom.NewLaunch;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CommercialtabTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private NewLaunch newLaunch;
	private Commercialtab commercialtab;

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
		newLaunch = new NewLaunch(driver);
		commercialtab = new Commercialtab(driver);
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
	public void validCommercialtab() throws InterruptedException {

		commercialtab.clickCommercialtab();
		commercialtab.sendSearchHere("Nullam hendrerit apartment");
		Thread.sleep(2000);
		commercialtab.clickSearch();

		String homeWindow = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String each : tabs) {
			System.out.println(each);
		}
		;
		driver.switchTo().window(tabs.get(1));

		newLaunch.sendYourName("selenium");
		newLaunch.sendYourEmail("selenium@gmail.com");
		newLaunch.sendSubject("apartment");
		newLaunch.sendYourMessage("looking for apartment");
		newLaunch.clickSend();

	}

}
