package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjun.entity.CustomersBean;



/**
 * Servlet implementation class SQLServerServlet
 */
@WebServlet("/SQLServerServlet")
public class SQLServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SQLServerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		//取出Writer
		PrintWriter out=response.getWriter();
		
		
		try {
			//1.載入開路連接資料庫伺服器SQL Server驅動類別
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Checked Exception
			//透過DriverManager配合相關要件(url 連接字串/user name/password) 開啟一條連接
			String url="jdbc:sqlserver://localhost:1433;databaseName=NORTHWND;"
					+ "user=sa;password=1111";
			//介面多型化(只要是實作這一個介面的物件 均可進行參考)
			Connection connection=DriverManager.getConnection(url);
			//判斷是否連接開啟
			if(!connection.isClosed()) {
				out.println("開啟一條連接");
				//進行資料維護.... 找一個物件 稱呼為Statement物件
				//透過連接物件產生一個命令物件
				Statement st=connection.createStatement();
				//帶命令 執行命令採用SPT(SQL Pass Through)
				ResultSet rs=st.executeQuery("Select CustomerID,CompanyName,Address"
						+ ",Country,Phone From Customers");
				//建構Generic集合物件 動態收集一筆一筆模組物件
				List<CustomersBean> data=new ArrayList<CustomersBean>();
				//逐筆讀取Fetching Cursor
				while(rs.next())
				{
					//擷取相對記錄回來....放在緩存區架構(採用物件模組)
					//建構CustomersBean物件封裝相對記錄欄位
					CustomersBean entity=new CustomersBean();
					//透過ResultSet取相對記錄的欄位 透過setXxx() 屬性注入到物件去
					entity.setCustomerId(rs.getString("CustomerID"));
					entity.setCompanyName(rs.getString("CompanyName"));
					
					entity.setPhone(rs.getString("Phone"));
					entity.setAddress(rs.getString("Address"));
					entity.setCountry(rs.getString("Country"));
					data.add(entity); //透過集合物件參考這一個Entity(JavaBean)物件
				}
				//處理好了
				out.println(data.size());
				//狀態管理state Manager(層面四層 使用Request)
				request.setAttribute("data",data);
				connection.close();
				//調用畫面JSP Page持續最後集合物件結果 到Page呈現
				//1.透過request去找一個代理人 可以派送 RequestDispatcher介面
				RequestDispatcher disp=request.getRequestDispatcher("showcustomers.jsp");
				//控制整個到頁面去
				disp.forward(request, response);
				return;
			}

		} catch (ClassNotFoundException e) {
			out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
		}
	}

}
