package com.expert.intermediateinspection;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Coverofintermediateinspection;


public class CoverofintermediateinspectionDAO extends HibernateDaoSupport{
	public Coverofintermediateinspection getCover(final int CoverID){
 
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Coverofintermediateinspection.class).add(
						Restrictions.eq("coverOfIntermediateInspectionId", CoverID)).list();
				return result;
			}
		});
		
		return (Coverofintermediateinspection)list.get(0);
	}
	
	public void updatecoii(String name,String d,final int CoverID){
		Coverofintermediateinspection coii=this.getCover(CoverID);
		coii.setN5(name);
		Date date=new Date();
		coii.setDate(date);
		String[] s=d.split("-");
		coii.setN6(s[0]);
		coii.setN7(s[1]);
		coii.setN8(s[2]);
		getHibernateTemplate().update(coii);
	}
}
