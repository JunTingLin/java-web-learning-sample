package com.gjun.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.gjun.beans.Users;
import com.gjun.domain.IDao;
import com.gjun.domain.UsersDao;


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
		//1.跟應用系統物件 要DataSource
		DataSource datasource=
				(DataSource)this.getServletContext().getAttribute("datasource");
		//生產一條連接(連接上資料庫) 建構 DAO物件
		IDao<Users> dao=new UsersDao();
		//注入DataSource(屬性注入)
		dao.setDataSource(datasource); //DI(Dependency Injection)
		try {
			dao.insert(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//成功與否 派送View給前端(持續這一個註冊資訊 到View)
		//如果新增成功了 派送畫面(View)
		//需要持續一個狀態(state) 目前這一個封裝前端表單欄位的JavaBean物件 request scope
		request.setAttribute("users",users);
		//透過request物件 問出RequestDispatcher 指向目標(Jsp page)
		RequestDispatcher disp=
				request.getRequestDispatcher("WEB-INF/views/showresult.jsp");
		//派送過去
		disp.forward(request, response);
		System.out.println(userName);
	}

}
