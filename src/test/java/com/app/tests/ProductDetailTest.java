package com.app.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pages.ProductDetailsPageObject;

public class ProductDetailTest {
	
	ProductDetailsPageObject pp;

	public ProductDetailTest() {
		pp=new ProductDetailsPageObject(); 
	}
	
	@BeforeMethod
	public void beforeMethod() {
		pp.mouseHovering(pp.getPdt());
		pp.mouseClick(pp.getMoreBtn());
	}
	
	@Test(priority=1)
	public void verifySocialButtons() {
		Assert.assertTrue(pp.verifyText(pp.getTweet(), "Tweet"), "Absence of tweet button");
		Assert.assertTrue(pp.verifyText(pp.getShare(), "Share"), "Absence of share button");
		pp.navigateBack();	
	}
	
	@Test(priority=2)
	public void verifyPdtDescription() {
		
		Assert.assertTrue(pp.isElementVisible(pp.getPdtDescription()), "Failed");
	}
}


	
