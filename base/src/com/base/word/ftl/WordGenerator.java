package com.base.word.ftl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class WordGenerator {
	private Configuration configuration = null;
	private Map<String, Template> allTemplates = null;
	


	public WordGenerator(String ftlname) {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(WordGenerator.class, "/com/base/word/ftl");
		allTemplates = new HashMap<>();	// Java 7 ��ʯ�﷨
		try {
			allTemplates.put("testword", configuration.getTemplate("testword.ftl"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}


	public File createDoc(Map<?, ?> dataMap, String type) {
		String name = "temp" + (int) (Math.random() * 100000) + ".doc";
		File f = new File(name);
		Template t = allTemplates.get(type);
		try {
			// ����ط�����ʹ��FileWriter��Ϊ��Ҫָ���������ͷ������ɵ�Word�ĵ�����Ϊ���޷�ʶ��ı�����޷���
			Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
			t.process(dataMap, w);
			w.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return f;
	}

}
