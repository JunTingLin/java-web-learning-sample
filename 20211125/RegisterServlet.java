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

	//�t�X���ĥζǰe�覡POST
	//request�N�O�ʸ˫e�ݩҦ���T
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.�]�w�^���s�X
		request.setCharacterEncoding("UTF-8");
		//�^���s�X�W�h
		response.setContentType("text/html;charset=UTF-8");
		//1 �^���e�ݪ�歶�����name=xxxx
		String userName=request.getParameter("username");
		String password=request.getParameter("pwd");
		String realName=request.getParameter("realname");
		String email=request.getParameter("email");
		//�i����U�B�z....
		//���\�P�_ �^�T�����e��(View)
		PrintWriter out=response.getWriter();
		out.println("�ϥΪ̱b��:"+userName);
		
		
	}
	
}
