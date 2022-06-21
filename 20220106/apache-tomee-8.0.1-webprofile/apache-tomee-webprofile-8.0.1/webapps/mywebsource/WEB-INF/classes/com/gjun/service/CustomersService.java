package com.gjun.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.web.context.WebApplicationContext;

import com.gjun.entity.CustomersBean;
import com.gjun.entity.Message;



//REST Resouce 採用POJO(Plain Old Java Object)
@Path("/customers")
public class CustomersService {
	//Attribute
	//建構Spring工廠 ApplicationContext介面可以獲取到應用系統資源
	private ApplicationContext factory=
			new ClassPathXmlApplicationContext("applicationContext.xml");
	//Method as Service
	//採用Query String
	@Path("/qrybyid")
	@GET
	@Produces("text/plain")
	public String customersQryById(@QueryParam("cid")String customerid) {
		return customerid;
	}
	
	//採用動態路由(網址) 目錄當作參數架構 回應攔截器MessageBodyWriter
	@Path("/qrycustomers/key/{cid}/rawdata")
	@GET
	@Produces("application/json")
	public Response customersQryById2(@PathParam("cid")String customerid) {
		//1.使用工廠要回來一個DAO物件(JdbcTemplate)
		//使用介面多型化架構 讓系統維護可以長久
		JdbcOperations dao=factory.getBean("dao",JdbcOperations.class);
		//例外管理
		try {
		CustomersBean result=
				dao.queryForObject("Select CustomerID,CompanyName,Address,"
						+ "Phone,Country from Customers Where CustomerID=?",
				new Object[] {customerid},
				//使用Lambda Expression這一個功能寫好配合第一個與第二個參數查詢後的callback..自己整理資料
				(r,n)->{
					System.out.println(n);
					CustomersBean bean=new CustomersBean();
					//線上讀取資料 第一個參數就是查詢結果的ResultSet
					bean.setCustomerId(r.getString("CustomerID"));
					bean.setCompanyName(r.getString("CompanyName"));
					bean.setAddress(r.getString("Address"));
					bean.setPhone(r.getString("Phone"));
					bean.setCountry(r.getString("Country"));
					
					return bean;
				}
				);
		//Response抽象類別 不能直接建構成物件  透過static method生產出不知道子類別物件
		Response response=Response.ok(result).build();
		return response;
		}catch(Exception ex) {
			//建構訊息物件
			Message msg=new Message();
			msg.setCode(400);
			msg.setMessage(String.format("客戶編號:%s 不存在的",customerid));
			//透過Response工廠生產Response物件
			return Response.status(400).entity(msg).build();
			
		}
	}
	
	//前端傳遞整份的JSON文件進來(採用Http Body(Content) 後端服務要進行傳遞Request Header Content-Type
	@POST
	@Path("/customeradd/rawdata")
	@Consumes("application/json") //規範前端採用request content-type
	@Produces("application/json")
	public CustomersBean customersAdd(CustomersBean customers) {
		return customers;
	}
}
