package com.zg.po;

public class Chapter {
	private int id ;//主键
	private String bookid;//书id
	private int index;//章节序号
	private String location;//文件存放目录
	private float cost;//费用
	private String title;//标题
	public Chapter() {
		super();
	}
	public Chapter(int id, String bookid, int index, String location,
			float cost, String title) {
		super();
		this.id = id;
		this.bookid = bookid;
		this.index = index;
		this.location = location;
		this.cost = cost;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
