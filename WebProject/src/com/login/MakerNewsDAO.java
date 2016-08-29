package com.login;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



import com.hibernate.beans.Makernews;

public class MakerNewsDAO extends HibernateDaoSupport{
	
	public List getN_policy() {
		System.out.println("N_policy");
		@SuppressWarnings("rawtypes")
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Makernews.class).add(
						Restrictions.eq("type", "���ҿƼ�����")).addOrder(Order.desc("time")).setMaxResults(5).list();
				return result;
			}
		});

		return list;
	}
	public List getTraining() {
		System.out.println("N_policy");
		@SuppressWarnings("rawtypes")
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Makernews.class).add(
						Restrictions.eq("type", "������ѵ֪ͨ")).addOrder(Order.desc("time")).setMaxResults(5).list();
				return result;
			}
		});

		return list;
	}
	public List getAnnouncement() {
		@SuppressWarnings("rawtypes")
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Makernews.class).add(
						Restrictions.eq("type", "ϵͳ����")).addOrder(Order.desc("time")).setMaxResults(5).list();
				return result;
			}
		});
		return list;

	}
	public List getFoundation() {
		@SuppressWarnings("rawtypes")
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Makernews.class).add(
						Restrictions.eq("type", "ר�������")).addOrder(Order.desc("time")).setMaxResults(5).list();
				return result;
			}
		});
		return list;

	}
	public List getB_policy() {
		@SuppressWarnings("rawtypes")
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Makernews.class).add(
						Restrictions.eq("type", "�����ʽ�Ԯ����Ŀ")).addOrder(Order.desc("time")).setMaxResults(5).list();
				return result;
			}
		});
		return list;

	}
}
