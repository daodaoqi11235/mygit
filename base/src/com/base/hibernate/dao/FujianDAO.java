package com.base.hibernate.dao;

import com.base.hibernate.beans.Fujian;
import com.base.hibernate.beans.User;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FujianDAO  extends HibernateDaoSupport implements IFujianDAO{

	public void uploadFile(Fujian fj){
		getHibernateTemplate().saveOrUpdate(fj);
	}
	public Fujian getFujian(String id) {
		return (Fujian) getHibernateTemplate().get(Fujian.class,
				new Integer(id));
	}
}
