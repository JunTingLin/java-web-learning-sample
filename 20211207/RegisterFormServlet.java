package com.gjun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��~�ӽШD �i����U�@�ӱ�� �����z�L�W�s���L�� �䴩Http Request GET
@WebServlet("/regform")
public class RegisterFormServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�p��i��ե�(���e)��@�Ӥ����w�����U������
		//�p��������s�����i���ͪ�request and response
		//1.�z�LServletRequest���X�@�ӭt�d���e���N�z(Request)������
		RequestDispatcher disp=
				request.getRequestDispatcher("WEB-INF/views/usersform.jsp");
		//���S���B�~�B�z
		//���e(��������Request�PResponse����)�A��include��forward
		disp.forward(request, response); //�᭱�����B�z�A�����v�浹jsp����
		
		
	}
	
}
