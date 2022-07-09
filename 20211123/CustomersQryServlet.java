package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//使用annotation進行標註 佈署與描述(進入Servlet 3.0版)
@WebServlet(urlPatterns={"/customersqry","/cust"},loadOnStartup=2) //沒有設定servlet-name 預設採用Class Name
// 兩個位置指向同一個Servlet
// loadOnStartup=2 表示在Servlet容器啟動時，就啟動此Servlet
public class CustomersQryServlet extends HttpServlet {

	//採用URL傳遞參數內容(透過瀏覽器直接輸入 或者網頁超連結指過來)
		//POST or GET or.....??? 採用Http Request Method-GET
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//回應編碼規則
		response.setContentType("text/html;charset=UTF-8");
		//取出Writer 
		PrintWriter out=response.getWriter();
		out.println("<font size='7' color='red'>您好</font>");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Customers Servlet活過來!!!");
	}
	
	
	
	
}
