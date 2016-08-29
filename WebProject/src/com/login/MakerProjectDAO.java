package com.login;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Makerproject;

public class MakerProjectDAO extends HibernateDaoSupport {
	public List getMakerproject() {
		System.out.println("Makerproject");
		@SuppressWarnings("rawtypes")
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Makerproject.class).addOrder(Order.desc("startTime")).setMaxResults(5).list();
				return result;
			}
		});

		return list;
	}
}
