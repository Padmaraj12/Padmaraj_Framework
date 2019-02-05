package com.training.pom;

import java.awt.Desktop.Action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Propertiestab {

	private WebDriver driver;
	private Actions actions;
	private JavascriptExecutor jse;

	public Propertiestab(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='wp-menu-image dashicons-before dashicons-admin-multisite']")
	WebElement properties;

	public void clickProperties() {
		properties.click();
	}

	@FindBy(xpath = "//a[@href='post-new.php?post_type=property']")
	WebElement addNew;

	public void clickAddNew() {
		addNew.click();
	}

	@FindBy(xpath = "//input[@id='title']")
	WebElement enterTitle;

	public void sendenterTitle(String sendenterTitle) {
		enterTitle.sendKeys(sendenterTitle);
	}

	@FindBy(xpath = "//a[contains(text(),'Price')]")
	WebElement price;

	public void clickPrice() {
		actions.moveToElement(price).click();
		System.out.println("Clicked on Price");
	}

	@FindBy(xpath = "//textarea[@id='_price']")
	WebElement priceAmount;

	public void sendPriceAmount(int i) {
		priceAmount.sendKeys(Integer.toString(i));
	}

	@FindBy(xpath = "//input[@id='_price_per']")
	WebElement pricepersq;

	public void sendpricepersq(int j) {
		pricepersq.sendKeys(Integer.toString(j));
	}

	@FindBy(xpath = "//a[@id='ui-id-2']")
	WebElement mainDetails;

	public void clickMainDetails() {
		mainDetails.click();
	}

	@FindBy(xpath = "//input[@id='_status']")
	WebElement status;

	public void sendstatus(String sendstatus) {
		status.sendKeys(sendstatus);
	}

	@FindBy(xpath = "//input[@id='_location']")
	WebElement location;

	public void sendLocation(String sendLocation) {
		location.sendKeys(sendLocation);
	}

	@FindBy(xpath = "//input[@id='_possession']")
	WebElement possessio;

	public void sendPossessio(String sendPossessio) {
		possessio.sendKeys(sendPossessio);
	}

	@FindBy(xpath = "//a[@id='ui-id-3']")
	WebElement locationAdd;

	public void clickLocation() {
		locationAdd.click();
		System.out.println("Clicked on locationAdd");
	}

	@FindBy(xpath = "//input[@id='_friendly_address']")
	WebElement address;

	public void sendAddress(String sendAddress) {
		address.sendKeys(sendAddress);
	}

	@FindBy(xpath = "//input[@id='_address']")
	WebElement googleMapsAddress;

	public void sendGoogleMapsAddress(String sendGoogleMapsAddress) {
		googleMapsAddress.sendKeys(sendGoogleMapsAddress);
	}

	@FindBy(xpath = "//input[@id='_geolocation_lat']")
	WebElement latitude;

	public void sendLatitude(int k) {
		latitude.sendKeys(Integer.toString(k));
	}

	@FindBy(xpath = "//input[@id='_geolocation_long']")
	WebElement longitude;

	public void sendLongitude(int l) {
		longitude.sendKeys(Integer.toString(l));
	}

	@FindBy(xpath = "//a[@id='ui-id-4']")
	WebElement details;

	public void clickDetails() {
		details.click();
		System.out.println("Clicked on details");
	}

	@FindBy(xpath = "//input[@id='_storage_room']")
	WebElement storageRoom;

	public void sendStorageRoom(int m) {
		storageRoom.sendKeys(Integer.toString(m));
	}

	@FindBy(xpath = "//li[@data-id='24']//input[@value='24']")
	WebElement centralBangalore;

	public void selectCentralBangalore() {
		centralBangalore.click();
		System.out.println("Central Bangalore is Selected");
	}

	@FindBy(xpath = "//input[@id='publish' and @type='submit' and @name='publish']")
	WebElement publish;

	public void clickPublish() throws InterruptedException {
		jse.executeScript("window.scrollBy(0,-900)", "");
		Thread.sleep(1000);
		publish.click();

	}
	@FindBy(xpath="//p[contains(text(),'Post published.')]")
	WebElement notificationMessage;

	public String getnotificationMessage() {
		return notificationMessage.getText();
	}
}
