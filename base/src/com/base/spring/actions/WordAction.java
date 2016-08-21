package com.base.spring.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.base.spring.forms.WordForm;
import com.base.word.ftl.WordGenerator;

public class WordAction extends SimpleFormController{
	
	protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
		WordForm wordForm=(WordForm) command;
		request.setCharacterEncoding("utf-8");
		Map<String, Object> map = new HashMap<String, Object>();
		Enumeration<String> paramNames = request.getParameterNames();
		// ͨ��ѭ���������������ֵ��ӳ����
		map.put("t11", wordForm.getT11());
		map.put("t12", wordForm.getT12());
		map.put("t13", wordForm.getT13());
		map.put("t14", wordForm.getT14());
		System.out.println(map.get("t11"));
		System.out.println(map.get("t12"));		
		System.out.println(map.get("t13"));		
		System.out.println(map.get("t14"));
		File file = null;
		
		InputStream fin = null;
		ServletOutputStream out = null;
		try {
			// ���ù�����WordGenerator��createDoc��������Word�ĵ�
			file = WordGenerator.createDoc(map, "testword");
			fin = new FileInputStream(file);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			// ��������������صķ�ʽ������ļ�Ĭ����Ϊresume.doc
			response.addHeader("Content-Disposition", "attachment;filename=testword.doc");
			
			out = response.getOutputStream();
			byte[] buffer = new byte[512];	// ������
			int bytesToRead = -1;
			// ͨ��ѭ���������Word�ļ�������������������
			while((bytesToRead = fin.read(buffer)) != -1) {
				out.write(buffer, 0, bytesToRead);
			}
		} finally {
			if(fin != null) fin.close();
			if(out != null) out.close();
			if(file != null) file.delete();	// ɾ����ʱ�ļ�
			map.clear();
		}
		return null;
	}

}
