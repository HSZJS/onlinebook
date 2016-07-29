package com.zg.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Book {
	private int id;
	private String name;// 书名
	private String author;//作者
	private float price;//价格
	private int downloads;//下载量
	private int search;//搜索量
	private int traffic;//点击量
	private String pic;//书的图片
	private String loaction;//书的路径
	private int isread;//是否免费 0为免费,1为不免费
	private int isdel;//0为未删除,1为删除
	private Sort sort;
	private User user;//属于谁的书
	private Set users = new HashSet();//属于那些人订阅的书
	
	private int isCheck;//是否可读   上传的是否认证成功 0为不成功 1为成功(审核上传的图书)
	private int size;//文件大小
	private Date offerTime;//发售日期 
	private String press;//出版社
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
