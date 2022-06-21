package com.gjun.view;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gjun.entity.CustomersBean;
import com.gjun.entity.Message;
import com.google.gson.Gson;

/**
 * Servlet implementation class JsonCustomersServlet
 */
@WebServlet("/JsonCustomersServlet")
public class JsonCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//蓋一間工廠物件
	private ApplicationContext factory=
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonCustomersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//如何取出Json文件(前端採用包在Body中的)
		//採用底層IO 讀取器 讀取bytes to String
		//擷取與回應編碼 設定Header Content-Type:application/json
		response.setContentType("application/json;charset=UTF-8");
		
		ServletInputStream stream=request.getInputStream();
		//建構一個StreamReader 讀取字元
		java.io.InputStreamReader reader=new InputStreamReader(stream,"UTF-8");
		int length=-1;
		//建構一個整個字元累積緩存物件
		StringBuilder builder=new StringBuilder();
		//設定一步緩存區 字元陣列
		char[] step=new char[20];
		while((length=reader.read(step))>-1) {
			//是有讀到內容
			builder.append(step,0,length);
		}
		//整個吐出來 完整字串
		String jsonString=builder.toString();
		//借助Gson物件進行反序列化(Json String to CustomersBean物件)
		Gson gson=new Gson();
		//反序列化
		//CustomersBean.class 取得Class物件中繼資料在記憶體中 配合字串封裝成物件
		CustomersBean customers=gson.fromJson(jsonString,CustomersBean.class);
		
		//DataSource就是一個產生連接 工廠
		//進行連接集區效能調教機制
		//1.建構一個DataSource物件(javax.sql.Datasource 介面)
		BasicDataSource datasource=new BasicDataSource(); 
		//連上上資料庫有幾個要件(url-連接字串描述/database?/user?/password?)
		//屬性注入Property Injection(setXxxx())
		datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//設定url
		datasource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=NORTHWND");
		datasource.setUsername("sa");
		datasource.setPassword("1111");
		//跟工廠要一條連接(具有開啟作用的)
		String msg=null;
//		try {
//			//介面多型化
//			Connection connection=datasource.getConnection(); //去要一條新的連接物件出來(具有開啟)
//			if(!connection.isClosed()) {
//				msg="資料庫連接成功";
//				//關閉連接 是將連接收回集區..再重新分派
//			}
			//建構可以存取資料表的DAO物件(spring JdbcTemplate)
			JdbcTemplate dao=new JdbcTemplate();
			//透過Property Injection注入連接工廠 DataSource(Dependency Injection-DI)
			dao.setDataSource(datasource);
			//窗口交給dao(JdbcTemplate) 進行新增作業
			int affect=dao.update("insert into Customers(CustomerID,CompanyName,Address,Phone,Country) values(?,?,?,?,?)",
					customers.getCustomerId(),
					customers.getCompanyName(),
					customers.getAddress(),customers.getPhone(),customers.getCountry());
			msg="資料新增成功";
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			msg=e.getMessage();
//		}
		
		response.getWriter().println(msg);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//如何取出Json文件(前端採用包在Body中的)
				//採用底層IO 讀取器 讀取bytes to String
				//擷取與回應編碼 設定Header Content-Type:application/json
				response.setContentType("application/json;charset=UTF-8");
				
				ServletInputStream stream=request.getInputStream();
				//建構一個StreamReader 讀取字元
				java.io.InputStreamReader reader=new InputStreamReader(stream,"UTF-8");
				int length=-1;
				//建構一個整個字元累積緩存物件
				StringBuilder builder=new StringBuilder();
				//設定一步緩存區 字元陣列
				char[] step=new char[20];
				while((length=reader.read(step))>-1) {
					//是有讀到內容
					builder.append(step,0,length);
				}
				//整個吐出來 完整字串
				String jsonString=builder.toString();
				//借助Gson物件進行反序列化(Json String to CustomersBean物件)
				Gson gson=new Gson();
				//反序列化
				//CustomersBean.class 取得Class物件中繼資料在記憶體中 配合字串封裝成物件
				CustomersBean customer=gson.fromJson(jsonString,CustomersBean.class);
				
				//============================使用Spring factory 要一個DataSource物件==========================
				//要一個DAO物件(JdbcTemplate) 採用介面多型化 可前或者向後相容性
				JdbcOperations dao=factory.getBean("dao",JdbcOperations.class);
				try {
				//新增作業
				int affect=dao.update("insert into "
						+ "Customers(CustomerID,CompanyName,Address,Phone,Country) "
						+ "values(?,?,?,?,?)"
						,
						//callback 程序處理(實作PreparedStatementSetter 介面方法...類別實作)
						//Lambda Expression(Function) 避免走向類別規劃的腳步 因為這一段只用一次
						//改採成函數程式變數概念 直接撰寫function 傳遞功能旗標 變成callback
						
						p->{
							//設定順序參數的參數值
							p.setString(1, customer.getCustomerId());
							p.setString(2, customer.getCompanyName());
							p.setString(3,customer.getAddress());
							p.setString(4, customer.getPhone());
							p.setString(5, customer.getCountry());
						}
						);
				
				
				
				//透過Response回應到前端
				//建構訊息物件
				Message msg=new Message();
				msg.setCode(200);
				msg.setMessage("新增記錄成功");
				//採用Gson序列化物件為Json String
				String resMessage=gson.toJson(msg);
				response.setStatus(200);
				response.getWriter().println(resMessage);
				}catch(DataAccessException ex ) {
					Message msg=new Message();
					msg.setCode(400);
					msg.setMessage("新增記錄失敗");
					//採用Gson序列化物件為Json String
					String resMessage=gson.toJson(msg);
					response.setStatus(400);
					response.getWriter().println(resMessage);
				}
				
	}

	
}
