package com.base.upanddown;



import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;











import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.base.hibernate.beans.Fujian;
import com.base.hibernate.dao.FujianDAO;
import com.base.spring.forms.UploadForm;



public class UploadAction extends SimpleFormController{

	FujianDAO fjDAO;



	public FujianDAO getFjDAO() {
		return fjDAO;
	}



	public void setFjDAO(FujianDAO fjDAO) {
		this.fjDAO = fjDAO;
	}



	public ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, Object command, BindException errors)	throws Exception{
		
		UploadForm ulform=(UploadForm) command;
		MultipartFile file=ulform.getFile();
		System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
//        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path);  
        System.out.println(fileName); 
        System.out.println(ulform.getName());
        
/*        File targetFile = new File(path, fileName);  //上传文件到指定文件夹目录下

        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //将该文件的路径给客户端，让其可以请求该图片
        byte[] inputData = file.getBytes();
        Fujian fj=new Fujian();
        fj.setFuJian(inputData);
        fjDAO.uploadFile(fj);
        return null;
	}


}
