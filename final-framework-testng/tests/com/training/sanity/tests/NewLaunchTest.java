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
import com.training.pom.NewLaunch;
import com.training.pom.Propertiestab;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class NewLaunchTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private NewLaunch newLaunch;

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
		newLaunch= new NewLaunch(driver);
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
	public void validNewLaunch() throws InterruptedException {
      
		newLaunch.selectNewLaunch();
		newLaunch.clicknullamhendreritApartments();
		newLaunch.sendYourName("selenium");
		newLaunch.sendYourEmail("selenium@gmail.com");
		newLaunch.sendSubject("apartment");
		newLaunch.sendYourMessage("looking for apartment");
		newLaunch.clickSend();
		String errMsgActual = newLaunch.getErrorMsg();
		System.out.println("Actual: " + errMsgActual);
		String errMsgExpected = "There was an error trying to send your message. Please try again later.";
		System.out.println("Expected: " + errMsgExpected);
		Assert.assertEquals(errMsgActual, errMsgExpected);
		newLaunch.sendsalePrice(40000);
        newLaunch.sendDownpayment(2000);
        newLaunch.sendLoanTerm(2);
        newLaunch.sendInterestRate(5);
        newLaunch.clickCalculate();
        Thread.sleep(5000);
		
		Assert.assertTrue(newLaunch.getnotificationMessage().contains("Monthly Payment: "));
		
		System.out.println(newLaunch.getnotificationMessage());
		
	}
}


