package com.gjun.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

//�o�@��Servlet�n��������Ψt�ΦP�ɱҰ�(���ͤ@�ӭ��骫��)
//�L����~����} �i�����Ψt�Φ@�βպA�t�m
public class ApplicationConfigServlet extends HttpServlet{

	//Overrding init method ťServlet���L�Ӫ���l�Ƨ@�~
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		//��l�Ƴ]�w
		System.out.println("Application Cionfig Servlet���L��...");
	}
	
	
}
