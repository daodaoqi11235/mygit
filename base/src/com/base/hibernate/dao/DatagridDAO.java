package com.base.hibernate.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DatagridDAO extends HibernateDaoSupport{
	public List getAll(){
		return getHibernateTemplate().find("from Datagrid");
	}
}
