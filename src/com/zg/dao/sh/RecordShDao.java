package com.zg.dao.sh;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import com.zg.dao.IRecordDao;
import com.zg.po.Record;
import com.zg.util.HibernateTemplate;
import com.zg.vo.RecordInfo;

public class RecordShDao implements IRecordDao {
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	public List findRecords(int firstResult ,int maxResults) {
		// TODO Auto-generated method stub
		String hql = "from Record order by starttime desc";
		return hibernateTemplate.queryForList(hql, null, firstResult, maxResults);

	}


	public List<Record> findRecords(Date time) {
		// TODO Auto-generated method stub
		return null;
	}


	public void saveRecord(Record record) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(record);
	}
	public int findRecordSize() {
		String sql = "select count(*) from record ";
		return ((BigInteger)hibernateTemplate.queryForObjectWithSQL(sql, null)).intValue();
	}


}
