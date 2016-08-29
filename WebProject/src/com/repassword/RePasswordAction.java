package com.repassword;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.hibernate.beans.Maker;
import com.hibernate.dao.EnterpriseDAO;
import com.hibernate.dao.ExpertDAO;
import com.hibernate.dao.GovernmentDAO;
import com.hibernate.dao.MakerDAO;



public class RePasswordAction extends SimpleFormController {
	
	ExpertDAO expertDAO;
	MakerDAO makerDAO;
	public MakerDAO getMakerDAO() {
		return makerDAO;
	}



	public void setMakerDAO(MakerDAO makerDAO) {
		this.makerDAO = makerDAO;
	}



	EnterpriseDAO enterpriseDAO;
	GovernmentDAO governmentDAO;








	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}



	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}



	public GovernmentDAO getGovernmentDAO() {
		return governmentDAO;
	}



	public void setGovernmentDAO(GovernmentDAO governmentDAO) {
		this.governmentDAO = governmentDAO;
	}



	public ExpertDAO getExpertDAO() {
		return expertDAO;
	}



	public void setExpertDAO(ExpertDAO expertDAO) {
		this.expertDAO = expertDAO;
	}
	protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
			System.out.println("repasswordaction");
			RePasswordForm rpf=(RePasswordForm) command;
			if(request.getSession().getAttribute("role").equals("创客用户")){
				makerDAO.resetPassword( (Integer) request.getSession().getAttribute("makerID"),rpf.getNewp());
				request.getSession().setAttribute("password", rpf.getNewp());
				return new ModelAndView("/maker/loging");
			}
			else if(request.getSession().getAttribute("role").equals("企业用户")){
				enterpriseDAO.resetPassword( (Integer) request.getSession().getAttribute("enterpriseID"),rpf.getNewp());
				request.getSession().setAttribute("password", rpf.getNewp());	
				return new ModelAndView("/enterprise/loging");
			}
			else if(request.getSession().getAttribute("role").equals("专家用户")){
				expertDAO.resetPassword( (Integer) request.getSession().getAttribute("expertID"),rpf.getNewp());
				request.getSession().setAttribute("password", rpf.getNewp());	
				return new ModelAndView("/expert/loging");
			}
			else
				return null;
			
			
    }
}
