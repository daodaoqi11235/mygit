package com.base.spring.actions;



import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.base.hibernate.dao.EnumDAO;
import com.base.spring.forms.EnumForm;
import com.base.hibernate.beans.Enum;

public class EnumAction extends SimpleFormController{
	EnumDAO enumDAO;

	public EnumDAO getEnumDAO() {
		return enumDAO;
	}

	public void setEnumDAO(EnumDAO enumDAO) {
		this.enumDAO = enumDAO;
	}

	public ModelAndView onSubmit(HttpServletRequest req,HttpServletResponse res,Object command,BindException errors) throws UnsupportedEncodingException{
		EnumForm ef=(EnumForm) command;
		Enum e = new Enum();
		System.out.println(ef.getId());
		System.out.println(ef.getEenum());
		System.out.println(ef.getTxt());
		e.setId(Integer.parseInt(ef.getId()));
		e.setEnum_(ef.getEenum());
		e.setTxt(ef.getTxt());
		enumDAO.add(e);
		return null;
	}
}
