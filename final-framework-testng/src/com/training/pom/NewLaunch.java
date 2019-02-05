package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunch {

	private WebDriver driver;

	public NewLaunch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@id='responsive']//a[contains(text(),'New Launch')]")
	WebElement newLaunch;

	public void selectNewLaunch() {
		Actions action = new Actions(driver);
		action.moveToElement(newLaunch).build().perform();
	}

	@FindBy(xpath = "//ul[@id='responsive']//div[@class='wpmm-post post-156']//img[@class='attachment-wpmm_thumb size-wpmm_thumb wp-post-image']")
	WebElement nullamhendreritApartments;

	public void clicknullamhendreritApartments() {
		nullamhendreritApartments.click();
	}

	@FindBy(xpath = "//input[@name='your-name']")
	WebElement yourName;

	public void sendYourName(String sendYourName) {
		yourName.sendKeys(sendYourName);
	}

	@FindBy(xpath = "//input[@name='your-email']")
	WebElement yourEmail;

	public void sendYourEmail(String sendYourEmail) {
		yourEmail.sendKeys(sendYourEmail);
	}

	@FindBy(xpath = "//input[@name='your-subject']")
	WebElement subject;

	public void sendSubject(String sendSubject) {
		subject.sendKeys(sendSubject);
	}

	@FindBy(xpath = "//textarea[@name='your-message']")
	WebElement yourMessage;

	public void sendYourMessage(String sendYourMessage) {
		yourMessage.sendKeys(sendYourMessage);
	}

	@FindBy(xpath = "//input[@value='Send']")
	WebElement Send;

	public void clickSend() {
		Send.click();
	}

	@FindBy(xpath = "//input[@id='amount']")
	WebElement salePrice;

	public void sendsalePrice(int i) {
		salePrice.sendKeys(Integer.toString(i));
	}

	@FindBy(xpath = "//input[@id='downpayment']")
	WebElement downPayment;

	public void sendDownpayment(int j) {
		downPayment.sendKeys(Integer.toString(j));
	}

	@FindBy(xpath = "//input[@id='years']")
	WebElement loanTerm;

	public void sendLoanTerm(int k) {
		loanTerm.sendKeys(Integer.toString(k));
	}

	@FindBy(xpath = "//input[@id='interest']")
	WebElement interestRate;

	public void sendInterestRate(int l) {
		interestRate.sendKeys(Integer.toString(l));
	}

	@FindBy(xpath = "//button[@class='button calc-button']")
	WebElement calculate;

	public void clickCalculate() {
		calculate.click();
	}

	@FindBy(xpath = "//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	WebElement errorMsg;

	public String getErrorMsg() {
		return errorMsg.getText();
	}

	@FindBy(className = "calc-output-container")
	WebElement notificationMessage;

	public String getnotificationMessage() {
		return notificationMessage.getText();
	}
}