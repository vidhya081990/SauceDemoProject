package com.saucedemo.configs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	Properties prop;
	InputStream fis;

	public ConfigReader() throws IOException {
		prop = new Properties();
		fis = getClass().getClassLoader().getResourceAsStream("config.properties");
		prop.load(fis);
		
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

	public String getUrl() {
		return prop.getProperty("url");
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("implicitWaitTimeOutDuration"));
	}

}
