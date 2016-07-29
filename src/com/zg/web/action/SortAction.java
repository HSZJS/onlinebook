package com.zg.web.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.Action;
import com.zg.po.Book;
import com.zg.service.IBookService;
import com.zg.service.ISortService;
import com.zg.util.Page;
import com.zg.vo.BookInfo;
import com.zg.vo.SortTree;

public class SortAction extends BaseAction {
	private ISortService sortService;
	private IBookService bookService;
	

	private List<SortTree> sorts;
	private List<Book> books;
	private List<BookInfo> booksByDownload;
	private List<BookInfo> booksByTraffic;
	private List<BookInfo> booksBySearch;

	private String code;//传进来的是最底层分类的code值	 如：东方玄幻 101010
	private int subSort;//传进来 0,1,2,3,4   对应的是  玄幻	 武侠	 都市	 军事	 青春，用来得到其下面的子分类
	private Page page;
	private int pn;

	
	//三个排行榜获取的书
	public String list(){
		booksByDownload = bookService.findBooksByDownload();
		booksByTraffic = bookService.findBooksByTraffic();
		booksBySearch = bookService.findBooksBySearch();
		return Action.SUCCESS;
	}
	//默认的菜单
	public String findSortsDefault(){
		sorts = sortService.findSorts();
		page = bookService.findBookBySort(101010,1);
		HttpSession session = this.getRequest().getSession();
		session.setAttribute("code", 101011);
		list();
		return Action.SUCCESS;
	}
	//查询子菜单
	public String findSubSort(){
		sorts = sortService.findSorts();
		page = bookService.findBookBySort(Integer.parseInt(code)+10,1);
		HttpSession session=this.getRequest().getSession(false);
		session.removeAttribute("code");
		session.setAttribute("code", code);
		return Action.SUCCESS;
	}
	//通过子菜单查询其下所有的图书
	public String findBooksBySubSort(){
		sorts = sortService.findSorts();
		page = bookService.findBookBySort(Integer.parseInt(code),pn);
		HttpSession session=this.getRequest().getSession(false);
		session.removeAttribute("code");
		session.setAttribute("code", code);
		return Action.SUCCESS;
	}
	
	
	
	
	
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	public void setSortService(ISortService sortService) {
		this.sortService = sortService;
	}
	public List<SortTree> getSorts() {
		return sorts;
	}

	public void setSorts(List<SortTree> sorts) {
		this.sorts = sorts;
	}

	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public int getSubSort() {
		return subSort;
	}

	public void setSubSort(int subSort) {
		this.subSort = subSort;
	}
	public List<BookInfo> getBooksByDownload() {
		return booksByDownload;
	}

	public void setBooksByDownload(List<BookInfo> booksByDownload) {
		this.booksByDownload = booksByDownload;
	}

	public List<BookInfo> getBooksByTraffic() {
		return booksByTraffic;
	}

	public void setBooksByTraffic(List<BookInfo> booksByTraffic) {
		this.booksByTraffic = booksByTraffic;
	}

	public List<BookInfo> getBooksBySearch() {
		return booksBySearch;
	}

	public void setBooksBySearch(List<BookInfo> booksBySearch) {
		this.booksBySearch = booksBySearch;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}
	
	
	

}
