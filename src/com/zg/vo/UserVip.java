package com.zg.vo;

public class UserVip {
	private int id;
	private String email;
	private String nickName;
	private String realName;
	private String idCard;
	private String qq;
	private String phoneNumber;
	private String sex;
	
	public UserVip(){
		
	}
	public UserVip(int id, String email,String nickName,String realName,String idCard,String qq,String phoneNumber,String sex){
		this.id = id;
		this.email = email;
		this.nickName = nickName;
		this.realName = realName;
		this.idCard = idCard;
		this.qq = qq;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
