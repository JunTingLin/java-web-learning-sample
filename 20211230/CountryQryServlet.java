package com.gjun.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjun.beans.MyCustomers;
import com.gjun.domain.IDao;
import com.gjun.domain.MyCustomersDao;
import com.mysql.cj.jdbc.MysqlDataSource;


@WebServlet("/CountryQryServlet")
public class CountryQryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryQryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�^��������(��a�O)
		String country=request.getParameter("country");
		//�z�L���Ψt�Ϊ���ServletContext�ѷӥX�����t�ΰѦҪ�DataSource
		MysqlDataSource datasource=(MysqlDataSource)this.getServletContext().getAttribute("datasource");
		//�غcDao(�ۤv�W��)�d�� �����h����
		IDao<MyCustomers> dao=new MyCustomersDao();
		//�`�JDataSource
		dao.setDataSource(datasource);
		//�i��d��
		try {
			//�i��۹��a�O�Ȥ�d��
			List<MyCustomers> result=dao.selectForList(country);
			//�i�J���A�޲z(�ե�View JSP ����d�ߵ��G)
			request.setAttribute("result",result);
			//���e����
			request.getRequestDispatcher("showcountrydata.jsp")
			.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
