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
		//擷取表單欄位(國家別)
		String country=request.getParameter("country");
		//透過應用系統物件ServletContext參照出網站系統參考的DataSource
		MysqlDataSource datasource=(MysqlDataSource)this.getServletContext().getAttribute("datasource");
		//建構Dao(自己規劃)查詢 介面多型化
		IDao<MyCustomers> dao=new MyCustomersDao();
		//注入DataSource
		dao.setDataSource(datasource);
		//進行查詢
		try {
			//進行相對國家別客戶查詢
			List<MyCustomers> result=dao.selectForList(country);
			//進入狀態管理(調用View JSP 持續查詢結果)
			request.setAttribute("result",result);
			//派送頁面
			request.getRequestDispatcher("showcountrydata.jsp")
			.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
