package com.expert.response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ExpertResponseAction implements Controller{

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
		// TODO Auto-generated method stub
		expertqaDAO.updateAnswer(1, arg0.getParameter("achievement"));
		return new ModelAndView("expert/response");
	}

}
