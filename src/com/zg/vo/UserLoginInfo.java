package com.zg.vo;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zg.po.Book;

public class UserLoginInfo {
	private int id;
	private String email;//email ��½�˺�
	private String password;//����
	
	
	
	private float balance;//���
	private String nickname;//�ǳ�
	private File photo;//ͷ��
	private String photoFileName;

	private int ispay;//�Ƿ�Ϊ�����û�  0Ϊδ���ѣ�1Ϊ�¸���,3Ϊ�긶��
	private int isdel;//0Ϊδɾ��,1Ϊɾ��
	private Set books = new HashSet();
	
	private String realName;//��ʵ����
	private String idCard;//���֤
	private String phoneNumber;//�ֻ�����
	private String qq;//qq��
	private String sex;//�Ա�
	private String question ;//����
	private String answer;//����
	
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
