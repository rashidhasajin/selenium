package com.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects extends Basepage {

	public HomePageObjects() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul/li/a[@title='Women']")
	private WebElement Women;

	@FindBy(xpath = "//ul[contains(@class,'menu-content')]/li[2]/a[@title='Dresses']")
	private WebElement Dresses;

	@FindBy(xpath = "//ul[contains(@class,'menu-content')]/li[3]/a[@title='T-shirts']")
	private WebElement Tshirts;

	@FindBy(id = "newsletter-input")
	private WebElement emailTxt;

	@FindBy(xpath = "//*[@name='submitNewsletter']")
	private WebElement emailButton;

	@FindBy(xpath = "//*[@class='alert alert-success']")
	private WebElement emailMsg;
	
	@FindBys(@FindBy(xpath="//ul[@id='homefeatured']/li"))
	private List<WebElement> lstProducts;

	public WebElement getWomen() {
		return Women;
	}

	public void clickWomen() {
		Women.click();
	}

	public WebElement getDresses() {
		return Dresses;
	}

	public void clickDresses() {
		Dresses.click();
	}

	public WebElement getTshirts() {
		return Tshirts;
	}

	public void clickTshirts() {
		Tshirts.click();
	}

	public WebElement getEmail() {
		return emailTxt;
	}

	public WebElement getEmailButton() {
		return emailButton;
	}
	
	public void clickEmailButton() {
		emailButton.click();
	}

	public WebElement getEmailMsg() {
		return emailMsg;
	}
	
	public List<WebElement> getProduct() {
		return lstProducts;
	}
	
	public boolean verifyAddToCart(WebElement parent) {
		return elementFound(parent.findElement(By.xpath(".//*[text()='Add to cart']")));
	}
	
	public String getProductName(WebElement parent) {
		return parent.findElement(By.xpath(".//*[@class='product-name']")).getText();
	}
}
