package com.base.spring.actions;

import java.net.URLDecoder;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import net.sf.json.JSONArray;

import com.base.hibernate.beans.Datagrid;
import com.base.hibernate.dao.DatagridDAO;



public class LoadDataGridAction implements Controller{

	DatagridDAO gdDAO;
	
	public DatagridDAO getGdDAO() {
		return gdDAO;
	}

	public void setGdDAO(DatagridDAO gdDAO) {
		this.gdDAO = gdDAO;
	}

	public class dg {

		private String code;
		private String content;
		private String area;
		private String date;
		public dg(){
			
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public void setdg(Datagrid d){
			this.setArea(d.getArea());
			this.setCode(d.getCode());
			this.setContent(d.getContent());
			Date date=d.getDate();
			String s=DateFormat.getDateInstance().format(date);
			this.setDate(s);
		}
	}
	
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("datagrid");
		
		String pageNum=arg0.getParameter("pageNum");
		String pageSize = arg0.getParameter("pageSize");
		String sort = arg0.getParameter("sort");
		String order = arg0.getParameter("order");
		System.out.println(sort);
		List from=gdDAO.getByPage(pageNum, pageSize, sort, order);
		List<dg> to=new ArrayList<dg>();
		
		System.out.println("数组大小"+from.size());
		
		for(int i=0;i<from.size();i++){
			dg gg=new dg();
			gg.setdg((Datagrid) from.get(i));
			to.add(gg);
		}
		
		JSONArray jsonArr = JSONArray.fromObject(to);
		System.out.println(jsonArr);
		arg1.setContentType("text/html;charset=UTF-8");  
		arg1.setCharacterEncoding("UTF-8");  
		arg1.getWriter().write("{\"total\":"+gdDAO.getNum()+",\"rows\":"+jsonArr.toString()+"}");
		arg1.getWriter().flush();
		arg1.getWriter().close();
		return null;
	}
	
}
