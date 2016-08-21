package com.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;




import com.google.code.kaptcha.Constants;
import com.hibernate.dao.ExpertDAO;


public class LoginAction extends SimpleFormController {
	
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
			LoginForm loginForm = (LoginForm) command;
			System.out.println(loginForm.getRole());
			System.out.println(loginForm.getLogin_username());
			System.out.println(loginForm.getLogin_password());
			System.out.println(loginForm.getLogin_code());
			if(!request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString().equals(loginForm.getLogin_code())){
				request.getSession().setAttribute("isExist","2");
				return new ModelAndView(getFormView());				
			}
			if(expertDAO.isValid(loginForm.getLogin_username(), loginForm.getLogin_password())){
				return new ModelAndView(getSuccessView());
			}
			else{
				request.getSession().setAttribute("isExist","1");
				return new ModelAndView(getFormView());
			}
    }

}
