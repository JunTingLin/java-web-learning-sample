package com.gjun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjun.beans.Users;


@WebServlet("/RegisterSaveServlet")
public class RegisterSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//擷取表單欄位內容
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String realName=request.getParameter("realname");
		String email=request.getParameter("email");
		//封裝成一個JavaBean(Model) 物件(透過 資料存取自訂Model 進行資料維護)
		Users users=new Users();
		users.setUserName(userName);
		users.setPassword(password);
		users.setRealName(realName);
		users.setEmail(email);
		
		//呼叫資料新增模組(Model)
		// 成功與否 派送View給前端(持續這一個註冊資訊 到View) 
		//不然假如你有10個屬性，就要持續這10個到view去，會很麻煩
		//如果新增成功了 派送畫面(View)
		//需要持續一個狀態(state) 目前這一個封裝前端表單欄位的JavaBean物件 request scope

		//可參考應用系統聆聽器ApplicationHandler裡application.setAttribute，活得比較久共用
		//這裡request死掉，我的users javaBean就釋放
		request.setAttribute("users",users);
		//透過request物件 問出RequestDispatcher 指向目標(Jsp page)
		RequestDispatcher disp=
				request.getRequestDispatcher("WEB-INF/views/showresult.jsp");
		//派送過去
		disp.forward(request, response);
		System.out.println(userName);
	}

}
