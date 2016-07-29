package com.zg.util;

import org.hibernate.Session;

public interface HibernateCallback {
	
	public Object doInHibernate(Session session) throws Exception;

}
