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

//應用系統管理員 進行聆聽應用系統啟動或者停止 引發事件程序
public class ApplicationHandler implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//1.參照出所聆聽網站應用系統物件
		ServletContext application=sce.getServletContext();
		String fileName=application.getRealPath("/WEB-INF")+"/app.properties";
		//2.建構一個JavaBean物件 封裝應用系統共用組態(透過Resource file--外掛的 載入封裝)
		AppConfig config=new AppConfig();
		//3載入資源檔(io) 反應成實際目錄
		InputStream is;
		try {
			is = new FileInputStream(fileName);
			//4.建構Properties物件
			Properties pro=new Properties();
			pro.load(is);
			//讀取properites的屬性內容 注入到javabean
			config.setUrl(pro.getProperty("db.url"));
			config.setUserName(pro.getProperty("db.username"));
			config.setPassword(pro.getProperty("db.password"));
			config.setAddress(pro.getProperty("address"));
			config.setCompanyName(pro.getProperty("companyname"));
			//進入Global狀態管理setAttribute("自訂",Object);
			application.setAttribute("config", config);
			
			System.out.println("應用系統聆聽器 活過來了");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
