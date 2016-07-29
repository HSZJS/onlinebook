package com.zg.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Book {
	private int id;
	private String name;// ����
	private String author;//����
	private float price;//�۸�
	private int downloads;//������
	private int search;//������
	private int traffic;//�����
	private String pic;//���ͼƬ
	private String loaction;//���·��
	private int isread;//�Ƿ���� 0Ϊ���,1Ϊ�����
	private int isdel;//0Ϊδɾ��,1Ϊɾ��
	private Sort sort;
	private User user;//����˭����
	private Set users = new HashSet();//������Щ�˶��ĵ���
	
	private int isCheck;//�Ƿ�ɶ�   �ϴ����Ƿ���֤�ɹ� 0Ϊ���ɹ� 1Ϊ�ɹ�(����ϴ���ͼ��)
	private int size;//�ļ���С
	private Date offerTime;//�������� 
	private String press;//������
	public Book(){
		
	}
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getDownloads() {
		return downloads;
	}
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	public int getSearch() {
		return search;
	}
	public void setSearch(int search) {
		this.search = search;
	}
	public int getTraffic() {
		return traffic;
	}
	public void setTraffic(int traffic) {
		this.traffic = traffic;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getLoaction() {
		return loaction;
	}
	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}
	public int getIsread() {
		return isread;
	}
	public void setIsread(int isread) {
		this.isread = isread;
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
	}
	public Set getUsers() {
		return users;
	}
	public void setUsers(Set users) {
		this.users = users;
	}
	
	
	public int getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(int isCheck) {
		this.isCheck = isCheck;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Date getOfferTime() {
		return offerTime;
	}
	public void setOfferTime(Date offerTime) {
		this.offerTime = offerTime;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
