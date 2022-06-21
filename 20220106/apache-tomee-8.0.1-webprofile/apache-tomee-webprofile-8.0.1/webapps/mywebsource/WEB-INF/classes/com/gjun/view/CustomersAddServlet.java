package com.gjun.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjun.entity.CustomersBean;

//Servlet變成控制流程的控制器(流程與呼叫Model相關處理)
@WebServlet("/CustomersAddServlet")
public class CustomersAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//擷取表單欄位對應中文編碼
		request.setCharacterEncoding("UTF-8");
		
		//如何擷取表單欄位內容
		String customerid=request.getParameter("customerid"); //參數就是表單欄位名稱name=xxxx
		String companyname=request.getParameter("companyname");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		//將參數內容封裝成一個JavaBean(實體物件)
		CustomersBean customers=new CustomersBean();
		//屬性注入Property Injection
		customers.setCustomerId(customerid);
		customers.setCompanyName(companyname);
		customers.setAddress(address);
		customers.setPhone(phone);
		
		//開始處理好了(新增資料庫紀錄)
		
		//調用畫面(Servlet-> JSP去)前端 說完成新增作業
		//1.使用request 參照這一個JavaBean
		request.setAttribute("customers", customers); //物件是參考性別 只能傳遞參考的位址		
		//調用頁面 同時延伸目前的request and response物件--RequestDispatcher
		RequestDispatcher disp=request.getRequestDispatcher("showcust.jsp");
		//調用頁面執行 要傳遞request and response兩個物件
		disp.forward(request, response);
		//後面不寫 寫了也不會執行
		response.getWriter().println("hello");
		
	}

}
