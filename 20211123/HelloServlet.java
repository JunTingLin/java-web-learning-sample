package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�~�ӬO�@��Http��w�U���@�Ӥ���(Adapter Pattern) ��H���O
public class HelloServlet extends HttpServlet{

	//Overriding service() Servlet API�̷��Y ���ޫe�ݭ��@�ضǰe�覡���n�g�L�o��
	//�o��ӰѼƭ��Ǧn �g�Ѻ����������ͪ���ǻ��i��
	//������e�ݱĥέ��@�ضǰe��k
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//�]�w�^�����e�ݮɪ��s�X Header Content-Type ���W�d�� �٩I��MIME Type
		//response.setContentType("text/html;charset=UTF-8");
		response.setContentType("text/plain;charset=UTF-8");
		//�z�L�^������ �ݥXWriter �i�H�g�X��r��
		PrintWriter out=response.getWriter();
		//�g�X�@�Ӥ�r���e�ݥh
		out.println("<font size='5' color='red'>Hello World �z�n!!!</font>");
		
	}

	//��ťServlet�ͩR�g�� ���L�Ӫ��I
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Hello Servlet���L�ӤF....");
	}
	
	
	
}
