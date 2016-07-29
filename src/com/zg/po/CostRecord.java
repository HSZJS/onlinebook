package com.zg.po;

public class CostRecord {
	private int id ;
	private float cost;
	private String userid;
	private String bookid;
	private String chapterid;
	private String bookName;
	private String chapterName;
	public CostRecord(int id, float cost, String userid, String bookid,
			String chapterid, String bookName, String chapterName) {
		super();
		this.id = id;
		this.cost = cost;
		this.userid = userid;
		this.bookid = bookid;
		this.chapterid = chapterid;
		this.bookName = bookName;
		this.chapterName = chapterName;
	}
	public CostRecord(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getChapterid() {
		return chapterid;
	}
	public void setChapterid(String chapterid) {
		this.chapterid = chapterid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	
}
