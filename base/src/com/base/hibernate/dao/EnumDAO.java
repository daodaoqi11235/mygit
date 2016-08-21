package com.base.hibernate.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.base.hibernate.beans.Enum;

public class EnumDAO extends HibernateDaoSupport implements IEnumDAO{
	/* (non-Javadoc)
	 * @see com.base.hibernate.dao.IEnumDAO#add(java.lang.Enum)
	 */
	public void add(Enum e){
		getHibernateTemplate().saveOrUpdate(e);
	}

}
