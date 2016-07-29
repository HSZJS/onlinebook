package com.zg.dao;

import java.util.List;

import com.zg.po.Borrowbook;
import com.zg.vo.BorrowBookInfo;

public interface IBorrowBookDao {
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
	public List findBooks(int userid,int firstResult,int maxResults);
	/**
	 * 修改  到期的图书将不可以读  失效
	 * userid 用户id
	 * bookid 图书id
	 * */
	public void update(int userid,int bookid);
	/**
	 * 通过用户id  得到其下所有能够阅读的图书(用来判断借阅，借阅过的书没有到期的 不用再借阅)
	 * userid  用户id
	 * */
	public List findUserBookID(int userid);
	
	/**
	 * 查找用户借阅图书的总个数
	 * **/
	public int findUserBorrowBooks(int userid);
	
}
