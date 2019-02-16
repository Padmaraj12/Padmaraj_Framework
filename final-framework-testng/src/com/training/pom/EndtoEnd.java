package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EndtoEnd {

	private WebDriver driver;

	public EndtoEnd(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Posts')]")
	WebElement posts;

	public void clickPosts() {
		posts.click();
	}

	@FindBy(xpath = "//a[@href='edit-tags.php?taxonomy=category']")
	WebElement categories;

	public void clickCategories() {
		categories.click();
		System.out.println("Click on Categories");
	}

	@FindBy(xpath = "//input[@id='tag-name']")
	WebElement tagName;

	public void sendTagName(String sendTagName) {
		tagName.sendKeys(sendTagName);
	}

	@FindBy(xpath = "//input[@id='tag-slug']")
	WebElement slug;

	public void sendSlug(String sendSlug) {
		slug.sendKeys(sendSlug);
	}

	@FindBy(xpath = "//textarea[@id='tag-description']")
	WebElement description;

	public void sendDescription(String sendDescription) {
		description.sendKeys(sendDescription);
	}

	@FindBy(xpath = "//input[@id='submit']")
	WebElement addNewCategory;

	public void clickAddNewCategory() {
		addNewCategory.click();
	}

	@FindBy(xpath = "//a[@class='wp-first-item current']")
	WebElement allPosts;

	public void clickAllposts() {
		allPosts.click();
	}

	@FindBy(xpath = "//a[@class='page-title-action']")
	WebElement addNew;

	public void clickAddNew() {
		addNew.click();
	}

	@FindBy(xpath = "//input[@id='title']")
	WebElement title;

	public void sendTitle(String sendTitle) {
		title.sendKeys(sendTitle);
	}

	@FindBy(xpath = "//textarea[@id='content']")
	WebElement textBox;

	public void sendTextBox(String sendTextBox) {
		textBox.sendKeys(sendTextBox);
	}

	@FindBy(xpath = "//input[@id='in-category-159']")
	WebElement allCategories;

	public void clickAllCategories() {
		allCategories.click();
	}

	@FindBy(xpath = "//input[@id='publish']")
	WebElement publish;

	public void clickPublish() {
		publish.click();
	}

	
    @FindBy(xpath = "//a[@class='ab-item'][contains(text(),'Log Out')]")
	WebElement logOut;

	public void clickLogOut() {
		logOut.click();
	}

	@FindBy(xpath = "//li[@class='menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-150 current_page_item current_page_parent menu-item-617']//a[contains(text(),'Blog')]")
	WebElement blog;

	public void clickBlog() {
		blog.click();
	}

}
