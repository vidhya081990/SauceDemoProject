package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saucedemo.constants.AppConstants;

public class ProductTest extends BaseTest {

	@BeforeClass
	@Parameters({ "username", "password" })
	public void login(String username, String password) {
		productsPage=loginPage.login(username, password);
	}
	// Positive scenario + Parameter
	@Test(priority = 1)
	public void verifyProductPageTitle() {
		String actualProductPageTitle = productsPage.getProductPageTitle();
		Assert.assertEquals(actualProductPageTitle, AppConstants.PRODUCT_PAGE_TITLE);
	}

	@Test(priority = 2, dependsOnMethods ="verifyProductPageTitle" )
	public void VerifyAddToCart() {
		productsPage.clickOnAddToCart();
		String count = productsPage.getItemCountInCart();
		Assert.assertEquals(count, "1");
	}

	@Test(priority = 3, dependsOnMethods ="VerifyAddToCart")
	public void VerifyRemoveFromCart() {
		productsPage.clickRemove();
		String count = productsPage.getItemCountInCart();
		Assert.assertEquals(count, "0");
	}

}
