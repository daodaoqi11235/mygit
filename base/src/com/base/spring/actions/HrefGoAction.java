package com.base.spring.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HrefGoAction implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("href");
		StringBuffer url=arg0.getRequestURL();
		System.out.println(url);
		String id=arg0.getQueryString();
		System.out.println(id);
		return null;
	}

}
