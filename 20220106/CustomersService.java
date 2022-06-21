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

//�Ȥ��ƪA��
@Path("/customers")
public class CustomersService {
	//Attribute
	@Inject
	private  MyCustomersDao dao;
	
	
	public CustomersService() {
		
	}
	//JAX-RS �䴩Middleware�N�i�ǦC�ƪ��� �^���w�]�ǦC�Ʀ�Json(�t�XProduces()
	//�ǻ���a�O �i������Ȥ�d�ߪA�� �ĥ�QueryString�ǻ���a�O../custqry/rawdata?count=xxx
	//�ϥ�Injection �`�J�̿ફ��
	@Path("/custqry/rawdata")
	@GET //�d�� ���ǰe��k
	@Produces("application/json")
	public Response customersQry(@Context ServletContext application
			,@QueryParam("count")String country) {
		//1.�z�L�����t�Ϊ���ServletContext �ѦҥXDataSource(�s���u�t����)
		//���XDataSource
		DataSource datasource=(DataSource)application.getAttribute("datasource");
		//�غcDAO����
		dao=new MyCustomersDao();
		//�`�JDataSource
		dao.setDataSource(datasource);
		//�i��d��
		List<MyCustomers> result=null;
		Response response=null;
		try {
			 result=dao.selectForList(country);
			 response=Response.ok(result).build();  //ok-200
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response=Response.status(500).entity(e.getMessage()).build();
		}
		//�P�_�O�_�������
		if(result.size()==0) {
			Message msg=new Message();
			msg.setCode(400);
			msg.setMsg("��a�O:"+country+" �S������Ȥ�O��");
			response=Response.status(400).entity(msg).build();
		}
		return response;
	}

}
