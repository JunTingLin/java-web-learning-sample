package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.gjun.beans.MyCustomers;

public class MyCustomersDao implements IDao<MyCustomers> {
	//Attribute
	private DataSource dataSource; //ぇ玡datasource⊿癸эΘdataSource

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	// 發getter
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public boolean insert(MyCustomers entity) throws SQLException {
		boolean r=false;
		//1.硓筁猔秈ㄓDataSourceン(硈钡ン紅)
		Connection connection=dataSource.getConnection();
		//2.砞﹚穝糤粂猭
		String sql="insert into customers(customerid,companyname,address,phone,email,country) values(?,?,?,?,?,?)";
		//蹦ノPreparedStatement秈︽把计砞﹚
		PreparedStatement st=connection.prepareStatement(sql);
		//砞﹚把计ず甧
		st.setString(1, entity.getCustomerId());
		st.setString(2, entity.getCompanyName());
		st.setString(3, entity.getAddress());
		st.setString(4, entity.getPhone());
		st.setString(5, entity.getEmail());
		st.setString(6,	entity.getCountry());
		try {
		//︽穝糤
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
