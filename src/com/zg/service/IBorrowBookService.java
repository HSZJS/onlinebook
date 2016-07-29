package com.zg.service;

import java.util.List;

import com.zg.po.Borrowbook;
import com.zg.util.Page;
import com.zg.vo.BorrowBookInfo;

public interface IBorrowBookService {
	/**
	 * 添加
	 * userid 用户id
	 * bookid 图书id
	 * */
	public void save(Borrowbook borrowBook);
	/**
	 * 获得用户订阅的图书
	 * id  用户id
	 * return 对应用户订阅的所有图书id
	 * */
	public Page findBooks(int userid,int pn);
	/**
	 * 修改  到期的图书将不可以读  失效
	 * userid 用户id
	 * bookid 图书id
	 * */
	public void update(int userid,int bookid);
	
	public List findUserBookID(int userid);
}
