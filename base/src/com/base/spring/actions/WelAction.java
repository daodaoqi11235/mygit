package com.base.spring.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.base.spring.forms.LoginForm;

public class WelAction extends SimpleFormController {
	protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
			request.setAttribute("wel", "sef");
			System.out.println("ef");
			return new ModelAndView(getSuccessView());

    }
}
