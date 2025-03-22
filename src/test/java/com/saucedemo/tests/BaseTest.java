package com.saucedemo.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.saucedemo.configs.ConfigReader;
import com.saucedemo.driver.DriverFactory;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.ExtentReportManager;
import com.saucedemo.utils.ScreenshotUtility;

public class BaseTest {

	WebDriver driver;
	ConfigReader config;
	DriverFactory driverFactory;
	LoginPage loginPage;
	ProductsPage productsPage;
	ScreenshotUtility screenshotUtility;

	ExtentReportManager extentReportManager;
	ExtentTest logger;
	String screenshotPath;
	ExtentReports reports;

	@BeforeTest
	public void init() throws Exception {
		config = new ConfigReader();
		driverFactory = new DriverFactory();
		driver = DriverFactory.getDriver(config);
		driverFactory.launchApplication(driver, config);
		loginPage = new LoginPage(driver);
		screenshotUtility = new ScreenshotUtility(driver);
		extentReportManager = new ExtentReportManager();
		reports = extentReportManager.startReport();

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		String methodName = result.getName();
		screenshotPath = screenshotUtility.getScreenhot(methodName);
		logger = extentReportManager.getExtentTest(result.getName());

	}

	@AfterMethod
	public void testResult(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, "Test Case Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Test Case Failed");
		}
	}

	@AfterTest
	public void teardown() {
		DriverFactory.quitDriver();

	}

	@AfterSuite
	public void closeReport() {
		extentReportManager.endReport();

	}

}
