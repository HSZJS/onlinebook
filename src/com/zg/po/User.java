package com.zg.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
	private int id;
	private String email;//email ��½�˺�
	private String password;//����
	
	private float balance;//���
	private String nickname;//�ǳ�
	private String pic;//ͷ��
	private int ispay;//�Ƿ�Ϊ�����û�  0Ϊδ���ѣ�1Ϊ�¸���,3Ϊ�긶��
	private int isdel;//0Ϊδɾ��,1Ϊɾ��
	private Set books = new HashSet();
	private Set<Book>  uploadBooks=new HashSet<Book>();
	
	private String realName;//��ʵ����
	private String idCard;//���֤
	private String phoneNumber;//�ֻ�����
	private String qq;//qq��
	private String sex;//�Ա�
	private String question;//����
	private String answer;//����
	public User(){
		
	}
	public User(int id){
		this.id = id;
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getIspay() {
		return ispay;
	}
	public void setIspay(int ispay) {
		this.ispay = ispay;
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



	public Set<Book> getUploadBooks() {
		return uploadBooks;
	}



	public void setUploadBooks(Set<Book> uploadBooks) {
		this.uploadBooks = uploadBooks;
	}
	
	
	

}
