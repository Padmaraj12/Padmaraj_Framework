package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {

	WebDriver driver;

	public MyProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='current']")
	WebElement myProfile;

	@FindBy(xpath = "//input[@id='agent_title']")
	WebElement agentTitle;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;

	@FindBy(xpath = "//button[@value='Submit']")
	WebElement saveChanges;

	public void clickmyProfile() {
		myProfile.clear();
	}

	public void sendagentTitle(String sendagentTitle) {
		agentTitle.sendKeys(sendagentTitle);
	}

	public void sendPhone(String sendPhone) {
		phone.sendKeys(sendPhone);
	}

	public void clicksaveChanges() {
		saveChanges.click();
	}

	

}