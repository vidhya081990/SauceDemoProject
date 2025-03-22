package com.saucedemo.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saucedemo.configs.ConfigReader;

public class DriverFactory {

	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

	public static WebDriver getDriver(ConfigReader config) {

		if (webDriver.get() == null) {
			WebDriver driver = initialiseWebDriver(config.getBrowser());
			webDriver.set(driver);

		}

		return webDriver.get();
	}

	public static WebDriver initialiseWebDriver(String browser) {
		WebDriver driver;

		switch (browser.toLowerCase()) {
		case ("chrome"):
			driver = new ChromeDriver();
			break;
		case ("firefox"):
			driver = new FirefoxDriver();
			break;
		case ("edge"):
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);

		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		return driver;

	}

	public void launchApplication(WebDriver driver, ConfigReader config) {
		driver.get(config.getUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitWait()));

	}

	public static void quitDriver() {
		try {
			if (webDriver.get() != null) {
				webDriver.get().quit();

			}
		} catch (Exception e) {
			System.err.println("Error while quitting WebDriver: " + e.getMessage());
		} finally {
			webDriver.remove();
		}
	}
}
