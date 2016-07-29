package com.zg.dao.sh;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.zg.dao.IMessageDao;
import com.zg.dao.IRecordDao;
import com.zg.po.Message;
import com.zg.po.Record;
import com.zg.util.HibernateTemplate;
import com.zg.vo.RecordInfo;

public class MessageShDao implements IMessageDao {
	
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	public void save(Message m){
		String userView = hibernateTemplate.find("select nickname from User where id = "+m.getUserid()).get(0).toString();
		if(m.getBookid()!=null&&!"".equals(m.getBookid())){
		String bookView = hibernateTemplate.find("select name from Book where id = "+m.getBookid()).get(0).toString();
		m.setBookView(bookView);
		}else{
			m.setBookid("-1");
			m.setBookView("系统意见");
		}
		m.setUserView(userView);
		hibernateTemplate.save(m);
	}
	public List getAll(String userid){
		return hibernateTemplate.find("from Message where userid = "+userid);
	}
	public List getByUser(String userid){
		String hql = "";
		if("1".equals(userid)){
		hql = "from Message";	
		}else{
			hql = "from Message where bookid in (select id from Book where user.id = "+userid+")";
		}
		return hibernateTemplate.find(hql);
	}
	
}
