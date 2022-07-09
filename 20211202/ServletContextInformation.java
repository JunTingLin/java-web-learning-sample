package com.gjun.view;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextInformation
 */
@WebServlet("/ServletContextInformation")
public class ServletContextInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContextInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//問出網站應用系統ServletContext
		//也可透過request.getServletContext()取得  
		ServletContext application=this.getServletContext();
		String contextPath=application.getContextPath(); //問網站應用系統/myweb
		System.out.println("context path:"+contextPath); //問出/myweb 網站名稱
		String uri=request.getRequestURI();
		System.out.println("Host name:"+uri);
	}

}
