package com.gjun.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gjun.beans.Users;
import com.gjun.domain.IDao;
import com.gjun.domain.UsersDao;
import com.mysql.cj.jdbc.MysqlDataSource;


@WebServlet("/LoginValidServlet")
public class LoginValidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginValidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���o������
		String message=null;
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		//�i��|����ƪ�����
		//1.�z�L���A�޲z ���Ψt�κ޲z��DataSource����
		MysqlDataSource datasource=(MysqlDataSource)
				this.getServletContext().getAttribute("datasource");
		//2.�غcDAO�i��|����Ƭd��
		IDao<Users> dao=new UsersDao();
		//�`�JDataSource����
		dao.setDataSource(datasource);
		//�i��|������
		try {
			boolean r=dao.selectForObject(userName, password);
			if(r) {
				//�n�J���Ҧ��\
				System.out.println("���Ҧ��\");
				//�o�X����(Cookie)
				Cookie cookie=new Cookie("cred",userName); //���� �S���p�K�ʸ��
				//Domain �w�]�ĥΥثe�����t��
				cookie.setPath("acct"); //�ڥؿ��U/�]�Ȩt�κ��즳��
				// �`�N:"/"���Υ[
				//��Response�Ѧҳo�@�ӭn�a�U�h��Cookie
				response.addCookie(cookie);
				
				//�i�檬�A�޲z �t�X�e���s����(Session)
				//�ϥ�HttpServletRequest�ݥX�۹諸Session(�J�������J���� �S���N���ͤ@�ӷs��)
				HttpSession session=request.getSession(); //�p�Prequest.getSession(true);
				//request.getSession(false); //�u���X�J����Session �S���N�S��
				session.setAttribute("cred",userName);
				message=String.format("%s ���ҳq�L�F",userName);
				
			}else {
				System.out.println("���ҥ���");
				message=String.format("%s �n�J����!!!",userName);
			}
			//���ͪ��A �����e���h
			request.setAttribute("message",message);
			
			//���e�e�� request���Xproxy�N�z�H 
			RequestDispatcher disp=request.getRequestDispatcher("showlogin.jsp");
			disp.forward(request, response);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
