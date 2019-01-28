package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
     
	 WebDriver driver;
     
     public RegisterPage(WebDriver driver) {
 		this.driver = driver; 
 		PageFactory.initElements(driver, this);
 	}

     @FindBy(xpath="//a[@href='#tab2']")
     WebElement registerLink;
    
     @FindBy(id="email")
     WebElement email;
     
     @FindBy(id="first-name")
     WebElement firstName;
     
     @FindBy(id="last-name")
     WebElement lastName;
     
     @FindBy(name="submit")
     WebElement register;
     
     @FindBy(xpath="//a[@href='#tab1']")
     WebElement loginTAB;
     
     @FindBy(xpath="//label[@for='first_name']")
     WebElement firstNameLabel;
     
     public void clickRegisterLink() {
    	 registerLink.click();
     }
      
     public void sendEmail(String sendEmail) {
    	 email.click();
    	 email.sendKeys(sendEmail);
     }
     
     public void sendFirstName(String sendFirstName){
    	 firstName.click();
    	 firstName.sendKeys(sendFirstName);
     }
     
     public void sendLastName(String sendLastName) {
    	 lastName.click();
    	 lastName.sendKeys(sendLastName);
     }
     
     public void clickRegister() {
    	 register.click();
     }
     
     public boolean isLoginTABDisplayed() {
    	 return loginTAB.isDisplayed();
     }
     
     public String getFirstNameLabel() {
    	 return firstNameLabel.getText();
     }

}

