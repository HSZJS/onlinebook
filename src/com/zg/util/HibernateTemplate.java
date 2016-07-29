package com.zg.util;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;

public class HibernateTemplate extends
org.springframework.orm.hibernate3.HibernateTemplate {

	public HibernateTemplate() {
		super();
	}
	public HibernateTemplate(SessionFactory sessionFactory, boolean allowCreate) {
		super(sessionFactory, allowCreate);
	}

	public HibernateTemplate(SessionFactory sessionFactory) {
		super(sessionFactory);
	}


	public List queryForList(final String hql, final Object[] params,
			final int firstResult, final int maxResults) {

		return (List) super.execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				initParams(query, params);
				return query.setFirstResult(firstResult).setMaxResults(
						maxResults).list();
			}
		});

	}

	public Object queryForObject(final String hql, final Object[] params) {

		return super.execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				initParams(query, params);
				return query.uniqueResult();
			}
		});

	}

	public int updateWithSQL(final String sql, final Object[] params) {
		return (Integer) super.execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				initParams(query, params);
				return query.executeUpdate();
			}

		});
	}

	public List queryForListWithSQL(final String sql, final Object[] params) {
		return queryForListWithSQL(sql, params, 0, 0);
	}


	public List queryForListWithSQL(final String sql, final Object[] params,
			final int firstResult, final int maxResults) {
		return (List) super.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				initParams(query, params);
				if (firstResult >= 0 && maxResults > 0) {
					query.setFirstResult(firstResult).setMaxResults(maxResults);
				}
				return query.list();
			}
		});
	}

	public Object queryForObjectWithSQL(final String sql, final Object[] params) {
		return (Object) super.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				initParams(query, params);
				return query.uniqueResult();
			}
		});
	}

	protected void initParams(Query query, Object[] params) {
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
	}
}