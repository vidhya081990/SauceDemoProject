package com.saucedemo.constants;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saucedemo.utils.CommonUtility;

public class Report {
	static CommonUtility commonUtils = new CommonUtility();

	public static final String REPORT_FOLDER = System.getProperty("user.dir") + "/ExtentReports/" + 
											  "ExtentReport"+ commonUtils.getDateFormat() + ".html";

	public static final String REPORT_TITLE = "Sauce Demo";

	public static final String REPORT_NAME = "Sauce Demo Test Report";

	public static final Theme DEFAULT_THEME = Theme.DARK;
}
