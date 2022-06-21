package com.gjun.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.gjun.beans.Users;
import com.gjun.domain.IDao;
import com.gjun.domain.UsersDao;


@WebServlet("/RegisterSaveServlet")
public class RegisterSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�^��������줺�e
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
		//1.�����Ψt�Ϊ��� �nDataSource
		DataSource datasource=
				(DataSource)this.getServletContext().getAttribute("datasource");
		//�Ͳ��@���s��(�s���W��Ʈw) �غc DAO����
		IDao<Users> dao=new UsersDao();
		//�`�JDataSource(�ݩʪ`�J)
		dao.setDataSource(datasource); //DI(Dependency Injection)
		try {
			dao.insert(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//���\�P�_ ���eView���e��(����o�@�ӵ��U��T ��View)
		//�p�G�s�W���\�F ���e�e��(View)
		//�ݭn����@�Ӫ��A(state) �ثe�o�@�ӫʸ˫e�ݪ�����쪺JavaBean���� request scope
		request.setAttribute("users",users);
		//�z�Lrequest���� �ݥXRequestDispatcher ���V�ؼ�(Jsp page)
		RequestDispatcher disp=
				request.getRequestDispatcher("WEB-INF/views/showresult.jsp");
		//���e�L�h
		disp.forward(request, response);
		System.out.println(userName);
	}

}