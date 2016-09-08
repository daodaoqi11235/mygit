package com.expert.intermediateinspection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



import com.hibernate.beans.Coverofintermediateinspection;
import com.hibernate.beans.Intermediateinspection;
import com.hibernate.beans.Intermediateinspectioninfo;
import com.wordgenerator.WordGenerator;

public class CommitmiddleDownloadAction implements Controller{

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
	IntermediateinspectioninfoDAO iiiDAO;

	public IntermediateinspectioninfoDAO getIiiDAO() {
		return iiiDAO;
	}
	public void setIiiDAO(IntermediateinspectioninfoDAO iiiDAO) {
		this.iiiDAO = iiiDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {

		Coverofintermediateinspection coii=coiiDAO.getCover(1);//此处以后写好了改一下输入参数,参数是中期检查表的主键

		Intermediateinspectioninfo iii=iiiDAO.getiii(1);//此处以后写好了改一下输入参数,参数是中期检查表的主键
		
		Intermediateinspection ii=intermediateinspectionDAO.getIntermediateinspection(1);//此处以后写好了改一下输入参数,参数是中期检查表的主键
		
		arg0.setCharacterEncoding("utf-8");
		Map<String, Object> map = new HashMap<String, Object>();

		// 通过循环将表单参数放入键值对映射中
		map.put("N1",coii.getN1());
		map.put("N2",coii.getN2());
		map.put("N3",coii.getN3());
		map.put("N4",coii.getN4());
		map.put("N5",coii.getN5());
		map.put("N6",coii.getN6());
		map.put("N7",coii.getN7());
		map.put("N8",coii.getN8());

		map.put("O1",iii.getO1());
		map.put("O2",iii.getO2());
		map.put("O3",iii.getO3());
		map.put("O4",iii.getO4());
		map.put("O5",iii.getO5());
		map.put("O6",iii.getO6());
		map.put("O7",iii.getO7());
		map.put("O8",iii.getO8());
		map.put("O9",iii.getO9());
		map.put("O10",iii.getO10());
		map.put("O11",iii.getO11());
		map.put("O12",iii.getO12());
		map.put("O13",iii.getO13());
		map.put("O14",iii.getO14());
		map.put("O15",iii.getO15());
		map.put("O16",iii.getO16());
		map.put("O17",iii.getO17());
		map.put("O18",iii.getO18());
		map.put("O19",iii.getO19());
		map.put("O20",iii.getO20());
		map.put("O21",iii.getO21());
		map.put("O22",iii.getO22());
		map.put("O23",iii.getO23());
		map.put("O24",iii.getO24());
		map.put("O25",iii.getO25());
		map.put("O26",iii.getO26());
		map.put("O27",iii.getO27());
		map.put("O28",iii.getO28());
		map.put("O29",iii.getO29());
		map.put("O30",iii.getO30());
		map.put("O31",iii.getO31());
		map.put("O32",iii.getO32());
		map.put("O33",iii.getO33());
		map.put("O34",iii.getO34());
		map.put("O35",iii.getO35());
		map.put("O36",iii.getO36());
		map.put("O37",iii.getO37());
		map.put("O38",iii.getO38());
		map.put("O39",iii.getO39());
		map.put("O40",iii.getO40());
		map.put("O41",iii.getO41());
		map.put("O42",iii.getO42());
		map.put("O43",iii.getO43());
		map.put("O44",iii.getO44());
		map.put("O45",iii.getO45());
		map.put("O46",iii.getO46());
		map.put("O47",iii.getO47());
		map.put("O48",iii.getO48());
		map.put("O49",iii.getO49());
		
		map.put("P1",ii.getP1());
		map.put("P2",ii.getP2());
		map.put("P3",ii.getP3());
		map.put("P4",ii.getP4());
		map.put("P5",ii.getP5());
		map.put("P6",ii.getP6());
		map.put("P7",ii.getP7());
		map.put("P8",ii.getP8());
		map.put("P9",ii.getP9());

		File file = null;
		
		InputStream fin = null;
		ServletOutputStream out = null;
		try {
			// 调用工具类WordGenerator的createDoc方法生成Word文档
			WordGenerator wg=new WordGenerator("commitmiddle");

			file = wg.createDoc(map, "commitmiddle");
			fin = new FileInputStream(file);
			
			arg1.setCharacterEncoding("utf-8");
			arg1.setContentType("application/msword");
			// 设置浏览器以下载的方式处理该文件默认名为resume.doc
			arg1.addHeader("Content-Disposition", "attachment;filename=download.doc");
			
			out = arg1.getOutputStream();
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
