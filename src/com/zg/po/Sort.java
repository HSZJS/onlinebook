package com.zg.po;

import java.util.HashSet;
import java.util.Set;

public class Sort {
	private int id;//主键
	private int code;//编码
	private int level;//级别
	private String name;//显示名字
	private Set<Book>  books=new HashSet<Book>();
	
	
	public Sort(){
		
	}
	public Sort(int code){
		this.code = code;
	}
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
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
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
