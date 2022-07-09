package com.gjun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjun.beans.Users;


@WebServlet("/RegisterSaveServlet")
public class RegisterSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�^�������줺�e
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String realName=request.getParameter("realname");
		String email=request.getParameter("email");
		//�ʸ˦��@��JavaBean(Model) ����(�z�L ��Ʀs���ۭqModel �i���ƺ��@)
		Users users=new Users();
		users.setUserName(userName);
		users.setPassword(password);
		users.setRealName(realName);
		users.setEmail(email);
		
		//�I�s��Ʒs�W�Ҳ�(Model)
		// ���\�P�_ ���eView���e��(����o�@�ӵ��U��T ��View) 
		//���M���p�A��10���ݩʡA�N�n����o10�Ө�view�h�A�|�ܳ·�
		//�p�G�s�W���\�F ���e�e��(View)
		//�ݭn����@�Ӫ��A(state) �ثe�o�@�ӫʸ˫e�ݪ����쪺JavaBean���� request scope

		//�i�Ѧ����Ψt�β�ť��ApplicationHandler��application.setAttribute�A���o����[�@��
		//�o��request�����A�ڪ�users javaBean�N����
		request.setAttribute("users",users);
		//�z�Lrequest���� �ݥXRequestDispatcher ���V�ؼ�(Jsp page)
		RequestDispatcher disp=
				request.getRequestDispatcher("WEB-INF/views/showresult.jsp");
		//���e�L�h
		disp.forward(request, response);
		System.out.println(userName);
	}

}
