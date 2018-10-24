package com.example.demo.common;

import java.util.Calendar;
import java.util.Date;

public class DateMaker {

	
   public static Date dateHelper(int year , int month , int day)
	{
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.set(year, month , day);
		date = cal.getTime();
		
		return date;
	}
}
