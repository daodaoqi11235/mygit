package com.expert.informationupdate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hibernate.beans.Expert;
import com.hibernate.dao.ExpertDAO;

public class ExpertInformationGoAction implements Controller{
	ExpertDAO expertDAO;
	public ExpertDAO getExpertDAO() {
		return expertDAO;
	}
	public void setExpertDAO(ExpertDAO expertDAO) {
		this.expertDAO = expertDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		Integer expertID=(Integer)arg0.getSession().getAttribute("expertID");
		Expert exp=expertDAO.getExpertbyID(expertID.toString());
		if(exp.getName()==null){
			exp.setName("");
		}
		if(exp.getAchievement()==null){
			exp.setAchievement("");
		}
		if(exp.getAge()==null){
			exp.setAge(Integer.getInteger(""));
		}
		if(exp.getCellphone()==null){
			exp.setCellphone("");
		}
		if(exp.getCompany()==null){
			exp.setCompany("");
		}
		if(exp.getEducation()==null){
			exp.setEducation("");
		}
		if(exp.getEmail()==null){
			exp.setEmail("");
		}
		if(exp.getField1()==null){
			exp.setField1("");
		}
		if(exp.getField2()==null){
			exp.setField2("");
		}
		if(exp.getMajor()==null){
			exp.setMajor("");
		}
		if(exp.getTelephone()==null){
			exp.setTelephone("");
		}
		if(exp.getTitle()==null){
			exp.setTitle("");
		}
		System.out.println("gogogo");

		arg0.setAttribute("ExpertInfo", exp);
		return new ModelAndView("expert/personalityPage");
	}
	
}
