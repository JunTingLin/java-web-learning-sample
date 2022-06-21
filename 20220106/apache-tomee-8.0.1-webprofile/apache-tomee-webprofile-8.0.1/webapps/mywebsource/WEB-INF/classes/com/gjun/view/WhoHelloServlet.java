package com.gjun.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//繼承HttpServlet
//不動DD File 直接使用Annotation進行佈署與描述(Web 3.0)
//沒有指定內部的name 預設就是使用了類別名稱
@WebServlet("/twhello")
public class WhoHelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//一來一回的編碼Encoding 
		request.setCharacterEncoding("UTF-8");
		//MIME Type(Media Type) 
		//response.setContentType("text/plain;charset=UTF-8"); //前端將內容當作純文字
		response.setContentType("text/html;charset=UTF-8"); //當網頁閱讀
		//取出前端採用Query String參數架構(Http URL) 內容 http://hosted/web/xxxx/xxxx?who=value
		String who=request.getParameter("who");
		//重新整理字串
		String msg=String.format("<font size='7' color='red'>%s Hello World!!</font>",who);
		//處理之後再回應
		response.getWriter().println(msg);
	}
	
}
