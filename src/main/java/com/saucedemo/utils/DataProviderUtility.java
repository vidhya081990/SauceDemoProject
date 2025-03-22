package com.saucedemo.utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	@DataProvider(name = "validUser")
	public Object[][] getValidData() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "visual_user", "secret_sauce" } };
	}

	@DataProvider(name = "inValidUser")
	public Object[][] getInvalidData() {
		return new Object[][] {
				{ "error_user", "secret_sauc",
						"Epic sadface: Username and password do not match any user in this service" },
				{ "locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out." } };
	}
}
