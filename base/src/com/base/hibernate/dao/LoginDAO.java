package com.base.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.base.hibernate.beans.Login;


public class LoginDAO extends HibernateDaoSupport implements ILoginDAO{
	/* (non-Javadoc)
	 * @see com.base.hibernate.dao.ILoginDAO#isValid(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isValid(final String username, final String password) {
		List list = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				List result = session.createCriteria(Login.class).add(
						Restrictions.eq("email", username)).add(
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
