package com.zg.dao.sh;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SessionFactory;

import com.zg.dao.IBorrowBookDao;
import com.zg.po.Borrowbook;
import com.zg.util.HibernateTemplate;
import com.zg.vo.BorrowBookInfo;

public class BorrowBookShDao implements IBorrowBookDao {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	public List findBooks(int userid,int firstResult,int maxResults) {
		// TODO Auto-generated method stub
		String sql = "select b.author,b.name,bb.deadline,b.id,bb.userid" +
					 " from book b ,(select bookid,deadline,userid from borrowbook where userid = ? and isdel = 0 ) bb" +
					 " where b.id = bb.bookid";
		return hibernateTemplate.queryForListWithSQL(sql, new Object[]{userid}, firstResult, maxResults);
	}



	public void save(Borrowbook borrowBook) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(borrowBook);
	}

	public void update(int userid, int bookid) {
		// TODO Auto-generated method stub
		String sql = "update borrowbook set isread = 1 where userid = ? and bookid = ?";
		hibernateTemplate.updateWithSQL(sql, new Object[]{userid,bookid});
	}
	public List findUserBookID(int userid) {
		// TODO Auto-generated method stub
		String hql = "select bookid from Borrowbook where userid = ? and isread = 0";
		return hibernateTemplate.find(hql, new Object[]{userid});
	}
	public int findUserBorrowBooks(int userid) {
		String sql = "select count(*) from borrowbook where userid = ?";
		return ((BigInteger)hibernateTemplate.queryForObjectWithSQL(sql, new Object[]{userid})).intValue();
	}

}
