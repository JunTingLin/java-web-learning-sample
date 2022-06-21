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
		//耝虫逆
		String country=request.getParameter("country");
		//把酚呼╰参把σDataSource
		MysqlDataSource datasource=(MysqlDataSource)this.getServletContext().getAttribute("datasource");
		//篶Dao琩高
		IDao<MyCustomers> dao=new MyCustomersDao();
		//猔DataSource
		dao.setDataSource(datasource);
		//秈︽琩高
		try {
			List<MyCustomers> result=dao.selectForList(country);
			//秈篈恨瞶
			request.setAttribute("result",result);
			//癳
			request.getRequestDispatcher("showcountrydata.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
