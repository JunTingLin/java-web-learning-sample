package com.gjun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//對外來請求 進行註冊一個控制器 往往透過超連結過來 支援Http Request GET
@WebServlet("/regform")
public class RegisterFormServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//如何進行調用(派送)到一個內部安全夾下的頁面
		//如何持續原先瀏覽器進行交談的request and response
		//1.透過ServletRequest取出一個負責派送的代理(Request)的物件
		RequestDispatcher disp=
				request.getRequestDispatcher("WEB-INF/views/usersform.jsp");
		//有沒有額外處理
		//派送(持續原先的Request與Response物件)，有include跟forward
		disp.forward(request, response); //後面的不處理，控制權交給jsp頁面
		
		
	}
	
}
