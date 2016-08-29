package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Enterprise;




public class EnterpriseDAO extends HibernateDaoSupport{
	public boolean isValid(final String username, final String password) {
		@SuppressWarnings("rawtypes")
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Enterprise.class).add(
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
				List result = session.createCriteria(Enterprise.class).add(
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
	public void insertEnterprise(Enterprise ep) {
		getHibernateTemplate().saveOrUpdate(ep);
	}
	
	public Enterprise getEnterprise(final String username) {
		@SuppressWarnings("rawtypes")
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Enterprise.class).add(
						Restrictions.eq("loginName", username)).list();
				return result;
			}
		});
		if (list.size() == 1) {
			return (Enterprise) list.get(0);
		} else {
			return null;
		}
	}
	
	public Enterprise getEnterprisebyID(String userid) {
		return (Enterprise) getHibernateTemplate().get(Enterprise.class,
				new Integer(userid));
	}
	public void resetPassword(int id,String np){
		Enterprise mk=this.getEnterprisebyID(Integer.toString(id));
		mk.setPassword(np);
		getHibernateTemplate().update(mk);
	}
}
