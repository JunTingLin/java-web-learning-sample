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
		//�ݥX�������Ψt��ServletContext
		//�]�i�z�Lrequest.getServletContext()���o  
		ServletContext application=this.getServletContext();
		String contextPath=application.getContextPath(); //�ݺ������Ψt��/myweb
		System.out.println("context path:"+contextPath); //�ݥX/myweb �����W��
		String uri=request.getRequestURI();
		System.out.println("Host name:"+uri);
	}

}
