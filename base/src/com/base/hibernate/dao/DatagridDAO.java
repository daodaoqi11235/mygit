package com.base.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.base.hibernate.beans.Datagrid;
import com.base.hibernate.beans.User;

public class DatagridDAO extends HibernateDaoSupport{
	public List getAll(){
		return getHibernateTemplate().find("from Datagrid");
	}
	
	public List getByPage(final String pageNum,final String pageSize,final String sort,final String order){
		final int page=new Integer(pageNum);
		final int size=new Integer(pageSize);
		System.out.println(page);
		System.out.println(size);
		System.out.println(sort);
		System.out.println(order);
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Criteria c=session.createCriteria(Datagrid.class);
				if(order.equals("asc")){
					c.addOrder(Order.asc(sort));
				}
				else if(order.equals("desc")){
					c.addOrder(Order.desc(sort));
				}
				else{
					
				}
				
				c.setFirstResult(page*size-size);
				c.setMaxResults(size);
				return c.list();
			}
		});
		return list;
	}
	public int getNum(){
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Criteria c=session.createCriteria(Datagrid.class);
				return c.list();
			}
		});		
		return list.size();
	}
}
