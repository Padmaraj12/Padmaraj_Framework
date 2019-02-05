package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Commercialtab {

	private WebDriver driver;

	public Commercialtab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Commercial')]")
	WebElement commercialtab;

	public void clickCommercialtab() {
		Actions action = new Actions(driver);
		action.moveToElement(commercialtab).build().perform();
		System.out.println("Mouse over on the commercialtab happened");
		commercialtab.click();
	}

	@FindBy(xpath = "//div[@class='wpdreams_asl_container asl_w asl_m asl_m_2']//input[@placeholder='Search here for Properties..']")
	WebElement searchHere;

	public void sendSearchHere(String sendSearchHere) {
		searchHere.sendKeys(sendSearchHere);
	}

	@FindBy(xpath = "//span[@class='overlap']")
	WebElement search;

	public void clickSearch() {
		search.click();
	}

}