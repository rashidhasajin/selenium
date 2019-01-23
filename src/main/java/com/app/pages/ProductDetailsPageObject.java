package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPageObject extends Basepage {
	
	public ProductDetailsPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='socialsharing_product list-inline no-print']/button[1]")
	private WebElement Tweet;
	
	@FindBy(xpath="//*[@class='socialsharing_product list-inline no-print']/button[2]")
	private WebElement Share;
	
	@FindBy(xpath="//*[@id='homefeatured']/li//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement Pdt;
	
	@FindBy(xpath="//*[@id='homefeatured']/li[1]//*[text()='More']")
	private WebElement moreBtn;
	
	@FindBy(xpath="//*[@class='pb-center-column col-xs-12 col-sm-4']//*[@id='short_description_content']/p")
	private WebElement pdtDescription;
	
	public WebElement getTweet() {
		return Tweet;
	}
	
	public WebElement getShare() {
		return Share;
	}
	
	public WebElement getPdt() {
		return Pdt;
	}
	
	public WebElement getMoreBtn() {
		return moreBtn;
	}
	
	public WebElement getPdtDescription() {
		return pdtDescription;
	}
}
