package com.zg.service.sh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zg.dao.IBorrowBookDao;
import com.zg.po.Borrowbook;
import com.zg.service.IBorrowBookService;
import com.zg.util.Interval;
import com.zg.util.Page;
import com.zg.vo.BorrowBookInfo;

public class BorrowBookServiceImpl implements IBorrowBookService {
	private IBorrowBookDao borrowBookDao;
	
	public void setBorrowBookDao(IBorrowBookDao borrowBookDao) {
		this.borrowBookDao = borrowBookDao;
	}

	public Page findBooks(int userid ,int pn) {
		// TODO Auto-generated method stub
		int count = borrowBookDao.findUserBorrowBooks(userid);
		Page page = new Page(userid, count, pn, 10); 
		List list = borrowBookDao.findBooks(userid, page.getFirstResult(), page.getMaxResults());
		List<BorrowBookInfo> listBorrows = new ArrayList<BorrowBookInfo>();
		for(int i = 0;i<list.size();i++){
			Object[] obj = (Object[]) list.get(i);
			BorrowBookInfo borrowBookInfo = new BorrowBookInfo();
			borrowBookInfo.setAuthor((String)obj[0]);
			borrowBookInfo.setName((String)obj[1]);
			borrowBookInfo.setReTime((((Date)obj[2]).getTime()-new Date().getTime())/1000);
			borrowBookInfo.setBookid((Integer)obj[3]);
			if((((Date)obj[2]).getTime()-new Date().getTime())/1000 < 0){
				update((Integer)obj[4],(Integer)obj[3]);
			}
			listBorrows.add(borrowBookInfo);
		}
		page.setResult(listBorrows);
		return page;
	}

	public void save(Borrowbook borrowBook) {
		// TODO Auto-generated method stub
		borrowBookDao.save(borrowBook);
	}

	public void update(int userid, int bookid) {
		// TODO Auto-generated method stub
		borrowBookDao.update(userid, bookid);
	}

	public List findUserBookID(int userid) {
		// TODO Auto-generated method stub
		return borrowBookDao.findUserBookID(userid);
	}

}
