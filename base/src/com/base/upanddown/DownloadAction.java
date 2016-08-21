package com.base.upanddown;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.base.hibernate.beans.Fujian;
import com.base.hibernate.dao.FujianDAO;

public class DownloadAction extends SimpleFormController{
	FujianDAO fjDAO;



	public FujianDAO getFjDAO() {
		return fjDAO;
	}



	public void setFjDAO(FujianDAO fjDAO) {
		this.fjDAO = fjDAO;
	}
	public ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, Object command, BindException errors)	throws Exception{
		Fujian fj=fjDAO.getFujian("11");
		if(fj==null){
			System.out.println("shibai");
			return null;
		}
		byte[] doc=fj.getFuJian();
		MultipartFile file=null;
		OutputStream fos = response.getOutputStream();
		InputStream is = new ByteArrayInputStream( doc);
		          //如果下载的是表格形式的，可能会出现乱码。加入下面这句话：（其他出现乱码的情况自己百度下。）
		//response.setHeader("Content-Type","application/vnd.ms-excel");
		//弹出保存框的语句，后面可以填入默认名称和类型
		response.setHeader("Content-Disposition","Attachment;filename=accessory."+"doc");
		byte[] buffer = new byte[1024];
		int size = 0;
		while ((size = is.read(buffer)) != -1) {
		      fos.write(buffer, 0, size);
		}
		      fos.flush();
		      fos.close();
		return null;
	}
}
