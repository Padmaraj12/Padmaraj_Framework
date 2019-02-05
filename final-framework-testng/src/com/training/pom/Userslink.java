package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Userslink {

	private WebDriver driver;

	public Userslink(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Users')]")
	WebElement users;

	public void clickUsers() {
		users.click();

	}

	@FindBy(xpath = "//a[@href='user-new.php']")
	WebElement addNew;

	public void clickAddNew() {
		addNew.click();

	}

	@FindBy(xpath = "//input[@id='user_login']")
	WebElement userName;

	public void sendUserName(String sendUserName) {
		userName.sendKeys(sendUserName);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	public void sendEmail(String sendEmail) {
		email.sendKeys(sendEmail);
	}

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstname;

	public void sendFirstname(String sendFirstname) {
		firstname.sendKeys(sendFirstname);
	}

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastname;

	public void sendLastname(String sendLastname) {
		lastname.sendKeys(sendLastname);
	}

	@FindBy(xpath = "//input[@id='url']")
	WebElement url;

	public void sendUrl(String sendUrl) {
		url.sendKeys(sendUrl);
	}

	@FindBy(xpath = "//button[contains(text(),'Show password')]")
	WebElement password;

	public void clickPassword() throws InterruptedException {
		password.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='pass1-text']")).clear();
		driver.findElement(By.xpath("//input[@id='pass1-text']")).sendKeys("Manzoor@Mehadi123");

	}

	@FindBy(xpath = "//input[@id='send_user_notification']")
	WebElement userNotification;

	public void clickUserNotification() {
		userNotification.click();
	}

	@FindBy(xpath = "//select[@id='role']")
	WebElement role;

	public void selectRole() {
		Select role = new Select(driver.findElement(By.id("role")));
		role.selectByVisibleText("Agent");
		role.selectByIndex(2);
	}

	@FindBy(xpath = "//input[@id='createusersub']")
	WebElement addNewUser;

	public void clickAddNewUser() {
		addNewUser.click();
	}

	@FindBy(xpath = "//a[contains(text(),'All Users')]")
	WebElement allUsers;

	public void clickAllUsers() {
		allUsers.click();
	}

	@FindBy(xpath="//p[contains(text(),'New user created.')]")
	WebElement newuser;

	public String getnewuser() {
		return newuser.getText();
	}

}
