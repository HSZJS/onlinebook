package com.zg.dao.sh;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;




import com.zg.dao.IBookDao;
import com.zg.po.Book;
import com.zg.po.Chapter;
import com.zg.po.Sort;
import com.zg.po.User;
import com.zg.util.HibernateTemplate;
import com.zg.vo.BookInfo;


public class BookShDao implements IBookDao {

	private static HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	public void deleteBook(int id) {
		// TODO Auto-generated method stub

	}

	public static HibernateTemplate getSessionFactory(){
		return hibernateTemplate;
	}

	public Chapter getChapter(String bookid,String index ){
		return (Chapter)hibernateTemplate.find("from Chapter where bookid = "+bookid+" and index = "+index+"").get(0);
	}

	public List findAllBooks() {

		String hql = "from Book where isCheck = 1 and isdel = 0";
		return hibernateTemplate.find(hql);
	}

	public BookInfo findBookById(int id) {
		// TODO Auto-generated method stub
		/**private int id;
		private String name;// ����
		private String author;//����
		private float price;//����
		private int downloads;//������
		private int search;//������
		private int traffic;//������
		private String pic;//��������
		private Sort sort;*/
		String hql = "select new com.zg.vo.BookInfo(b.id,b.name,b.isread,b.author,b.price,b.downloads," +
				"b.search,b.traffic,b.pic,s.code,s.name,b.size,b.offerTime,b.press) " +
				"from Book  b inner join b.sort s " +
				"where b.id = ? and b.isdel = 0 and b.isCheck = 1";

		BookInfo bookInfo = (BookInfo) hibernateTemplate.find(hql,id).get(0);
		return bookInfo;
	}

	public Book findBookById2(int id){
		String hql = "from Book where id = "+id;
		List list = hibernateTemplate.find(hql);
		if(list!=null&&list.size()>0){
			return (Book)hibernateTemplate.find(hql).get(0);
		}
		return null;
	}

	public List<Book> findBookBySort(int sortid , int firstResult ,int maxResults) {
		// TODO Auto-generated method stub

		String hql = "from Book where sortid = ? and isdel = 0 and isCheck = 1";
		return hibernateTemplate.queryForList(hql, new Object[]{sortid}, firstResult, maxResults);
	}

	public List<BookInfo> findBooksByDownload() {
		// TODO Auto-generated method stub
		String hql = "select new com.zg.vo.BookInfo(b.id,b.name,s.code,s.name) " +
				"from Book  b inner join b.sort s " +
				"where b.isdel = 0 and b.isCheck = 1 order by b.downloads desc";
		return hibernateTemplate.queryForList(hql, null, 0, 10);
	}

	public List<BookInfo> findBooksBySearch() {
		// TODO Auto-generated method stub
		String hql = "select new com.zg.vo.BookInfo(b.id,b.name,s.code,s.name) " +
				"from Book   b inner join b.sort s " +
				"where b.isdel = 0 and b.isCheck = 1 order by b.search desc";
		return hibernateTemplate.queryForList(hql, null, 0, 10);
	}

	public List<BookInfo> findBooksByTraffic() {
		// TODO Auto-generated method stub
		String hql = "select new com.zg.vo.BookInfo(b.id,b.name,s.code,s.name) " +
				"from Book  b inner join b.sort s " +
				"where b.isdel = 0 and b.isCheck = 1 order by b.traffic desc";
		return hibernateTemplate.queryForList(hql, null, 0, 10);
	}

	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(book);
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sql.append("update book set isdel = 0 ");
		if(book.getName() != null){
			sql.append(", name = ? ");
			params.add(book.getName());
		}
		if(book.getAuthor() != null){
			sql.append(", author = ? ");
			params.add(book.getAuthor());
		}
		if(book.getPic() != null){
			sql.append(", pic = ? ");
			params.add(book.getPic());
		}
		if(book.getPress() != null){
			sql.append(", press = ? ");
			params.add(book.getPress());
		}
		if(book.getPrice() != 0){
			sql.append(", price = ? ");
			params.add(book.getPrice());
		}
		if(book.getOfferTime() != null){
			sql.append(", offerTime = ? ");
			params.add(book.getOfferTime());
		}
		sql.append("where id = ?");
		params.add(book.getId());
		hibernateTemplate.updateWithSQL(sql.toString(), params.toArray());
	}
	public void updateDownload(int id) {
		// TODO Auto-generated method stub
		String sql = "update book set downloads = downloads+1 where id = ?";
		hibernateTemplate.updateWithSQL(sql, new Object[]{id});

	}
	public void updateSearch(int id) {
		// TODO Auto-generated method stub
		String sql = "update book set search = search+1 where id = ?";
		hibernateTemplate.updateWithSQL(sql, new Object[]{id});
	}
	public void updateTraffic(int id) {
		// TODO Auto-generated method stub
		String sql = "update book set traffic = traffic+1 where id = ?";
		hibernateTemplate.updateWithSQL(sql, new Object[]{id});
	}
	public List<Book> searchByBookAuthor(String author,int firstResult ,int maxResults) {
		StringBuffer hql = new StringBuffer();
		hql.append("from Book where 1 = 1 and isCheck = 1 and isdel = 0 ");
		hql.append(" and author like '%"+author+"%'");

		//����+1
		hibernateTemplate.updateWithSQL("update book set search=search+1 where author like '%"+author+"%'", null);

		return hibernateTemplate.queryForList(hql.toString(), null, firstResult, maxResults);
	}
	public List<Book> searchByBookName(String name,int firstResult ,int maxResults) {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer();
		hql.append("from Book where 1 = 1 and isCheck = 1 and isdel = 0 ");
		hql.append(" and name like '%"+name+"%'");

		//����+1
		hibernateTemplate.updateWithSQL("update book set search=search+1 where name like '%"+name+"%'", null);

		return hibernateTemplate.queryForList(hql.toString(), null, firstResult, maxResults);
	}

	public String findEmail(int id) {
		// TODO Auto-generated method stub
		String hql = "select u.email from Book b inner join b.user u where b.id = ?";
		return (String) hibernateTemplate.queryForObject(hql, new Object[]{id});
	}
	public List checkUploadBook(int firstResult ,int maxResults) {
		// TODO Auto-generated method stub
		String hql = "from Book where isCheck = 0 order by offerTime desc";
		return hibernateTemplate.queryForList(hql, null, firstResult, maxResults);
	}
	public void checkBook(int id) {
		// TODO Auto-generated method stub
		String sql = "update Book set isCheck = 1 where id = ?";
		hibernateTemplate.updateWithSQL(sql, new Object[]{id});
	}
	public void checkBookBack(int id) {
		// TODO Auto-generated method stub
		String sql = "update Book set isCheck = 2 where id = ?";
		hibernateTemplate.updateWithSQL(sql, new Object[]{id});
	}
	public List findUploadBooks(int id , int firstResult ,int maxResults) {
		// TODO Auto-generated method stub
		String hql = "from Book where uid = ? order by offerTime desc";
		return hibernateTemplate.queryForList(hql, new Object[]{id}, firstResult, maxResults);
	}
	public String findBookName(int id) {
		// TODO Auto-generated method stub
		String hql = "select name from Book where id = ?";
		return (String) hibernateTemplate.queryForObject(hql, new Object[]{id});
	}
	public String findBookLoaction(int id) {
		// TODO Auto-generated method stub
		String hql = "select loaction from Book where id = ?";
		return (String) hibernateTemplate.queryForObject(hql, new Object[]{id});
	}
	public List<Book> findFreeBooks(int firstResult ,int maxResults) {
		String hql = "from Book where isCheck = 1 and isdel = 0 and isread = 0 ";
		return hibernateTemplate.queryForList(hql, null, firstResult, maxResults);
	}
	public int findSubSortBooks(int code) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from book where sortid = ? and isread = 0 and isCheck = 1 and isdel = 0";

		return ((BigInteger)hibernateTemplate.queryForObjectWithSQL(sql, new Object[]{code})).intValue();
	}
	public int findUncheckBooks() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from book where isCheck = 0";
		return ((BigInteger)hibernateTemplate.queryForObjectWithSQL(sql, null)).intValue();
	}
	public int findUserUploadBooks(int userid) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from book where uid = ?";
		return ((BigInteger)hibernateTemplate.queryForObjectWithSQL(sql, new Object[]{userid})).intValue();
	}
	public int findSearchByAuthor(String author) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from book where isread = 0 and isCheck = 1 and isdel = 0");
		sql.append(" and author like '%"+author+"%'");
		return ((BigInteger)hibernateTemplate.queryForObjectWithSQL(sql.toString(), null)).intValue();
	}
	public int findSearchByName(String name) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from book where isread = 0 and isCheck = 1 and isdel = 0");
		sql.append(" and name like '%"+name+"%'");
		return ((BigInteger)hibernateTemplate.queryForObjectWithSQL(sql.toString(), null)).intValue();
	}
	public int findFreeBooksSize() {
		String sql = "select count(*) from book where isread = 0 ";
		return ((BigInteger)hibernateTemplate.queryForObjectWithSQL(sql, null)).intValue();
	}
	public List<Chapter> getChapters(String bookid) {
		String hql = "from Chapter where bookid = "+bookid+" order by index asc";
		List list = hibernateTemplate.find(hql);
		return list;
	}
	public Chapter getChaptersById(String id) {
		String hql = "from Chapter where id = "+id;
		List list = hibernateTemplate.find(hql);
		if(list!=null&&list.size()>0){
			return (Chapter)list.get(0);
		}else{
			return null;
		}
	}
	public void saveChapter(Chapter c){
		hibernateTemplate.save(c);
	}
	public void editChapter(Chapter c){
		hibernateTemplate.update(c);
	}
	public BookInfo findBookByName(String name) {
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String hql2 = "select id from Book where name = '"+name+"'";
		String id = hibernateTemplate.find(hql2).get(0).toString();

		int idInt = Integer.parseInt(id);

		String hql = "select new com.zg.vo.BookInfo(b.id,b.name,b.isread,b.author,b.price,b.downloads," +
				"b.search,b.traffic,b.pic,s.code,s.name,b.size,b.offerTime,b.press) " +
				"from Book  b inner join b.sort s " +
				"where b.id = ? and b.isdel = 0 and b.isCheck = 1";

		BookInfo bookInfo = (BookInfo) hibernateTemplate.find(hql,idInt).get(0);
		return bookInfo;
	}
	public User findUserByBookid(int id){
		String sql = "select uid from book where id = "+id;
		String uid = hibernateTemplate.queryForObjectWithSQL(sql, null).toString();
		String hql = "from User where id = "+uid;
		List list = hibernateTemplate.find(hql);
		if(list!=null&&list.size()>0){
			return (User)list.get(0);
		}
		return null;
	}
}
