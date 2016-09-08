package com.expert.response;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



import com.hibernate.beans.Expertqa;

public class ExpertqaDAO extends HibernateDaoSupport{
	
	public Expertqa getExpertqabyID(int id){
		Expertqa eqa=(Expertqa) getHibernateTemplate().get(Expertqa.class,new Integer(id));
		return eqa;
	}
	
	public void updateAnswer(int id, String answer){
		Expertqa eqa=this.getExpertqabyID(id);
		eqa.setAdescription(answer);
		eqa.setState(3);
		eqa.setAtime(new Date());
		eqa.setIsPayed(false);
		getHibernateTemplate().update(eqa);
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
				Criteria c=session.createCriteria(Expertqa.class);
				if(order.equals("asc")){
					c.addOrder(Order.asc(sort));
				}
				else if(order.equals("desc")){
					c.addOrder(Order.desc(sort));
				}
				else{
					
				}
				c.add(Restrictions.eq("state", 2));
				c.setFirstResult(page*size-size);
				c.setMaxResults(size);
				return c.list();
			}
		});
		return list;
	}
	public int getNum(final int expertid){
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Criteria c=session.createCriteria(Expertqa.class);
				c.add(Restrictions.eq("state", 2));
				c.add(Restrictions.eq("expertId", expertid));
				return c.list();
			}
		});		
		return list.size();
	}
	
	
	
}
