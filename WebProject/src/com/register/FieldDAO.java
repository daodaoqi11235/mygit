package com.register;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FieldDAO extends HibernateDaoSupport{
	public List getField(){
		return getHibernateTemplate().find("from Field");
	}

}
