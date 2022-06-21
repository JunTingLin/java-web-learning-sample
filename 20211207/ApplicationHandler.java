package com.gjun.listener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.gjun.entity.AppConfig;

//���Ψt�κ޲z�� �i���ť���Ψt�αҰʩΪ̰��� �޵o�ƥ�{��
public class ApplicationHandler implements ServletContextListener {

	//ť���Ψt�αҰʮ� �޵o���ƥ�
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//1.�ѷӥX�Ҳ�ť�������Ψt�Ϊ���
		ServletContext application=sce.getServletContext();
		//�z�LServletContext(�����t��) �~�|��k�N�����ؿ��ഫ����ڥؿ� 
		String fileName=application.getRealPath("/WEB-INF")+"/app.properties";
		//2.�غc�@��JavaBean���� �ʸ����Ψt�Φ@�βպA(�z�LResource file--�~���� ���J�ʸ�)
		AppConfig config=new AppConfig();
		//3���J�귽��(java.io) ��������ڥؿ�
		InputStream is;
		try {
			//�إߤ@�Ӧ�yStream(�㦳�}���ɮ�)
			is = new FileInputStream(fileName);
			//4.�غcProperties����
			Properties pro=new Properties();
			pro.load(is); //�`�J�̿����Y������(DI)
			//Ū��properites���ݩʤ��e �`�J��javabean
			config.setUrl(pro.getProperty("db.url"));
			config.setUserName(pro.getProperty("db.username"));
			config.setPassword(pro.getProperty("db.password"));
			config.setAddress(pro.getProperty("address"));
			config.setCompanyName(pro.getProperty("companyname"));
			//�i�JGlobal���A�޲zsetAttribute("�ۭq",Object);
			//�z�L�������Ψt�Ϊ���h�j�w�@�Ӫ���
			application.setAttribute("config", config);
			
			System.out.println("���Ψt�β�ť�� ���L�ӤF");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
