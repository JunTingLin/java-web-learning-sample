package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.gjun.beans.MyCustomers;

public class MyCustomersDao implements IDao<MyCustomers> {
	//Attribute
	private DataSource dataSource; //���edatasource�S��n�A�令dataSource

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	// �åB�h�l�[�Fgetter
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public boolean insert(MyCustomers entity) throws SQLException {
		boolean r=false;
		//1.�z�L�`�J�i��DataSource����(�s������u�t)
		Connection connection=dataSource.getConnection();
		//2.�]�w�s�W�y�k
		String sql="insert into customers(customerid,companyname,address,phone,email,country) values(?,?,?,?,?,?)";
		//�ĥ�PreparedStatement�i��ѼƳ]�w
		PreparedStatement st=connection.prepareStatement(sql);
		//�]�w�ѼƤ��e
		st.setString(1, entity.getCustomerId());
		st.setString(2, entity.getCompanyName());
		st.setString(3, entity.getAddress());
		st.setString(4, entity.getPhone());
		st.setString(5, entity.getEmail());
		st.setString(6,	entity.getCountry());
		try {
		//����s�W
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
