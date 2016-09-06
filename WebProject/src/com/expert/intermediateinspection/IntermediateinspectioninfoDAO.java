package com.expert.intermediateinspection;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Intermediateinspectioninfo;

public class IntermediateinspectioninfoDAO extends HibernateDaoSupport{
	public Intermediateinspectioninfo getiii(final int CoverID){
		return (Intermediateinspectioninfo)getHibernateTemplate().get(Intermediateinspectioninfo.class, CoverID);
	} 
}
