package com.expert.response;

import java.util.Date;

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
}
