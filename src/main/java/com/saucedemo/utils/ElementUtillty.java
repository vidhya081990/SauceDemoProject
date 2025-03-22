package com.saucedemo.utils;

import org.openqa.selenium.WebElement;

public class ElementUtillty {

	public void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void click(WebElement element) {
		element.click();

	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public void clearValue(WebElement element) {
		element.clear();

	}

}
