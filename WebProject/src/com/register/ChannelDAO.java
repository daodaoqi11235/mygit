package com.register;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ChannelDAO extends HibernateDaoSupport{
	public List getChannel(){
		return getHibernateTemplate().find("from Channel");
	}
}
