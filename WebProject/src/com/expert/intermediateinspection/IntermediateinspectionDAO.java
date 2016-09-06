package com.expert.intermediateinspection;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Intermediateinspection;


public class IntermediateinspectionDAO extends HibernateDaoSupport{

	public boolean isExist(final int CoverID){
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Intermediateinspection.class).add(
						Restrictions.eq("coverOfIntermediateInspectionId", CoverID)).list();
				return result;
			}
		});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}		
	}
	
	public void addNewIntermediateinspection(final int CoverID){
		Intermediateinspection ii=new Intermediateinspection();
		ii.setCoverOfIntermediateInspectionId(CoverID);
		getHibernateTemplate().save(ii);
	}
	
	public void updateIntermediateinspection(Intermediateinspection ii){
		getHibernateTemplate().update(ii);
	}
	
	public Intermediateinspection getIntermediateinspection(final int CoverID){
		if(!this.isExist(CoverID)){
			this.addNewIntermediateinspection(CoverID);
		}
		
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Intermediateinspection.class).add(
						Restrictions.eq("coverOfIntermediateInspectionId", CoverID)).list();
				return result;
			}
		});
		
		return (Intermediateinspection)list.get(0);
	}
}
