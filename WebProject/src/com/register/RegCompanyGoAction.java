package com.register;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RegCompanyGoAction implements Controller{
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
		List list=channelDAO.getChannel();
		arg0.setAttribute("channel", list);
		return new ModelAndView("register_company");
	}
}
