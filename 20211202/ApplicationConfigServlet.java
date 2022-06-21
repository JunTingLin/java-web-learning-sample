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

//這一個Servlet要跟網站應用系統同時啟動(產生一個個體物件)
//無須對外的位址 進行應用系統共用組態配置
public class ApplicationConfigServlet extends HttpServlet{

	//Overrding init method 聽Servlet活過來的初始化作業
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//初始化設定--應用系統層級的初始化(應用系統共用)---ServletContext
		//問出ServletContext
		ServletContext application=this.getServletContext();
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
			//進入Global狀態管理
			application.setAttribute("config", config);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//config.setUrl();
		System.out.println("Application Cionfig Servlet活過來...");
		System.out.println("資源檔目錄:"+fileName);
		System.out.println("應用系統參考物件:"+((AppConfig)application.getAttribute("config")).getCompanyName());
	}
	
	
}
