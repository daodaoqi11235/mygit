package com.register;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.hibernate.beans.Enterprise;
import com.hibernate.dao.EnterpriseDAO;


public class RegCompanyAction extends SimpleFormController {

	EnterpriseDAO enterpriseDAO;
	
	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}

	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}

	FieldDAO fieldDAO;
	
	public FieldDAO getFieldDAO() {
		return fieldDAO;
	}

	public void setFieldDAO(FieldDAO fieldDAO) {
		this.fieldDAO = fieldDAO;
	}
	protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
			EnterpriseForm epf = (EnterpriseForm) command;
			Enterprise ep=new Enterprise();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(epf.getRegister_time());
			ep.setName(epf.getRegister_company());
			ep.setLegalPerson(epf.getRegister_code());
			ep.setLoginName(epf.getRegister_username());
			ep.setPassword(epf.getRegister_password());
			ep.setRegistrationTime(date);
			ep.setRegisteredCapital(epf.getRegister_money());
			ep.setUnit(epf.getRegister_sort());
			ep.setChannel1(epf.getRegister_channel1());
			ep.setChannel2(epf.getRegister_channel2());
			ep.setContact(epf.getRegister_contact());
			ep.setPhone(epf.getRegister_phone());
			ep.setEmail(epf.getRegister_email());
			ep.setPostcode(epf.getRegister_address());
			ep.setRoleId(3);;
			try{
				enterpriseDAO.insertEnterprise(ep);
			}catch (Exception e){
				return new ModelAndView(getFormView());			
			}
			
			return new ModelAndView(getSuccessView());

    }
}
