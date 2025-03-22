package com.saucedemo.pages;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.utils.JavaScriptUtility;
import com.saucedemo.utils.ElementUtillty;

public class LoginPage implements WebElement {

	@FindBy(id = "user-name")
	private WebElement usernameInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(className = "title")
	private WebElement productsPageTitle;

	@FindBy(xpath = " //h3[@data-test='error']")
	private WebElement invalidLoginError;

	WebDriver driver;
	ElementUtillty elementUtil;
	JavaScriptUtility jsUtility;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtillty();
		jsUtility = new JavaScriptUtility(driver);
		PageFactory.initElements(driver, this);

	}

	public ProductsPage login(String usename, String password) {
		elementUtil.clearValue(usernameInput);
		elementUtil.enterText(usernameInput, usename);
		elementUtil.clearValue(passwordInput);
		elementUtil.enterText(passwordInput, password);
		elementUtil.click(loginButton);

		return new ProductsPage(driver);

	}

	public String getAppStorageDetail(String storageName) {

		return jsUtility.getCookieValueUsingJS(storageName);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return elementUtil.getText(invalidLoginError).trim();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void click() {
		// TODO Auto-generated method stub

	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable String getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

}
