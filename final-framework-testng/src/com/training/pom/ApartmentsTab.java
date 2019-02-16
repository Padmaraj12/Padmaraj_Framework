package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApartmentsTab {

	private WebDriver driver;

	public ApartmentsTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='http://realestate.upskills.in/region/apartments-in-bangalore/']")
	WebElement apartmentsTab;

	public void clickApartmentsTab() {
		apartmentsTab.click();
	}

	@FindBy(xpath = "//div[@class='row']//div[6]//div[1]//a[1]//div[2]")
	WebElement donecQuis;

	public void clickDonecQuis() {
		donecQuis.click();
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
	WebElement sendButton;

	public void clickSendButton() {
		sendButton.click();
	}

	@FindBy(xpath = "//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	WebElement message;

	public String getMessage() {
		return message.getText();
	}

}
