package com.base.spring.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ComboAction implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("combobox");
		String b="{\"id\":1,\"text\":\"1234\"}";
		System.out.println(b);
		response.setContentType("text/html");
		response.getWriter().print(b);
		response.getWriter().flush();
		response.getWriter().close();
		return null;
	}

}
