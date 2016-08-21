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
		// 通过循环将表单参数放入键值对映射中
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
			// 调用工具类WordGenerator的createDoc方法生成Word文档
			file = WordGenerator.createDoc(map, "testword");
			fin = new FileInputStream(file);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			// 设置浏览器以下载的方式处理该文件默认名为resume.doc
			response.addHeader("Content-Disposition", "attachment;filename=testword.doc");
			
			out = response.getOutputStream();
			byte[] buffer = new byte[512];	// 缓冲区
			int bytesToRead = -1;
			// 通过循环将读入的Word文件的内容输出到浏览器中
			while((bytesToRead = fin.read(buffer)) != -1) {
				out.write(buffer, 0, bytesToRead);
			}
		} finally {
			if(fin != null) fin.close();
			if(out != null) out.close();
			if(file != null) file.delete();	// 删除临时文件
			map.clear();
		}
		return null;
	}

}
