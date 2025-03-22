package com.saucedemo.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptUtility {
	JavascriptExecutor js;
	WebDriver driver;

	public JavaScriptUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public String getItemFromLocalStorage(String key) {
		return (String) js.executeScript(String.format("return window.localStorage.getItem('%s');", key));
	}

	public String getCookieValueUsingJS(String cookieName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.cookie.split('; ').find(row => row.startsWith(arguments[0] + '='))?.split('=')[1];";
		return (String) js.executeScript(script, cookieName);

	}
}
