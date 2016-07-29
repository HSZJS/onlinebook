package com.zg.po;

import java.util.Date;

public class Message {
	private int id ;//主键
	private String userid ;//反馈意见发起人id
	private String bookid ;//反馈意见书籍id
	private String content ;//反馈内容
	private Date createtime ;//反馈时间
	
	private String userView;//反馈意见发起人姓名
	private String bookView;//反馈意见的书名
	public Message(){}
	public Message(int id, String userid, String bookid, String content,
			Date createtime, String userView, String bookView) {
		super();
		this.id = id;
		this.userid = userid;
		this.bookid = bookid;
		this.content = content;
		this.createtime = createtime;
		this.userView = userView;
		this.bookView = bookView;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getUserView() {
		return userView;
	}
	public void setUserView(String userView) {
		this.userView = userView;
	}
	public String getBookView() {
		return bookView;
	}
	public void setBookView(String bookView) {
		this.bookView = bookView;
	}
	
}
