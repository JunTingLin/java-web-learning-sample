package com.gjun.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

//這一個Servlet要跟網站應用系統同時啟動(產生一個個體物件)
//無須對外的位址 進行應用系統共用組態配置
public class ApplicationConfigServlet extends HttpServlet{

	//Overrding init method 聽Servlet活過來的初始化作業
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		//初始化設定
		System.out.println("Application Cionfig Servlet活過來...");
	}
	
	
}
