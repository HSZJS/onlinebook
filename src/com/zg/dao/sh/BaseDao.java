package com.zg.dao.sh;

import org.hibernate.SessionFactory;

import com.zg.util.HibernateTemplate;



public abstract class BaseDao{

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
 
	public HibernateTemplate getHibernateTemplate() {
		System.out.println(hibernateTemplate);
		System.out.println("����������");
		return hibernateTemplate;
	}

}
