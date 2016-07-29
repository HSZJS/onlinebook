package com.zg.dao;

import java.util.List;

import com.zg.po.Book;
import com.zg.po.Chapter;
import com.zg.po.User;
import com.zg.vo.BookInfo;

public interface IBookDao {
	/**
	 * ����
	 * book ͼ��������Ϣ
	 * */
	public void saveBook(Book book);
	/**
	 * �޸�
	 * book Ҫ�޸ĵ�ͼ�����Ϣ
	 * */
	public void updateBook(Book book);
	/**
	 * ɾ��
	 * id ͼ��id
	 * */
	public void deleteBook(int id);
	
	/**
	 * ��ѯ
	 * return  �������ͼ��
	 * */
	public List<Book> findAllBooks();
	/**
	 * ��ѯ
	 * return �����������
	 * 
	 * */
	public List<BookInfo> findBooksByTraffic();
	/**
	 * ��ѯ
	 * return ������������
	 * 
	 * */
	public List<BookInfo> findBooksByDownload();
	/**
	 * ��ѯ
	 * return ������������
	 * 
	 * */
	public List<BookInfo> findBooksBySearch();
	/**
	 * ��ѯ
	 * return  ���ָ��һ��ͼ��
	 * */
	public BookInfo findBookById(int id);
	/**
	 * ��ѯ
	 * id �ӷ����id
	 * return  ���ָ�������ͼ��
	 * */
	public List<Book> findBookBySort(int sortid, int firstResult ,int maxResults);
	/**
	 * ������+1
	 * id book��id
	 * */
	public void updateDownload(int id);
	/**
	 * �����+1
	 * id book��+1
	 * */
	public void updateTraffic(int id);
	/**
	 * ������+1
	 * id book��id
	 * */
	public void updateSearch(int id);
	/**
	 * ����������
	 * name �����������
	 * return  ������������  ָ��name����
	 * */
	public List<Book> searchByBookName(String name,int firstResult ,int maxResults);
	
	/**
	 * ����������
	 * author �����������
	 * return  �����ߵ������� ��  �������������� ָ��autho����
	 * */
	public List<Book> searchByBookAuthor(String author,int firstResult ,int maxResults);
	
	public String findEmail(int id);
	
	public List checkUploadBook(int firstResult ,int maxResults);
	public void checkBook(int id);
	
	public List findUploadBooks(int id , int firstResult ,int maxResults);

	/**
	 * ͨ��book  id �õ�ͼ������� ���ڽ���ģ��
	 * id  bookid
	 * */
	public String findBookName(int id);
	/**ͨ��book id  �õ�ͼ���·��
	 * id bookid
	 * 
	 * */
	public String findBookLoaction(int id);
	
	/**
	 * �������ͼ��
	 * */
	
	public List<Book> findFreeBooks(int firstResult ,int maxResults);
	
	/***
	 * �����ӷ���������ܸ���
	 * */
	public int findSubSortBooks(int code );
	
	/**
	 * ����δ�������ܸ���
	 * **/
	public int findUncheckBooks();
	
	
	/***
	 * �����û��ϴ�ͼ����ܸ���
	 **/
	public int findUserUploadBooks(int userid);
	
	/***
	 * ��ѯ������ �������������
	 **/
	public int findSearchByName(String name);
	
	/***
	 * ��ѯ���� �������������
	 **/
	public int findSearchByAuthor(String author);
	
	/***
	 * ��ѯ���ͼ������������
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
