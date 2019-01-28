package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LostYourPassword {

	WebDriver driver;

	public LostYourPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Lost Your Password?')]")
	WebElement lostYourPassword;

	public void clickLostYourPassword() {
		lostYourPassword.click();
	}

	@FindBy(xpath = "//input[@id='user_login']")
	WebElement emailAddress;

	public void sendemailAddress(String sendemailAddress) {
		emailAddress.sendKeys(sendemailAddress);
	}

    @FindBy(xpath="//input[@value='Reset Password']")
    WebElement resetPassword;
    
    public void clickResetPassword() {
    	resetPassword.click();
    }
    
}

