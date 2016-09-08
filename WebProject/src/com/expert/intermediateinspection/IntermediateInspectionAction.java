package com.expert.intermediateinspection;

import java.text.SimpleDateFormat;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


import com.hibernate.beans.Intermediateinspection;

public class IntermediateInspectionAction implements Controller{
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
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println("ii");
		Intermediateinspection iiori=intermediateinspectionDAO.getIntermediateinspection(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");                
		iiori.setP5(sdf.parse(arg0.getParameter("stime")));
		iiori.setP6(sdf.parse(arg0.getParameter("etime")));
		iiori.setP7(sdf.parse(arg0.getParameter("ctime")));
		iiori.setP8(arg0.getParameter("presention"));
		iiori.setP9(arg0.getParameter("advice"));
		
		if(arg0.getParameter("sort").equals("submit")){
			coiiDAO.StatetoCommit(1);
			coiiDAO.updatecoii((String )arg0.getParameter("expl"),(String )arg0.getParameter("wtime"), 1);
			intermediateinspectionDAO.updateIntermediateinspection(iiori);
		}
		else{
			intermediateinspectionDAO.updateIntermediateinspection(iiori);
			coiiDAO.updatecoii((String )arg0.getParameter("expl"),(String )arg0.getParameter("wtime"), 1);
		}
		
		return new ModelAndView("forward:/intermediateinspectiongo.do");
	}

}
