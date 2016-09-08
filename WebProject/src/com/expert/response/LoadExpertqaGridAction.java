package com.expert.response;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


import com.hibernate.beans.Expertqa;



public class LoadExpertqaGridAction implements Controller{

	ExpertqaDAO expertqaDAO;
	
	public ExpertqaDAO getExpertqaDAO() {
		return expertqaDAO;
	}

	public void setExpertqaDAO(ExpertqaDAO expertqaDAO) {
		this.expertqaDAO = expertqaDAO;
	}

	
	public class question {

		private String questionID;
		private String qdescription;
		private String field;
		private String qtime;
		public String getQuestionID() {
			return questionID;
		}

		public void setQuestionID(String questionID) {
			this.questionID = questionID;
		}

		public String getQdescription() {
			return qdescription;
		}

		public void setQdescription(String qdescription) {
			this.qdescription = qdescription;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getQtime() {
			return qtime;
		}

		public void setQtime(String qtime) {
			this.qtime = qtime;
		}

		public question(){
			
		}
		
		public void setq(Expertqa e){
			this.setField(e.getField());;
			this.setQdescription(e.getQdescription());;
			this.setQuestionID(e.getQuestionId().toString());
			Date date=e.getQtime();
			String s=DateFormat.getDateInstance().format(date);
			this.setQtime(s);
		}
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		String pageNum=arg0.getParameter("pageNum");
		String pageSize = arg0.getParameter("pageSize");
		String sort = arg0.getParameter("sort");
		String order = arg0.getParameter("order");
		System.out.println(sort);
		List from=expertqaDAO.getByPage(pageNum, pageSize, sort, order);
		List<question> to=new ArrayList<question>();
		
		System.out.println("数组大小"+from.size());
		
		for(int i=0;i<from.size();i++){
			question gg=new question();
			gg.setq((Expertqa) from.get(i));
			to.add(gg);
		}
		
		JSONArray jsonArr = JSONArray.fromObject(to);
		System.out.println(jsonArr);
		arg1.setContentType("text/html;charset=UTF-8");  
		arg1.setCharacterEncoding("UTF-8");  
		arg1.getWriter().write("{\"total\":"+expertqaDAO.getNum((Integer)arg0.getSession().getAttribute("expertID"))+",\"rows\":"+jsonArr.toString()+"}");
		arg1.getWriter().flush();
		arg1.getWriter().close();
		return null;
	}

}
