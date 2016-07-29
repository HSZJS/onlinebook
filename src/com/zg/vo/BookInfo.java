package com.zg.vo;


import java.util.Date;

import com.zg.po.Sort;

public class BookInfo {
	private int id;
	private String name;// ����
	private String author;//����
	private float price;//����
	private int downloads;//������
	private int search;//������
	private int traffic;//������
	private int isread;//��������������
	private String pic;//��������
	private int sortCode;
	private String sortName;
	private int size;//��������
	private Date offerTime;//��������
	private String press;//������
	private Sort sort;
	public BookInfo()
	{
		super();
	}
	public BookInfo(int id,String name,int isread ,String author,float price,int downloads,int search,int traffic,
				String pic,int sortCode,String sortName,int size,Date offerTime,String press){
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.downloads = downloads;
		this.search = search;
		this.traffic = traffic;
		this.pic = pic;
		this.sortCode = sortCode;
		this.sortName = sortName;
		this.size = size;
		this.offerTime = offerTime;
		this.press = press;
		this.isread = isread;
		
	}
	public BookInfo(int id,String name,int sortCode,String sortName){
		super();
		this.id = id;
		this.name = name;
		this.sortCode = sortCode;
		this.sortName = sortName;
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
	public int getSortCode() {
		return sortCode;
	}
	public void setSortCode(int sortCode) {
		this.sortCode = sortCode;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
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
	public int getIsread() {
		return isread;
	}
	public void setIsread(int isread) {
		this.isread = isread;
	}
	
	
	
}
