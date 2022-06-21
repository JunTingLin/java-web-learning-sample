package com.gjun.service;


import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.gjun.beans.MyCustomers;
import com.gjun.domain.Message;
import com.gjun.domain.MyCustomersDao;

//客戶資料服務
@Path("/customers")
public class CustomersService {
	//Attribute
	@Inject
	private  MyCustomersDao dao;
	
	
	public CustomersService() {
		
	}
	//JAX-RS 支援Middleware將可序列化物件 回應預設序列化成Json(配合Produces()
	//傳遞國家別 進行相關客戶查詢服務 採用QueryString傳遞國家別../custqry/rawdata?count=xxx
	//使用Injection 注入依賴物件
	@Path("/custqry/rawdata")
	@GET //查詢 的傳送方法
	@Produces("application/json")
	public Response customersQry(@Context ServletContext application
			,@QueryParam("count")String country) {
		//1.透過網站系統物件ServletContext 參考出DataSource(連接工廠物件)
		//取出DataSource
		DataSource datasource=(DataSource)application.getAttribute("datasource");
		//建構DAO物件
		dao=new MyCustomersDao();
		//注入DataSource
		dao.setDataSource(datasource);
		//進行查詢
		List<MyCustomers> result=null;
		Response response=null;
		try {
			 result=dao.selectForList(country);
			 response=Response.ok(result).build();  //ok-200
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response=Response.status(500).entity(e.getMessage()).build();
		}
		//判斷是否有找到資料
		if(result.size()==0) {
			Message msg=new Message();
			msg.setCode(400);
			msg.setMsg("國家別:"+country+" 沒有任何客戶記錄");
			response=Response.status(400).entity(msg).build();
		}
		return response;
	}

}
