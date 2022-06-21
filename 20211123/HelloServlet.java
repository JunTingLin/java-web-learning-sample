package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//繼承是一個Http協定下的一個公版(Adapter Pattern) 抽象類別
public class HelloServlet extends HttpServlet{

	//Overriding service() Servlet API最源頭 不管前端哪一種傳送方式都要經過這裡
	//這兩個參數哥倆好 經由網站引擎產生物件傳遞進來
	//不限制前端採用哪一種傳送方法
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//設定回應給前端時的編碼 Header Content-Type 有規範的 稱呼為MIME Type
		//response.setContentType("text/html;charset=UTF-8");
		response.setContentType("text/plain;charset=UTF-8");
		//透過回應物件 問出Writer 可以寫出文字串
		PrintWriter out=response.getWriter();
		//寫出一個文字串到前端去
		out.println("<font size='5' color='red'>Hello World 您好!!!</font>");
		
	}

	//聆聽Servlet生命週期 活過來的點
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Hello Servlet活過來了....");
	}
	
	
	
}
