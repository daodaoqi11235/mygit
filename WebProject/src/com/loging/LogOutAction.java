package com.loging;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogOutAction implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		 Enumeration<String> em = request.getSession().getAttributeNames();
		 
		         while (em.hasMoreElements()) {
		 
		             request.getSession().removeAttribute(em.nextElement().toString());
		 
		         }
		
		request.getSession().invalidate();
		return new ModelAndView("login");
	}

}
