package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�ϥ�annotation�i��е� �G�p�P�y�z(�i�JServlet 3.0��)
@WebServlet(urlPatterns={"/customersqry","/cust"},loadOnStartup=2) //�S���]�wservlet-name �w�]�ĥ�Class Name
// ��Ӧ�m���V�P�@��Servlet
// loadOnStartup=2 ��ܦbServlet�e���ҰʮɡA�N�Ұʦ�Servlet
public class CustomersQryServlet extends HttpServlet {

	//�ĥ�URL�ǻ��ѼƤ��e(�z�L�s����������J �Ϊ̺����W�s�����L��)
		//POST or GET or.....??? �ĥ�Http Request Method-GET
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�^���s�X�W�h
		response.setContentType("text/html;charset=UTF-8");
		//���XWriter 
		PrintWriter out=response.getWriter();
		out.println("<font size='7' color='red'>�z�n</font>");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Customers Servlet���L��!!!");
	}
	
	
	
	
}
