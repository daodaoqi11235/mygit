package com.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.beans.Expert;



public class ExpertDAO extends HibernateDaoSupport implements IExpertDAO{
	/* (non-Javadoc)
	 * @see com.hibernate.dao.IExpertDAO#isValid(java.lang.String, java.lang.String)
	 */
	public boolean isValid(final String username, final String password) {
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Expert.class).add(
						Restrictions.eq("loginName", username)).add(
						Restrictions.eq("password", password)).list();
				return result;
			}
		});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
