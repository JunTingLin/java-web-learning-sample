package com.gjun.domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;


import com.mysql.cj.jdbc.MysqlDataSource;

public class AppDBUtility {
	//static method(非物件化)
	// 有可能有多個資源檔properties file或是要替換資源檔，所以這裡設計一個String config傳參
	public static void createDataSource(ServletContext application,String config) {
		MysqlDataSource datasource=new MysqlDataSource();
		System.out.println("DataSource建立了..."+datasource);
		//透過ServletContext配合虛擬目錄轉換成實際目錄
		String realPath=application.getRealPath("/WEB-INF")+"/"+config;
		//建構Properties物件來載入
		Properties properites=new Properties();
		try {
			properites.load(new FileInputStream(realPath));
			//配置DataSource
			//採用Input 讀取到資源檔(xxx.properties) 面對實紀錄目錄與檔案
			datasource.setUrl(properites.getProperty("db.url"));
			datasource.setUser(properites.getProperty("db.username"));
			datasource.setPassword(properites.getProperty("db.password"));
			//透過應用系統物件進行管理
			application.setAttribute("datasource",datasource);
			System.out.println("DataSource建立了..."+datasource);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("DataSource建立錯誤..."+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("DataSource建立錯誤..."+e.getMessage());
		}
		
		
	}

}
