package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegisterSave")
public class RegisterServlet extends HttpServlet{

	//配合表單採用傳送方式POST
	//request就是封裝前端所有資訊
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.設定擷取編碼
		request.setCharacterEncoding("UTF-8");
		//回應編碼規則
		response.setContentType("text/html;charset=UTF-8");
		//1 擷取前端表單頁面欄位name=xxxx
		String userName=request.getParameter("username");
		String password=request.getParameter("pwd");
		String realName=request.getParameter("realname");
		String email=request.getParameter("email");
		//進行註冊處理....
		//成功與否 回訊息給前端(View)
		PrintWriter out=response.getWriter();
		out.println("使用者帳號:"+userName);
		
		
	}
	
}
