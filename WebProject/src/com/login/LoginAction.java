package com.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;












import com.google.code.kaptcha.Constants;
import com.hibernate.beans.Enterprise;
import com.hibernate.beans.Expert;
import com.hibernate.beans.Maker;
import com.hibernate.dao.AdministratorDAO;
import com.hibernate.dao.EnterpriseDAO;
import com.hibernate.dao.ExpertDAO;
import com.hibernate.dao.GovernmentDAO;
import com.hibernate.dao.MakerDAO;


public class LoginAction extends SimpleFormController {
	
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

	MakerNewsDAO makernewsDAO;

	public MakerNewsDAO getMakernewsDAO() {
		return makernewsDAO;
	}



	public void setMakernewsDAO(MakerNewsDAO makernewsDAO) {
		this.makernewsDAO = makernewsDAO;
	}

	MakerProjectDAO makerprojectDAO;
    
	
	
	
	public MakerProjectDAO getMakerprojectDAO() {
		return makerprojectDAO;
	}



	public void setMakerprojectDAO(MakerProjectDAO makerprojectDAO) {
		this.makerprojectDAO = makerprojectDAO;
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
			
			if(loginForm.getRole().equals("expert")&&expertDAO.isValid(loginForm.getLogin_username(), loginForm.getLogin_password())){		
				request.getSession().setAttribute("MenuFrame", "/jsp/expert/leftmenu.jsp");
				request.getSession().setAttribute("PageFrame", "/jsp/expert/loging.jsp");
				if(expertDAO.getExpert(loginForm.getLogin_username())!=null){
					Expert exp=expertDAO.getExpert(loginForm.getLogin_username());
					request.getSession().setAttribute("loginname", exp.getLoginName());
					request.getSession().setAttribute("password", exp.getPassword());
					request.getSession().setAttribute("role", "专家用户");	
					request.getSession().setAttribute("roleID", exp.getRoleId());
					request.getSession().setAttribute("expertID", exp.getExpertId());
				}
				else{
					System.out.println("无此用户");
				}
				//添加新闻


				List list2=makernewsDAO.getAnnouncement();



				request.getSession().setAttribute("announcement", list2);


				return new ModelAndView("index");
			}
			else if(loginForm.getRole().equals("maker")&&makerDAO.isValid(loginForm.getLogin_username(), loginForm.getLogin_password())){
				request.getSession().setAttribute("MenuFrame", "/jsp/maker/leftmenu.jsp");
				request.getSession().setAttribute("PageFrame", "/jsp/maker/loging.jsp");
				if(makerDAO.getMaker(loginForm.getLogin_username())!=null){
					Maker exp=makerDAO.getMaker(loginForm.getLogin_username());
					request.getSession().setAttribute("loginname", exp.getLoginName());
					request.getSession().setAttribute("password", exp.getPassword());
					request.getSession().setAttribute("role", "创客用户");	
					request.getSession().setAttribute("roleID", exp.getRoleId());
					request.getSession().setAttribute("makerID", exp.getMakerId());
				}
				else{
					System.out.println("无此用户");
				}
				//添加新闻
				
				List list1=makerprojectDAO.getMakerproject();
				List list2=makernewsDAO.getAnnouncement();
				List list3=makernewsDAO.getTraining();
				List list4=makernewsDAO.getB_policy();
				request.getSession().setAttribute("makerproject", list1);
				request.getSession().setAttribute("announcement", list2);
				request.getSession().setAttribute("training", list3);
				request.getSession().setAttribute("b_policy", list4);
				return new ModelAndView("index");
			}
			else if(loginForm.getRole().equals("enterprise")&&enterpriseDAO.isValid(loginForm.getLogin_username(), loginForm.getLogin_password())){
				
				request.getSession().setAttribute("MenuFrame", "/jsp/enterprise/leftmenu.jsp");
				request.getSession().setAttribute("PageFrame", "/jsp/enterprise/loging.jsp");
				if(enterpriseDAO.getEnterprise(loginForm.getLogin_username())!=null){
					Enterprise etp=enterpriseDAO.getEnterprise(loginForm.getLogin_username());
					request.getSession().setAttribute("loginname", etp.getLoginName());
					request.getSession().setAttribute("password", etp.getPassword());
					request.getSession().setAttribute("role", "企业用户");	
					request.getSession().setAttribute("roleID", etp.getRoleId());
					request.getSession().setAttribute("enterpriseID", etp.getEnterpriseId());
				}
				else{
					System.out.println("无此用户");
				}
				//添加新闻
				
				List list1=makernewsDAO.getN_policy();
				List list2=makernewsDAO.getAnnouncement();
				List list3=makernewsDAO.getFoundation();
				request.getSession().setAttribute("n_policy", list1);
				request.getSession().setAttribute("announcement", list2);
				request.getSession().setAttribute("foundation", list3);
				return new ModelAndView("index");
				
			}
			else if(loginForm.getRole().equals("government")&&governmentDAO.isValid(loginForm.getLogin_username(), loginForm.getLogin_password())){
				return new ModelAndView("welcome");
			}
			else{
				request.getSession().setAttribute("isExist","1");
				return new ModelAndView(getFormView());
			}
    }

}
