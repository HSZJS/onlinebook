package com.zg.dao.sh;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zg.dao.ISortDao;
import com.zg.po.Sort;
import com.zg.util.HibernateTemplate;

public class SortShDao implements ISortDao {

	private HibernateTemplate hibernateTemplate;
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	public void deleteSort(int id) {
		// TODO Auto-generated method stub

	}


	public List<Sort> findSorts() {
		// TODO Auto-generated method stub
		String hql = "from Sort";
		return hibernateTemplate.find(hql);
	}


	public void saveSort(int id, String name) {
		// TODO Auto-generated method stub

	}

	public void updateSort(int id, String name) {
		// TODO Auto-generated method stub

	}
	public List<Sort> findSubSorts(int code) {
		
		return null;
	}
	public Sort findParentSort(int code) {
		// TODO Auto-generated method stub
		String str_code = code+"";
		String prefix = str_code.substring(0, 4);
		int codee = Integer.parseInt(prefix+"00");
		String hql = "from Sort where code = ?";
		return (Sort) hibernateTemplate.find(hql,codee).get(0);
	}

}
