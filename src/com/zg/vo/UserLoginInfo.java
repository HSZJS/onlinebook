package com.zg.vo;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zg.po.Book;

public class UserLoginInfo {
	private int id;
	private String email;//email 登陆账号
	private String password;//密码
	
	
	
	private float balance;//余额
	private String nickname;//昵称
	private File photo;//头像
	private String photoFileName;

	private int ispay;//是否为付费用户  0为未付费，1为月付费,3为年付费
	private int isdel;//0为未删除,1为删除
	private Set books = new HashSet();
	
	private String realName;//真实姓名
	private String idCard;//身份证
	private String phoneNumber;//手机号码
	private String qq;//qq号
	private String sex;//性别
	private String question ;//问题
	private String answer;//密码
	
	private List<Book> borrowBooks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public int getIspay() {
		return ispay;
	}

	public void setIspay(int ispay) {
		this.ispay = ispay;
	}

	public int getIsdel() {
		return isdel;
	}

	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}

	public Set getBooks() {
		return books;
	}

	public void setBooks(Set books) {
		this.books = books;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Book> getBorrowBooks() {
		return borrowBooks;
	}

	public void setBorrowBooks(List<Book> borrowBooks) {
		this.borrowBooks = borrowBooks;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public UserLoginInfo(int id, String email, String password, float balance,
			String nickname, File photo, String photoFileName, int ispay,
			int isdel, Set books, String realName, String idCard,
			String phoneNumber, String qq, String sex, String question,
			String answer, List<Book> borrowBooks) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.balance = balance;
		this.nickname = nickname;
		this.photo = photo;
		this.photoFileName = photoFileName;
		this.ispay = ispay;
		this.isdel = isdel;
		this.books = books;
		this.realName = realName;
		this.idCard = idCard;
		this.phoneNumber = phoneNumber;
		this.qq = qq;
		this.sex = sex;
		this.question = question;
		this.answer = answer;
		this.borrowBooks = borrowBooks;
	}

	public UserLoginInfo() {
	}

}
