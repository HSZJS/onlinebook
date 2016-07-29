package com.zg.service.sh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.zg.dao.IBookDao;
import com.zg.dao.ISortDao;
import com.zg.po.Book;
import com.zg.po.Chapter;
import com.zg.po.Sort;
import com.zg.po.User;
import com.zg.service.IBookService;
import com.zg.util.Page;
import com.zg.vo.BookInfo;

public class BookServiceImpl implements IBookService {
	
	private IBookDao bookDao;
	private ISortDao sortDao;

	public void setSortDao(ISortDao sortDao) {
		this.sortDao = sortDao;
	}

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.findAllBooks();
	}

	public BookInfo findBookById(int id) {
		// TODO Auto-generated method stub
		BookInfo bookInfo = bookDao.findBookById(id);		
		int code = bookInfo.getSortCode();
		Sort sort = sortDao.findParentSort(code);
		bookInfo.setSort(sort);
		return bookInfo;
	}
	public BookInfo findBookByName(String name) {
		// TODO Auto-generated method stub
		BookInfo bookInfo = bookDao.findBookByName(name);		
		int code = bookInfo.getSortCode();
		Sort sort = sortDao.findParentSort(code);
		bookInfo.setSort(sort);
		return bookInfo;
	}
	public Page findBookBySort(int id, int pn) {
		// TODO Auto-generated method stub
		int count = bookDao.findSubSortBooks(id);
		Page page = new Page(id,count,pn,10);
		List<Book> result = bookDao.findBookBySort(id, page.getFirstResult(), page.getMaxResults());
		page.setResult(result);
		return page;
	}

	public List<BookInfo> findBooksByDownload() {
		// TODO Auto-generated method stub
		List<BookInfo> bookInfos = bookDao.findBooksByDownload();
		for(BookInfo bookInfo:bookInfos){
			int code = bookInfo.getSortCode();
			Sort sort = sortDao.findParentSort(code);
			bookInfo.setSort(sort);
		}
		return bookInfos;
	}

	public List<BookInfo> findBooksBySearch() {
		// TODO Auto-generated method stub
		List<BookInfo> bookInfos = bookDao.findBooksBySearch();
		for(BookInfo bookInfo:bookInfos){
			int code = bookInfo.getSortCode();
			Sort sort = sortDao.findParentSort(code);
			bookInfo.setSort(sort);
		}
		return bookInfos;
	}

	public List<BookInfo> findBooksByTraffic() {
		// TODO Auto-generated method stub
		List<BookInfo> bookInfos = bookDao.findBooksByTraffic();
		for(BookInfo bookInfo:bookInfos){
			int code = bookInfo.getSortCode();
			Sort sort = sortDao.findParentSort(code);
			bookInfo.setSort(sort);
		}
		return bookInfos;
	}

	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.saveBook(book);
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.updateBook(book);
	}

	public void updateDownload(int id) {
		// TODO Auto-generated method stub
		bookDao.updateDownload(id);
	}

	public void updateSearch(int id) {
		// TODO Auto-generated method stub
		bookDao.updateSearch(id);
	}

	public void updateTraffic(int id) {
		// TODO Auto-generated method stub
		bookDao.updateTraffic(id);
	}

	public Page searchByBookAuthor(String author,int pn) {
		// TODO Auto-generated method stub
		int count = bookDao.findSearchByAuthor(author);
		Page page = new Page(1, count, pn, 10);
		List result = bookDao.searchByBookAuthor(author, page.getFirstResult(), page.getMaxResults());
		page.setResult(result);
		return page;
	}

	public Page searchByBookName(String name,int pn) {
		// TODO Auto-generated method stub
		int count = bookDao.findSearchByName(name);
		System.out.println("=====================name count=================="+count);
		Page page = new Page(1, count, pn, 10);
		List result = bookDao.searchByBookName(name, page.getFirstResult(), page.getMaxResults());
		page.setResult(result);
		return page;
	}

	public String findEmail(int id) {
		// TODO Auto-generated method stub
		
		return bookDao.findEmail(id);
	}

	public Page checkUploadBook(int id,int pn) {
		// TODO Auto-generated method stub
		int count = bookDao.findUncheckBooks();
		Page page = new Page(id,count,pn,10);
		List<Book> result = bookDao.checkUploadBook(page.getFirstResult(), page.getMaxResults());
		page.setResult(result);
		return page;
	}

	public void checkBook(int id) {
		// TODO Auto-generated method stub
		bookDao.checkBook(id);
	}

	public Page findUploadBooks(int id ,int pn) {
		// TODO Auto-generated method stub
		int count = bookDao.findUserUploadBooks(id);
		Page page = new Page(id, count, pn, 10);
		List result = bookDao.findUploadBooks(id, page.getFirstResult(), page.getMaxResults());
		page.setResult(result);
		return page;
	}

	public String findBookName(int id) {
		// TODO Auto-generated method stub
		return bookDao.findBookName(id);
	}

	public List findBook(int id) {
		// TODO Auto-generated method stub
		String loaction = bookDao.findBookLoaction(id);
		ServletContext servletContext = ServletActionContext.getServletContext();
		String rootPath = servletContext.getRealPath("/uploadBooks");
		int i = loaction.indexOf("\\");
		String realPath = rootPath+"\\"+loaction.substring(i+1);
		List<String> list = new ArrayList<String>();
		File file = new File(realPath);
	       BufferedReader reader = null;
	       try {
	           reader = new BufferedReader(new FileReader(file));
	           String tempString = null;
	           int line = 1;
	           // 一次读入一行，直到读入null为文件结束
	           while ((tempString = reader.readLine()) != null && line < 10) {
	               // 显示行号
	               //System.out.println("line " + line + ": " + tempString);
	        	   list.add(tempString);
	               line++;
	           }
	           reader.close();
	        }catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	           if(reader != null) {
	               try {
	                   reader.close();
	                } catch (IOException e1) {
	              }
	            }
	        }
	       return list;
	}
	public List findChapter(String chapterId) {
		// TODO Auto-generated method stub
		
		Chapter chapter = bookDao.getChaptersById(chapterId);
		
		
		String loaction = chapter.getLocation();
		ServletContext servletContext = ServletActionContext.getServletContext();
		String rootPath = servletContext.getRealPath("/uploadBooks");
		int i = loaction.indexOf("\\");
		String realPath = rootPath+"\\"+loaction.substring(i+1);
		List<String> list = new ArrayList<String>();
		File file = new File(realPath);
	       BufferedReader reader = null;
	       try {
	           reader = new BufferedReader(new FileReader(file));
	           String tempString = null;
	           int line = 1;
	           // 一次读入一行，直到读入null为文件结束
	           while ((tempString = reader.readLine()) != null) {
	               // 显示行号
	               //System.out.println("line " + line + ": " + tempString);
	        	   list.add(tempString);
	               line++;
	           }
	           reader.close();
	        }catch (IOException e) {
	            e.printStackTrace();
	        }finally {
	           if(reader != null) {
	               try {
	                   reader.close();
	                } catch (IOException e1) {
	              }
	            }
	        }
	       return list;
	}
	public Page findFreeBooks(int pn) {
		// TODO Auto-generated method stub
		int count = bookDao.findFreeBooksSize();
		Page page = new Page(1, count, pn, 10);
		List result = bookDao.findFreeBooks(page.getFirstResult(), page.getMaxResults());
		page.setResult(result);
		return page;
	}
	public Chapter getChapter(String bookid,String index ){
		return bookDao.getChapter(bookid, index);
	}
	public List<Chapter> getChapters(String bookid) {
		return bookDao.getChapters(bookid);
	}

	public void saveChapter(Chapter c) {
		bookDao.saveChapter(c);
	}

	public void editChapter(Chapter c) {
		bookDao.editChapter(c);
	}
	public Chapter getChaptersById(String id){
		return bookDao.getChaptersById(id);
	}
	public Book findBookById2(int id){
		return bookDao.findBookById2(id);
	}
	public User findUserByBookid(int id){
		return bookDao.findUserByBookid(id);
	}
	public void checkBookBack(int id){
		bookDao.checkBookBack(id);
	}
}
