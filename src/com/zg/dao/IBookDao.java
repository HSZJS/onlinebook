package com.zg.dao;

import java.util.List;

import com.zg.po.Book;
import com.zg.po.Chapter;
import com.zg.po.User;
import com.zg.vo.BookInfo;

public interface IBookDao {
	/**
	 * 保存
	 * book 图书所有信息
	 * */
	public void saveBook(Book book);
	/**
	 * 修改
	 * book 要修改的图书的信息
	 * */
	public void updateBook(Book book);
	/**
	 * 删除
	 * id 图书id
	 * */
	public void deleteBook(int id);
	
	/**
	 * 查询
	 * return  获得所有图书
	 * */
	public List<Book> findAllBooks();
	/**
	 * 查询
	 * return 按点击量排序
	 * 
	 * */
	public List<BookInfo> findBooksByTraffic();
	/**
	 * 查询
	 * return 按下载量排序
	 * 
	 * */
	public List<BookInfo> findBooksByDownload();
	/**
	 * 查询
	 * return 按搜索量排序
	 * 
	 * */
	public List<BookInfo> findBooksBySearch();
	/**
	 * 查询
	 * return  获得指定一个图书
	 * */
	public BookInfo findBookById(int id);
	/**
	 * 查询
	 * id 子分类的id
	 * return  获得指定分类的图书
	 * */
	public List<Book> findBookBySort(int sortid, int firstResult ,int maxResults);
	/**
	 * 订阅量+1
	 * id book的id
	 * */
	public void updateDownload(int id);
	/**
	 * 点击量+1
	 * id book的+1
	 * */
	public void updateTraffic(int id);
	/**
	 * 搜索量+1
	 * id book的id
	 * */
	public void updateSearch(int id);
	/**
	 * 按书名搜索
	 * name 搜索书的名字
	 * return  所有书名含有  指定name的书
	 * */
	public List<Book> searchByBookName(String name,int firstResult ,int maxResults);
	
	/**
	 * 按作者搜索
	 * author 搜索书的作者
	 * return  此作者的所有书 及  所有作者名包含 指定autho的书
	 * */
	public List<Book> searchByBookAuthor(String author,int firstResult ,int maxResults);
	
	public String findEmail(int id);
	
	public List checkUploadBook(int firstResult ,int maxResults);
	public void checkBook(int id);
	
	public List findUploadBooks(int id , int firstResult ,int maxResults);

	/**
	 * 通过book  id 得到图书的名字 用于借阅模块
	 * id  bookid
	 * */
	public String findBookName(int id);
	/**通过book id  得到图书的路径
	 * id bookid
	 * 
	 * */
	public String findBookLoaction(int id);
	
	/**
	 * 查找免费图书
	 * */
	
	public List<Book> findFreeBooks(int firstResult ,int maxResults);
	
	/***
	 * 查找子分类下书的总个数
	 * */
	public int findSubSortBooks(int code );
	
	/**
	 * 查找未审核书的总个数
	 * **/
	public int findUncheckBooks();
	
	
	/***
	 * 查找用户上传图书的总个数
	 **/
	public int findUserUploadBooks(int userid);
	
	/***
	 * 查询书名字 获得总数据总数
	 **/
	public int findSearchByName(String name);
	
	/***
	 * 查询作者 获得总数据总数
	 **/
	public int findSearchByAuthor(String author);
	
	/***
	 * 查询免费图书总数据总数
	 **/
	public int findFreeBooksSize();
	
	public List<Chapter> getChapters(String bookid);
	
	public void saveChapter(Chapter c);
	
	public void editChapter(Chapter c);
	public Chapter getChaptersById(String id);
	public Chapter getChapter(String bookid,String index );
	public BookInfo findBookByName(String name);
	public Book findBookById2(int id);
	public User findUserByBookid(int id);
	public void checkBookBack(int id) ;
}
