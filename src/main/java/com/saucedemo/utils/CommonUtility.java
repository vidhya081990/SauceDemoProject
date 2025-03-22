package com.saucedemo.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtility {

	DateFormat dateFormat;
	Date date;

	public String getDateFormat() {
		dateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s");
		date = new Date();
		return dateFormat.format(date);
	}
}
