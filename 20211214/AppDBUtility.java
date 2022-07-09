package com.gjun.domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;


import com.mysql.cj.jdbc.MysqlDataSource;

public class AppDBUtility {
	//static method(�D�����)
	// ���i�঳�h�Ӹ귽��properties file�άO�n�����귽�ɡA�ҥH�o�̳]�p�@��String config�ǰ�
	public static void createDataSource(ServletContext application,String config) {
		MysqlDataSource datasource=new MysqlDataSource();
		System.out.println("DataSource�إߤF..."+datasource);
		//�z�LServletContext�t�X�����ؿ��ഫ����ڥؿ�
		String realPath=application.getRealPath("/WEB-INF")+"/"+config;
		//�غcProperties����Ӹ��J
		Properties properites=new Properties();
		try {
			properites.load(new FileInputStream(realPath));
			//�t�mDataSource
			//�ĥ�Input Ū����귽��(xxx.properties) ���������ؿ��P�ɮ�
			datasource.setUrl(properites.getProperty("db.url"));
			datasource.setUser(properites.getProperty("db.username"));
			datasource.setPassword(properites.getProperty("db.password"));
			//�z�L���Ψt�Ϊ���i��޲z
			application.setAttribute("datasource",datasource);
			System.out.println("DataSource�إߤF..."+datasource);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("DataSource�إ߿��~..."+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("DataSource�إ߿��~..."+e.getMessage());
		}
		
		
	}

}
