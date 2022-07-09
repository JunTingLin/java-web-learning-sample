package com.gjun.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gjun.beans.Users;
import com.gjun.domain.IDao;
import com.gjun.domain.UsersDao;
import com.mysql.cj.jdbc.MysqlDataSource;


@WebServlet("/LoginValidServlet")
public class LoginValidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginValidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取得表單欄位
		String message=null;
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		//進行會員資料表驗證
		//1.透過狀態管理 應用系統管理的DataSource物件
		MysqlDataSource datasource=(MysqlDataSource)
				this.getServletContext().getAttribute("datasource");
		//2.建構DAO進行會員資料查詢
		IDao<Users> dao=new UsersDao();
		//注入DataSource物件
		dao.setDataSource(datasource);
		//進行會員驗證
		try {
			boolean r=dao.selectForObject(userName, password);
			if(r) {
				//登入驗證成功
				System.out.println("驗證成功");
				//發出憑證(Cookie)
				Cookie cookie=new Cookie("cred",userName); //明文 沒有私密性資料
				//Domain 預設採用目前網站系統
				cookie.setPath("acct"); //根目錄下/財務系統網域有效
				// 注意:"/"不用加
				//讓Response參考這一個要帶下去的Cookie
				response.addCookie(cookie);
				
				//進行狀態管理 配合前端瀏覽器(Session)
				//使用HttpServletRequest問出相對的Session(既有的取既有的 沒有就產生一個新的)
				HttpSession session=request.getSession(); //如同request.getSession(true);
				//request.getSession(false); //只取出既有的Session 沒有就沒有
				session.setAttribute("cred",userName);
				message=String.format("%s 驗證通過了",userName);
				
			}else {
				System.out.println("驗證失敗");
				message=String.format("%s 登入失敗!!!",userName);
			}
			//產生狀態 持續到畫面去
			request.setAttribute("message",message);
			
			//派送畫面 request取出proxy代理人 
			RequestDispatcher disp=request.getRequestDispatcher("showlogin.jsp");
			disp.forward(request, response);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
