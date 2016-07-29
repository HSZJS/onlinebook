package com.zg.vo;

import java.util.Date;

public class RecordInfo {
	private String bookName;
	private String email;
	private Date startTime;
	private float money;
	
	public RecordInfo(){}
	public RecordInfo(String bookName,String email,Date startTime,float money){
		this.bookName = bookName;
		this.email = email;
		this.startTime = startTime;
		this.money = money;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	
	

}
