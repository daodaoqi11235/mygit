package com.repassword;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.hibernate.beans.Maker;
import com.hibernate.dao.MakerDAO;



public class RePasswordAction extends SimpleFormController {
	
	MakerDAO makerDAO;
	public MakerDAO getMakerDAO() {
		return makerDAO;
	}
	public void setMakerDAO(MakerDAO makerDAO) {
		this.makerDAO = makerDAO;
	}
	protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
		System.out.println("repasswordaction");
			RePasswordForm rpf=(RePasswordForm) command;
			makerDAO.resetPassword( (Integer) request.getSession().getAttribute("makerID"),rpf.getNewp());
			request.getSession().setAttribute("password", rpf.getNewp());
			return new ModelAndView(getSuccessView());
    }
}
