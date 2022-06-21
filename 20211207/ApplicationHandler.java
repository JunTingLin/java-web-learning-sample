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

	//聽應用系統啟動時 引發的事件
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//1.參照出所聆聽網站應用系統物件
		ServletContext application=sce.getServletContext();
		//透過ServletContext(網站系統) 才會辦法將虛擬目錄轉換成實際目錄 
		String fileName=application.getRealPath("/WEB-INF")+"/app.properties";
		//2.建構一個JavaBean物件 封裝應用系統共用組態(透過Resource file--外掛的 載入封裝)
		AppConfig config=new AppConfig();
		//3載入資源檔(java.io) 反應成實際目錄
		InputStream is;
		try {
			//建立一個串流Stream(具有開啟檔案)
			is = new FileInputStream(fileName);
			//4.建構Properties物件
			Properties pro=new Properties();
			pro.load(is); //注入依賴關係的物件(DI)
			//讀取properites的屬性內容 注入到javabean
			config.setUrl(pro.getProperty("db.url"));
			config.setUserName(pro.getProperty("db.username"));
			config.setPassword(pro.getProperty("db.password"));
			config.setAddress(pro.getProperty("address"));
			config.setCompanyName(pro.getProperty("companyname"));
			//進入Global狀態管理setAttribute("自訂",Object);
			//透過網站應用系統物件去綁定一個物件
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
