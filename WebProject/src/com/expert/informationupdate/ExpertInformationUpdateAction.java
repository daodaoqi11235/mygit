package com.expert.informationupdate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.hibernate.beans.Expert;
import com.hibernate.dao.ExpertDAO;

public class ExpertInformationUpdateAction extends SimpleFormController{
	ExpertDAO expertDAO;
	
	
	public ExpertDAO getExpertDAO() {
		return expertDAO;
	}


	public void setExpertDAO(ExpertDAO expertDAO) {
		this.expertDAO = expertDAO;
	}


	protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
		InformationUpdateForm iuf=(InformationUpdateForm) command;
		
		expertDAO.upadateDescription( (Integer) request.getSession().getAttribute("expertID"), iuf.getAchievement());
		
		return new ModelAndView("forward:/expertinformationgo.do");
	}
}
