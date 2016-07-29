package com.zg.util;

import java.util.Calendar;
import java.util.Date;

public class DateAfter {
	public static Date getDateAfter(Date d,int day){  
		Calendar now =Calendar.getInstance();  
		now.setTime(d);  
		now.set(Calendar.DATE,now.get(Calendar.DATE)+day);  
		return now.getTime();  
	}  
}
