package com.register;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hibernate.dao.EnterpriseDAO;

public class CompanyExistAction implements Controller{

	EnterpriseDAO enterpriseDAO;
	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		String name=arg0.getParameter("username");
		String result="fail";
		if(!enterpriseDAO.isExist(name)){
			result="success";
		}
		arg1.getWriter().write(result);
		arg1.getWriter().flush();
		arg1.getWriter().close();
		return null;
	}

}
