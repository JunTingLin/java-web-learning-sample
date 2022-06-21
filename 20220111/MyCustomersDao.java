package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.gjun.beans.MyCustomers;

public class MyCustomersDao implements IDao<MyCustomers> {
	//Attribute
	private DataSource dataSource;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public boolean insert(MyCustomers entity) throws SQLException {
		boolean r=false;
		//1.透過注入進來DataSource物件(連接物件工廠)
		Connection connection=dataSource.getConnection();
		//2.設定新增語法
		String sql="insert into customers(customerid,companyname,address,phone,email,country) values(?,?,?,?,?,?)";
		//採用PreparedStatement進行參數設定
		PreparedStatement st=connection.prepareStatement(sql);
		//設定參數內容
		st.setString(1, entity.getCustomerId());
		st.setString(2, entity.getCompanyName());
		st.setString(3, entity.getAddress());
		st.setString(4, entity.getPhone());
		st.setString(5, entity.getEmail());
		st.setString(6,	entity.getCountry());
		try {
		//直行新增
		int affect=st.executeUpdate();
		r=true;
		}catch(SQLException ex) {
			throw ex;
		}finally {
			connection.close();
		}
		return r;
		
	}
	//多筆查詢方法
	@Override
	public List<MyCustomers> selectForList(Object key) throws SQLException {
		//透過注入進來的DataSource產生一條連接資料庫連接物件
		Connection connection=this.dataSource.getConnection();
		String sql="select * from customers where country=?";
		//透過連接物件 產生一個互動命令物件 
		PreparedStatement st=connection.prepareStatement(sql);
		//設定查詢參數
		st.setString(1,key.toString());
		//查詢
		ResultSet rs=st.executeQuery();
		//準備集合物件
		List<MyCustomers> data=new ArrayList<MyCustomers>();
		while(rs.next()) {
			//建構JavaBean封裝相對記錄欄位內容
			MyCustomers customers=new MyCustomers();
			customers.setCustomerId(rs.getString("customerid"));
			customers.setCompanyName(rs.getString("companyname"));
			customers.setAddress(rs.getString("address"));
			customers.setEmail(rs.getString("email"));
			customers.setCountry(rs.getString("country"));
			data.add(customers);
		}
		connection.close();
		return data;
	}
	
	

}
