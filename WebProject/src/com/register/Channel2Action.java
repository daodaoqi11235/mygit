  package com.register;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hibernate.beans.Channel;

public class Channel2Action implements Controller{

	ChannelDAO channelDAO;
	public ChannelDAO getChannelDAO() {
		return channelDAO;
	}
	public void setChannelDAO(ChannelDAO channelDAO) {
		this.channelDAO = channelDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("channel2");
		String s=arg0.getParameter("first");
		System.out.println(s+ "  json");
		List list=channelDAO.getChannel();
		String resp="{\"msg\":[";
		for(int i=0;i<list.size();i++){
			Channel c=(Channel)list.get(i);
			if(c.getPart1().equals(s)){
				if(!resp.equals("{\"msg\":[")){
					resp+=",";
				}
				resp=resp+"{\""+"value"+"\":\""+c.getPart2()+"\",\""+"text"+"\":\""+c.getPart2()+"\"}";
			}
		}
		resp+="]}";
		System.out.println("json is "+resp);
		arg1.setContentType("text/html;charset=UTF-8");  
		arg1.setCharacterEncoding("UTF-8");  
		arg1.getWriter().write(resp);
		arg1.getWriter().flush();
		arg1.getWriter().close();
		return null;
	}

}
