package com.register;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RegMakerGoAction implements Controller{
	FieldDAO fieldDAO;
	
	public FieldDAO getFieldDAO() {
		return fieldDAO;
	}

	public void setFieldDAO(FieldDAO fieldDAO) {
		this.fieldDAO = fieldDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		List list=fieldDAO.getField();
		arg0.setAttribute("field", list);
		return new ModelAndView("register_maker");
	}

}
