package com.zg.vo;

import java.util.Date;

public class BorrowBookInfo {
	private int bookid;
	private String author;
	private String name;
	private Date deadline;
	private long reTime;
	private int userid;
	public BorrowBookInfo(){
		super();
	}
	public BorrowBookInfo(String author,String name,Date deadline,int bookid,int userid){
		super();
		this.author = author;
		this.name = name;
		this.deadline = deadline;
		this.bookid = bookid;
		this.userid = userid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public long getReTime() {
		return reTime;
	}
	public void setReTime(long reTime) {
		this.reTime = reTime;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}	
	
}
