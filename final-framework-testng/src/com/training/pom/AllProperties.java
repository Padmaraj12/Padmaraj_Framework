package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProperties {

	private WebDriver driver;

	public AllProperties(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='wp-first-item current']")
	WebElement allProperties;

	public void clickAllProperties() {
		allProperties.click();

	}

	@FindBy(xpath = "//input[@id='post-search-input']")
	WebElement inputValue;

	public void sendInputValue(String sendInputValue) {
		inputValue.sendKeys(sendInputValue);
	}

	@FindBy(xpath = "//input[@id='search-submit']")
	WebElement submit;

	public void clicksubmit() {
		submit.click();
	}
}
