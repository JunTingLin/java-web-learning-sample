package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//繼承HttpServlet abstract class

public class HelloWorldServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest requqest, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//自己寫與前端瀏覽器的互動 回應開工 打招呼 跟全世界打招呼
		//透過Response物件 去問出Writer
		PrintWriter out=response.getWriter();
		out.println("<font size='7' color='red'>Hello World !!!</font>");
		
		
	}

}
