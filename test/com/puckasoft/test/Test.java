package com.puckasoft.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.zg.dao.sh.BookShDao;
import com.zg.po.Book;
import com.zg.util.Interval;
import com.zg.web.action.BookAction;

public class Test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
//		Date date = new Date();
//		Interval interval = new Interval();
//		String time = interval.getTwoDay(date, getDateAfter(date, 2));
//		//time.replaceAll("-", "");
//		System.out.println(time.charAt(0));
//		String ss = time.replace('-', ' ');
//		System.out.println(ss);
		/////
//		String str = "0天 0时 0分 0秒";
//		String[] strs = str.split(" ");
//		String ss = "";
//		for(int i = 0 ; i<strs.length;i++){
//			ss = ss+strs[i].substring(0, strs[i].length()-1);
//		}
//		System.out.println(ss);
//		String str = "uploadBooks\\驯神.txt";
//		int i = str.indexOf("\\");
//		System.out.println(str.substring(i+1));
		long a = 101;
		

	}
	public  static Date getDateAfter(Date d,int day){  
		   Calendar now =Calendar.getInstance();  
		   now.setTime(d);  
		   now.set(Calendar.DATE,now.get(Calendar.DATE)+day);  
		   return now.getTime();  
	}  

}
