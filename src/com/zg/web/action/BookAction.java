package com.zg.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.zg.po.Book;
import com.zg.po.Borrowbook;
import com.zg.po.Chapter;
import com.zg.po.Record;
import com.zg.po.Sort;
import com.zg.po.User;
import com.zg.service.IBookService;
import com.zg.service.IBorrowBookService;
import com.zg.service.IRecordService;
import com.zg.service.IUserService;
import com.zg.util.DateAfter;
import com.zg.util.Page;
import com.zg.util.WebUtil;
import com.zg.vo.BookInfo;
import com.zg.vo.BorrowBookInfo;

public class BookAction extends BaseAction{
	
	private List list ;
	private IBookService bookService;
	private IBorrowBookService borrowBookService;
	private IRecordService recordService;
	private IUserService userService;
	private BookInfo bookInfo;
	private int id;//������������id
	private String requirement;//��������
	private String search;//����������  ���� ������  ��������
	private int userid;//��������id
	private int bookid;//����������id
	private float money;//������������
	private String userEmail;//����������email ��������
	private int isread;//�������������� ������������
	private List<BorrowBookInfo> borrowBooks;
	private List<Chapter> chapters;//��������
	
	private String bookName;
	private String author;
	private float price;
	private File picFile;
	private File bookFile;
	private int sortid;
	private String press;
	private Date offerTime;
	
	private List checkUploadBooks;//���������� ����������
	private List uploadBooks;// ��������������������
	
	private List<Book> freeBooks;//��������������
	
	private Page page;
	private int pn = 1;
	
	private String index;
	private String title;
	private Chapter chapter;
	

	
	
	public String findBookById() throws Exception{
		bookInfo = bookService.findBookById(id);
		bookService.updateTraffic(id);
		return Action.SUCCESS;
	}
	public String readBook() throws Exception{
		String name = this.getRequest().getParameter("name");
		bookInfo = bookService.findBookByName(name);
		bookService.updateTraffic(id);
		return Action.SUCCESS;
	}

	public String search() throws UnsupportedEncodingException{
		HttpSession session=this.getRequest().getSession(false);
		session.removeAttribute("bookName");
		session.removeAttribute("bookAuthor");
		if(requirement.equals("bookName")){
			
			page = bookService.searchByBookName(search,pn);
			System.out.println("========================bookName========================"+search);
			session.setAttribute("requirement", "bookName");
			session.setAttribute("search", search);
		}
		if(requirement.equals("bookAuthor")){
			
			page = bookService.searchByBookAuthor(search, pn);
			session.setAttribute("requirement","author");
			session.setAttribute("search", search);
		}
		
		return Action.SUCCESS;
	}
	//������������
	public String borrow() throws IOException{
		//��borrow����
		getRequest().setCharacterEncoding("UTF-8");
		getResponse().setContentType("text/html;charset=UTF-8");
		PrintWriter out = getResponse().getWriter();
		HttpSession session = this.getRequest().getSession();
		if(session.getAttribute("user") != null){
			float balance = userService.findBalance(userid);
			
				List userBookIdList = borrowBookService.findUserBookID(userid);
				boolean flag = false;
				for(int i = 0 ;i<userBookIdList.size();i++){
					if((Integer)userBookIdList.get(i) == bookid){
						flag = true;//����������������������������������������
					}
				}
				if(flag == true){
					out.println("<b style='color:green'>��������������</b>");
				}
				if(flag == false){
					Borrowbook borrowbook = new Borrowbook();
					borrowbook.setBookid(bookid);
					borrowbook.setUserid(userid);
					borrowbook.setIsdel(0);
					borrowbook.setIsread(0);
					Date deadline = DateAfter.getDateAfter(new Date(), 14);
					borrowbook.setDeadline(deadline);
					borrowBookService.save(borrowbook);
					//��record��������
					Record record = new Record();
					record.setEmail(userEmail);
					record.setDeadline(deadline);
					record.setMoney(money);
					record.setStarttime(new Date());
					record.setBookName(bookService.findBookName(bookid));
					recordService.saveRecord(record);
					if(isread == 0){
						//����(1)������������������������������
						userService.zhuanzhang(userEmail, "admin", money);
						//����(2)������������������������������
						String bookEmail = bookService.findEmail(bookid);
						userService.zhuanzhang("admin", bookEmail, (float)(money*0.7));
					}
					out.println("<b style='color:green'>������������</b>");
				}
				
		}
		return null;
	}
	//��������������������
	public String borrowBook(){
		page = borrowBookService.findBooks(userid, pn);
		return Action.SUCCESS;
	}
	//������������
	public String uploadBook() throws IOException{
		String rename_pic = null;
		System.out.println(author+bookName+price+userid+sortid);
		Book book = new Book();
		book.setAuthor(author);
		book.setName(bookName);
		book.setPrice(price);
		book.setDownloads(0);
		book.setIsCheck(0);
		book.setIsdel(0);
		book.setIsread(0);
		book.setSearch(0);
		book.setTraffic(0);
		book.setUser(new User(userid));
		book.setSort(new Sort(sortid));
		book.setSize((int)bookFile.length());
		
		//��������
		String rootPath_book = this.getServletContext().getRealPath("/uploadBooks");
		File rootDir_book = new File(rootPath_book);
		if (!rootDir_book.exists()) {
			rootDir_book.mkdirs();
		}
		String bookFile_name = bookFile.getName().replaceAll(".tmp", ".txt");
		String rename_book1 = UUID.randomUUID().toString().replace("-", "")
				+ bookFile_name.substring(bookFile_name.lastIndexOf("."));
		String rename_book2 = "uploadBooks\\"+rename_book1;
		File uploadFile_book=new File(rootDir_book,rename_book1);
		FileUtils.copyFile(bookFile, uploadFile_book);
		book.setLoaction(rename_book2);
		//������������
		if(picFile != null){
			// 1.����bookpics������
			String rootPath = this.getServletContext().getRealPath("/bookpics");
			
			File rootDir = new File(rootPath);
			if (!rootDir.exists()) {
				rootDir.mkdirs();
			}
			// 2.����������������������
			String picFile_name = picFile.getName().replaceAll(".tmp", ".jpg");
			String rename = UUID.randomUUID().toString().replace("-", "")
					+ picFile_name.substring(picFile_name.lastIndexOf("."));
			rename_pic = "bookpics\\"+rename;
			File uploadFile=new File(rootDir,rename);
			FileUtils.copyFile(picFile, uploadFile);
			book.setPic(rename_pic);
		}
		if(press != null){
			book.setPress(press);
		}
		if(offerTime != null){
			book.setOfferTime(offerTime);
		}else{
			book.setOfferTime(new Date());
		}
		bookService.saveBook(book);
		return Action.SUCCESS;
	}
	public String readChapter(){
		
		chapters = bookService.getChapters(bookid+"");
		bookInfo = bookService.findBookById(bookid);
		this.getRequest().setAttribute("chapters", chapters);
		return "readChapterBook";
	}
	//������������
	public String readChapterById(){
		String chapterid = this.getRequest().getParameter("chapterid");
		Chapter test = bookService.getChaptersById(chapterid);
		bookid = Integer.parseInt(test.getBookid());
		String message = "";
		boolean flag = false;
		//��������������������
		if(test.getCost()!=0){
			User user = (User)this.getRequest().getSession().getAttribute("user");
			if(user==null){
				message = "����������������������������";
				flag = true;
			}else{
				if(user.getBalance()<test.getCost()){
					message = "������������������������������";
					flag = true;
				}else{
					
					//������������
					boolean f = userService.isCost(user.getId()+"", chapterid);
					
					//��������
					user.setBalance(user.getBalance()-test.getCost());
					if(!f){
						userService.changeBanlan(user);
					}
					//����������
					Book bi = bookService.findBookById2(bookid);
					User author = bookService.findUserByBookid(bi.getId());
					author.setBalance((float) (author.getBalance()+test.getCost()*0.6));
					if(!f){
					userService.changeBanlan(author);
					}
					//������������
					User admin = userService.findUserByEmail("admin");
					admin.setBalance((float) (admin.getBalance()+test.getCost()*0.4));
					if(!f){
					userService.changeBanlan(admin);
					}
					if(test.getCost()!=0&&!f){
						//����
						userService.saveRecord(user.getId()+"", -test.getCost(), bookid+"", chapterid);
					}
				}
			}
		}
		list = bookService.findChapter(chapterid);
		if(flag){
			this.getRequest().setAttribute("message", message);
			return "readError";
		}
		//������������
		this.getRequest().setAttribute("chapter",test);
		//��������������
		int index = test.getIndex();
		int indexMax = bookService.getChapters(test.getBookid()).size();
		int indexBefore = 1;
		int indexAftre = 1;
		if(index<=1){
			indexBefore = 1;
			if(indexMax == 1 ){
				indexAftre = 1;
			}else{
				indexAftre = 2;
			}
		}else if(index>=indexMax){
			indexBefore = index - 1;
			indexAftre = indexMax;
		}else{
			indexBefore = index - 1;
			indexAftre = index + 1;
		}
		Chapter before = bookService.getChapter(test.getBookid(), indexBefore+"");
		Chapter after = bookService.getChapter(test.getBookid(), indexAftre+"");
		this.getRequest().setAttribute("chapter", test);
		this.getRequest().setAttribute("indexBefore", before.getId()+"");
		this.getRequest().setAttribute("indexAfter", after.getId()+"");
		
		return "readChapterById";
	}
	public String saveChapter(){
		
		String rootPath = this.getServletContext().getRealPath("/uploadBooks");
		
		String location = "uploadBooks\\"+bookName+"\\"+index+".txt";
		
		File file = new File(rootPath+"/"+bookName,index+".txt");
		try {
			FileUtils.copyFile(bookFile, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Chapter c = new Chapter();
		c.setBookid(id+"");
		c.setCost(price);
		c.setIndex(Integer.parseInt(index));
		c.setTitle(title);
		c.setLocation(location);
		bookService.saveChapter(c);
		
		User user = (User)this.getRequest().getSession().getAttribute("user");
		page = bookService.findUploadBooks(user.getId(),pn);
		return "saveChapter";
	}
public String editChapter(){
		
		String rootPath = this.getServletContext().getRealPath("/uploadBooks");
		
		String location = "uploadBooks\\"+bookName+"\\"+index+".txt";
		
		File file = new File(rootPath+"/"+bookName,index+".txt");
		file.delete();
		file.mkdir();
		if(!file.exists()){
			file.mkdir();
		}
		try {
			FileUtils.copyFile(bookFile, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Chapter c = new Chapter();
		c.setId(id);
		c.setBookid(bookid+"");
		c.setCost(price);
		c.setIndex(Integer.parseInt(index));
		c.setTitle(title);
		c.setLocation(location);
		bookService.editChapter(c);
		
		User user = (User)this.getRequest().getSession().getAttribute("user");
		page = bookService.findUploadBooks(user.getId(),pn);
		return "saveChapter";
	}
	//������������������������
	public String checkUploadBook(){
		page = bookService.checkUploadBook(1, pn);
		return Action.SUCCESS;
	}
	//������������������  ---��������
	public String checkBook() throws IOException{
		bookService.checkBook(bookid);
		WebUtil.alert(getRequest(), getResponse(), "success", null, false);
		return null;
	}
	//������������������  ---��������
	public String checkBookBack() throws IOException{
		bookService.checkBookBack(bookid);
		WebUtil.alert(getRequest(), getResponse(), "success", null, false);
		return null;
	}
	public String download(){
		String id = this.getRequest().getParameter("id");
		Chapter c = bookService.getChaptersById(id);
		String location = c.getLocation();
		String rootPath = this.getServletContext().getRealPath("/");
		File file = new File(rootPath+"\\"+location);
		OutputStream ous = null;
		
		String filename = c.getIndex()+".txt";
		try{
		   InputStream ins = new BufferedInputStream(new FileInputStream(rootPath+"\\"+location));
		   byte [] buffer = new byte[ins.available()];
		   ins.read(buffer);
		   ins.close();
		   
		   HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		   response.reset();
		   response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
		   response.addHeader("Content-Length", "" + file.length());
		   ous = new BufferedOutputStream(response.getOutputStream());
		   response.setContentType("application/octet-stream");
		   ous.write(buffer);
		   ous.flush();
		   ous.close();
		}catch(Exception e ){
			e.printStackTrace();
		}
		   
		return null;
	}
	public String manageChapter(){
		String bookid = this.getRequest().getParameter("bookid");
		list = (List<Chapter>)bookService.getChapters(bookid);
		bookName = bookService.findBookName(Integer.parseInt(bookid));
		id = Integer.parseInt(bookid);
		if(list!=null&&list.size()>0){
			index = list.size()+1+"";
		}else{
			index = "1";
		}
		
		return "manageChapter";
	}
	//����������������������������������
	public String findUploadBook(){
		page = bookService.findUploadBooks(userid,pn);
		return Action.SUCCESS;
	}
	//����������������  ---������������������
	public String changeBorrowBook() throws IOException{
		borrowBookService.update(userid, bookid);
		WebUtil.alert(getRequest(), getResponse(), "one book invalid", null, false);
		return null;
	}
	//��������������
	public String read(){
		list = bookService.findBook(bookid);
		return Action.SUCCESS;
	}
	//��������������
	public String free(){
		page = bookService.findFreeBooks(pn);
		return Action.SUCCESS;
	}
	public String toUpdateBook(){
		bookInfo = bookService.findBookById(bookid);
		return Action.SUCCESS;
	}
	//��������
	public String updateBook() throws IOException{
		String rename_pic = null;
		Book book = new Book();
		book.setAuthor(author);
		book.setName(bookName);
		book.setPrice(price);
		book.setOfferTime(offerTime);
		book.setPress(press);
		book.setId(bookid);
		//������������
		if(picFile != null){
			// 1.����bookpics������
			String rootPath = this.getServletContext().getRealPath("/bookpics");
			
			File rootDir = new File(rootPath);
			if (!rootDir.exists()) {
				rootDir.mkdirs();
			}
			// 2.����������������������
			String picFile_name = picFile.getName().replaceAll(".tmp", ".jpg");
			String rename = UUID.randomUUID().toString().replace("-", "")
					+ picFile_name.substring(picFile_name.lastIndexOf("."));
			rename_pic = "bookpics\\"+rename;
			File uploadFile=new File(rootDir,rename);
			FileUtils.copyFile(picFile, uploadFile);
			book.setPic(rename_pic);
		}
		bookService.updateBook(book);
		return Action.SUCCESS;
	}
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	

	public void setBorrowBookService(IBorrowBookService borrowBookService) {
		this.borrowBookService = borrowBookService;
	}
	
	public void setRecordService(IRecordService recordService) {
		this.recordService = recordService;
	}

	public IBookService getBookService() {
		return bookService;
	}
	public BookInfo getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public List<BorrowBookInfo> getBorrowBooks() {
		return borrowBooks;
	}

	public void setBorrowBooks(List<BorrowBookInfo> borrowBooks) {
		this.borrowBooks = borrowBooks;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
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

	
	public File getPicFile() {
		return picFile;
	}

	public void setPicFile(File picFile) {
		this.picFile = picFile;
	}

	public File getBookFile() {
		return bookFile;
	}

	public void setBookFile(File bookFile) {
		this.bookFile = bookFile;
	}

	public int getSortid() {
		return sortid;
	}

	public void setSortid(int sortid) {
		this.sortid = sortid;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Date getOfferTime() {
		return offerTime;
	}

	public void setOfferTime(Date offerTime) {
		this.offerTime = offerTime;
	}

	public List getCheckUploadBooks() {
		return checkUploadBooks;
	}

	public void setCheckUploadBooks(List checkUploadBooks) {
		this.checkUploadBooks = checkUploadBooks;
	}

	public List getUploadBooks() {
		return uploadBooks;
	}

	public void setUploadBooks(List uploadBooks) {
		this.uploadBooks = uploadBooks;
	}
	public List<Book> getFreeBooks() {
		return freeBooks;
	}
	public void setFreeBooks(List<Book> freeBooks) {
		this.freeBooks = freeBooks;
	}
	public int getIsread() {
		return isread;
	}
	public void setIsread(int isread) {
		this.isread = isread;
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
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	
}
