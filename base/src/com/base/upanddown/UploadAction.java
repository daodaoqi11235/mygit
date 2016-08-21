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
		System.out.println("��ʼ");  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
//        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path);  
        System.out.println(fileName); 
        System.out.println(ulform.getName());
        
/*        File targetFile = new File(path, fileName);  //�ϴ��ļ���ָ���ļ���Ŀ¼��

        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // ����
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //�����ļ���·�����ͻ��ˣ�������������ͼƬ
        byte[] inputData = file.getBytes();
        Fujian fj=new Fujian();
        fj.setFuJian(inputData);
        fjDAO.uploadFile(fj);
        return null;
	}


}
