package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.gjun.beans.MyCustomers;

public class MyCustomersDao implements IDao<MyCustomers> {
	//Attribute
	private DataSource dataSource; //之前datasource沒對好，改成dataSource

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	// 並且多追加了getter
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
	

}
