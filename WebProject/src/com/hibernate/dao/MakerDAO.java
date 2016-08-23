package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



import com.hibernate.beans.Enterprise;
import com.hibernate.beans.Maker;

public class MakerDAO extends HibernateDaoSupport{
	public boolean isValid(final String username, final String password) {
		@SuppressWarnings("rawtypes")
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Maker.class).add(
						Restrictions.eq("loginName", username)).add(
						Restrictions.eq("password", password)).list();
				return result;
			}
		});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isExist(final String username){
		List list =(List) getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session)
			throws HibernateException{
				List result = session.createCriteria(Maker.class).add(
						Restrictions.eq("loginName", username)).list();
				return result;
			}
		});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	public void insertMaker(Maker mk) {
		getHibernateTemplate().saveOrUpdate(mk);
	}
}
