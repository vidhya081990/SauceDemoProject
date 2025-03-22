package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.constants.AppConstants;
import com.saucedemo.utils.DataProviderUtility;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "validUser", dataProviderClass = DataProviderUtility.class, priority = 1)
	
	//Positive Scenario + Application local storage + DataProvider
	public void loginFunctionalityTest(String username, String password) {

		productsPage = loginPage.login(username, password);
		String sessionUsernameValue = loginPage.getAppStorageDetail("session-username");
		Assert.assertEquals(sessionUsernameValue, username);
		String productPageTitle = productsPage.getProductPageTitle();
		Assert.assertEquals(productPageTitle, AppConstants.PRODUCT_PAGE_TITLE);
		productsPage.clickMenu();
		productsPage.clickLogOut();

	}
	//Negative Scenario + Overriding getText()
	@Test(dataProvider = "inValidUser", dataProviderClass = DataProviderUtility.class, priority = 2)

	public void InvalidloginTest(String username, String password, String errorText) {
		loginPage.login(username, password);
		String actualErrorText = loginPage.getText();
		Assert.assertEquals(actualErrorText, errorText);

	}

}
