package com.expert.intermediateinspection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hibernate.beans.Coverofintermediateinspection;
import com.hibernate.beans.Intermediateinspection;
import com.hibernate.beans.Intermediateinspectioninfo;

public class IntermediateInspectionGoAction implements Controller {

	IntermediateinspectionDAO intermediateinspectionDAO;
	public IntermediateinspectionDAO getIntermediateinspectionDAO() {
		return intermediateinspectionDAO;
	}
	public void setIntermediateinspectionDAO(
			IntermediateinspectionDAO intermediateinspectionDAO) {
		this.intermediateinspectionDAO = intermediateinspectionDAO;
	}
	CoverofintermediateinspectionDAO coiiDAO;
	public CoverofintermediateinspectionDAO getCoiiDAO() {
		return coiiDAO;
	}
	public void setCoiiDAO(CoverofintermediateinspectionDAO coiiDAO) {
		this.coiiDAO = coiiDAO;
	}
	IntermediateinspectioninfoDAO iiiDAO;

	public IntermediateinspectioninfoDAO getIiiDAO() {
		return iiiDAO;
	}
	public void setIiiDAO(IntermediateinspectioninfoDAO iiiDAO) {
		this.iiiDAO = iiiDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		Intermediateinspection ii=intermediateinspectionDAO.getIntermediateinspection(1);//此处以后写好了改一下输入参数,参数是中期检查表的主键
		arg0.setAttribute("ii", ii);
		Coverofintermediateinspection coii=coiiDAO.getCover(1);//此处以后写好了改一下输入参数,参数是中期检查表的主键
		arg0.setAttribute("coii", coii);
		Intermediateinspectioninfo iii=iiiDAO.getiii(1);//此处以后写好了改一下输入参数,参数是中期检查表的主键
		arg0.setAttribute("iii", iii);
		return new ModelAndView("expert/commentmiddle(part)");
	}

}
