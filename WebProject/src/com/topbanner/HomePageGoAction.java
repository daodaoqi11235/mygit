package com.topbanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HomePageGoAction implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		String role=(String)arg0.getSession().getAttribute("role");
		if(role.equals("创客用户")){
			return new ModelAndView("/maker/loging");
		}
		else if(role.equals("企业用户")){
			return new ModelAndView("/enterprise/loging");
		}
		else if(role.equals("专家用户")){
			return new ModelAndView("/expert/loging");
		}
		else
			return null;
	}

}
