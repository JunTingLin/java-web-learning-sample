package com.gjun.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.gjun.entity.AppConfig;

//�o�@��Servlet�n��������Ψt�ΦP�ɱҰ�(���ͤ@�ӭ��骫��)
//�L����~����} �i�����Ψt�Φ@�βպA�t�m
public class ApplicationConfigServlet extends HttpServlet{

	//Overrding init method ťServlet���L�Ӫ���l�Ƨ@�~
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//��l�Ƴ]�w--���Ψt�μh�Ū���l��(���Ψt�Φ@��)---ServletContext
		//�ݥXServletContext
		ServletContext application=this.getServletContext();
		String fileName=application.getRealPath("/WEB-INF")+"/app.properties";
		//2.�غc�@��JavaBean���� �ʸ����Ψt�Φ@�βպA(�z�LResource file--�~���� ���J�ʸ�)
		AppConfig config=new AppConfig();
		//3���J�귽��(io) ��������ڥؿ�
		InputStream is;
		try {
			is = new FileInputStream(fileName);
			//4.�غcProperties����
			Properties pro=new Properties();
			pro.load(is);
			//Ū��properites���ݩʤ��e �`�J��javabean
			config.setUrl(pro.getProperty("db.url"));
			config.setUserName(pro.getProperty("db.username"));
			config.setPassword(pro.getProperty("db.password"));
			config.setAddress(pro.getProperty("address"));
			config.setCompanyName(pro.getProperty("companyname"));
			//�i�JGlobal���A�޲z
			application.setAttribute("config", config);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//config.setUrl();
		System.out.println("Application Cionfig Servlet���L��...");
		System.out.println("�귽�ɥؿ�:"+fileName);
		System.out.println("���Ψt�ΰѦҪ���:"+((AppConfig)application.getAttribute("config")).getCompanyName());
	}
	
	
}
