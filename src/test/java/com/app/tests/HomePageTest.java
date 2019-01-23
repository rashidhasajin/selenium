package com.app.tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.pages.Basepage;
import com.app.pages.HomePageObjects;

public class HomePageTest {
	HomePageObjects homepage;
	Basepage bp;
	
	int value=new Random().nextInt(7000);
	String email="rashi" + value + "@gmail.com";
	 
	public HomePageTest() {
		homepage=new HomePageObjects();
		bp=new Basepage();
	}
	
	@Test
	public void verifyTabs() {
		Assert.assertTrue(homepage.elementFound(homepage.getWomen()));
		
		Assert.assertTrue(homepage.elementFound(homepage.getDresses()));
		
		Assert.assertTrue(homepage.elementFound(homepage.getTshirts()));
	}
	
	@Test(priority=2)
	public void verifypage() {
		homepage.clickWomen();
		Assert.assertTrue(homepage.verifyTitle("Women - My Store"));
		homepage.navigateBack();
		
		homepage.clickDresses();
		Assert.assertTrue(homepage.verifyTitle("Dresses - My Store"));
		homepage.navigateBack();
		
		homepage.clickTshirts();
		Assert.assertTrue(homepage.verifyTitle("T-shirts - My Store"));
		homepage.navigateBack();
	}
	
	@Test
	public void Email() {
		homepage.getEmail().sendKeys(email);
		homepage.getEmailButton();
		homepage.clickEmailButton();
		System.out.println(homepage.getEmailMsg().getText());
		Assert.assertTrue(homepage.verifyText(homepage.getEmailMsg(), "Newsletter"));
		
	}
	
	@Test
	public void verifyAddToCartButton() {
		
		List<WebElement> products=homepage.getProduct();
		
		for(WebElement prod:products) {
			homepage.mouseHovering(prod);
			Assert.assertTrue(homepage.verifyAddToCart(prod), 
					"Failed:Add To Cart Button is not present for the product" + homepage.getProductName(prod));
		}
		
		}
	
	}

		
		
	
