package com.zg.service;

import java.io.File;
import java.util.List;

import com.zg.po.Book;
import com.zg.po.Chapter;
import com.zg.po.User;
import com.zg.util.Page;
import com.zg.vo.BookInfo;

public interface IBookService 
{
	public void saveBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(int id);
	public List<Book> findAllBooks();
	public List<BookInfo> findBooksByTraffic();
	public List<BookInfo> findBooksByDownload();
	public List<BookInfo> findBooksBySearch();
	public BookInfo findBookById(int id);
	public List findChapter(String chapterId) ;
	public Page findBookBySort(int id, int pn);
	//public xxx getContent(String loaction);
	public void updateDownload(int id);
	public void updateTraffic(int id);
	public void updateSearch(int id);
	public Page searchByBookName(String name,int pn);
	public Page searchByBookAuthor(String author,int pn);
	public String findEmail(int id);
	public Page checkUploadBook(int id,int pn);
	public void checkBook(int id);
	public Page findUploadBooks(int id,int pn);
	
	public String findBookName(int id);
	public List findBook(int id);
	
	public Page findFreeBooks(int pn);
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
