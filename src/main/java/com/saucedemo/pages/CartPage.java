package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.saucedemo.utils.ElementUtillty;
import com.saucedemo.utils.WaitUtility;

public class CartPage {

	@FindBy(className = "title")
	private WebElement cartTitle;

	WebDriver driver;
	ElementUtillty elementUtility;
	WaitUtility waitUtility;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		elementUtility = new ElementUtillty();
		waitUtility = new WaitUtility(driver);
	}

	public String getCartTitle() {
		return elementUtility.getText(cartTitle);
	}

}
