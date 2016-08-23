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
import com.hibernate.beans.Maker;
import com.hibernate.dao.MakerDAO;

public class RegMakerAction extends SimpleFormController{
	MakerDAO makerDAO;
	public MakerDAO getMakerDAO() {
		return makerDAO;
	}
	public void setMakerDAO(MakerDAO makerDAO) {
		this.makerDAO = makerDAO;
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
			MakerForm mkf = (MakerForm) command;
			Maker mk=new Maker();
			
			mk.setLoginName(mkf.getRegister_username());
			mk.setPassword(mkf.getRegister_password());
			mk.setTeam(mkf.getRegister_team());
			mk.setContact(mkf.getRegister_contact());
			mk.setField1(mkf.getRegister_field1());
			mk.setField2(mkf.getRegister_field2());
			mk.setEmail(mkf.getRegister_email());
			mk.setPhone(mkf.getRegister_phone());
			mk.setAddress(mkf.getRegister_address());
			mk.setRoleId(2);
			System.out.println("RegMakerAction");
			try{
				makerDAO.insertMaker(mk);
			}catch (Exception e){
				List list=fieldDAO.getField();
				request.setAttribute("field", list);
				return new ModelAndView(getFormView());			
			}
			
			return new ModelAndView(getSuccessView());

    }
}
