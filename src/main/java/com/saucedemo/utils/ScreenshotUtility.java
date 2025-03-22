package com.saucedemo.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	WebDriver driver;
	CommonUtility commonUtils = new CommonUtility();

	public ScreenshotUtility(WebDriver driver) {
		this.driver = driver;

	}

	public String getScreenhot(String screenshotName) throws IOException {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destinationString = System.getProperty("user.dir") + "/Screenshots/" + screenshotName
				+ commonUtils.getDateFormat() + ".png";
		File destinationFile = new File(destinationString);
		FileUtils.copyFile(sourceFile, destinationFile);
		return destinationString;
	}

}
