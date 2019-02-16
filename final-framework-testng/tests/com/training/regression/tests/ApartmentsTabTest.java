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

import com.training.dataproviders.RegisterDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ApartmentsTab;
import com.training.pom.LoginPOM;
import com.training.pom.RegisterPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ApartmentsTabTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ApartmentsTab apartmentsTab;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		apartmentsTab = new ApartmentsTab(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "RETD_003", dataProviderClass = RegisterDataProviders.class)
	public void RegisterTest(String YourName, String EMail, String Subject, String YourMessage) throws InterruptedException {
		
		
		apartmentsTab.clickApartmentsTab();
		apartmentsTab.clickDonecQuis();
		apartmentsTab.sendYourName(YourName);
		apartmentsTab.sendYourEmail(EMail);
		apartmentsTab.sendSubject(Subject);
		apartmentsTab.sendYourMessage(YourMessage);
		apartmentsTab.clickSendButton();
		System.out.println("Message=" + apartmentsTab.getMessage());
	}

}

