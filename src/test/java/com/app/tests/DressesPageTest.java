package com.app.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pages.DressesPageObjects;
import com.app.pages.HomePageObjects;

public class DressesPageTest {

	HomePageObjects hp;
	DressesPageObjects dp;

	public DressesPageTest() {
		hp = new HomePageObjects();
		dp = new DressesPageObjects();
	}

	@BeforeMethod
	public void beforeMethod() {
		hp.clickDresses();
	}

	@Test(priority = 1)
	public void verifySize() {
		Assert.assertTrue(dp.elementFound(dp.getSizeS()), "size S is not found there");
		Assert.assertTrue(dp.elementFound(dp.getSizeM()), "size M is not found there");
		Assert.assertTrue(dp.elementFound(dp.getSizeL()), "size L is not found there");

	}

	@Test(priority = 2)
	public void verifyProductCount() {
		/*
		 * System.out.println(dp.getProductCountFromHeaderText());
		 * System.out.println(dp.getProductCount());
		 */
		Assert.assertEquals(dp.getProductCountFromHeaderText(), dp.getProductCount(), "Failed:Count Mismatched");
	}

	@Test(priority = 3)
	public void verifyAddToCart() {
		dp.mouseHovering(dp.getFrstDress());
		dp.mouseClick(dp.getAddToCart());

		// System.out.println("the message is" + dp.getPdtMsg());
		Assert.assertTrue(hp.elementFound(dp.getPdcIcon()));
		dp.clickCloseBtn();
		dp.navigateBack();

	}

	@Test(priority = 4)
	public void verifyPriceInAscendingOrder() {

		dp.selectSortOption("price:asc");
		List<Double> prices = dp.getProductPrices();

		for (int index = 0; index < prices.size() - 1; index++) {
			System.out.println("Price" + prices.get(index));
			Assert.assertTrue(prices.get(index) < prices.get(index + 1),
					"Failed:price not in ascending order at index" + index);

		}
	}

	@Test(priority = 5)
	public void verifyProductNamesInAscendingOrder() {

		dp.selectSortOption("name:asc");
		List<String> names = dp.getProductNames();

		for (int i = 0; i < names.size() - 1; i++) {
			System.out.println(names.get(i).compareTo(names.get(i + 1)));
			Assert.assertTrue(names.get(i).compareTo(names.get(i + 1)) <= 0,
					"Not in Ascending order and The Product name is" + names.get(i));

		}
	}

	@AfterClass
	public void afterMethod() {
		dp.quitDriver();
	}

}
