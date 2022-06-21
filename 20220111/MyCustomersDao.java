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
	//�h���d�ߤ�k
	@Override
	public List<MyCustomers> selectForList(Object key) throws SQLException {
		//�z�L�`�J�i�Ӫ�DataSource���ͤ@���s����Ʈw�s������
		Connection connection=this.dataSource.getConnection();
		String sql="select * from customers where country=?";
		//�z�L�s������ ���ͤ@�Ӥ��ʩR�O���� 
		PreparedStatement st=connection.prepareStatement(sql);
		//�]�w�d�߰Ѽ�
		st.setString(1,key.toString());
		//�d��
		ResultSet rs=st.executeQuery();
		//�ǳƶ��X����
		List<MyCustomers> data=new ArrayList<MyCustomers>();
		while(rs.next()) {
			//�غcJavaBean�ʸˬ۹�O����줺�e
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
