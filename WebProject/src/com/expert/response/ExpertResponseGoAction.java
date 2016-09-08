package com.expert.response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hibernate.beans.Expertqa;

public class ExpertResponseGoAction implements Controller{

	ExpertqaDAO expertqaDAO;
	public ExpertqaDAO getExpertqaDAO() {
		return expertqaDAO;
	}
	public void setExpertqaDAO(ExpertqaDAO expertqaDAO) {
		this.expertqaDAO = expertqaDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {

		String ans=arg0.getQueryString();
		String[] s=ans.split("=");
		String id=s[1];
		
		Expertqa eqa=expertqaDAO.getExpertqabyID(new Integer(id));
		arg0.setAttribute("ques", eqa.getQdescription());
		
		
		return new ModelAndView("expert/response");
	}

}
