package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.gjun.beans.Users;

import java.sql.SQLException;
public class UsersDao implements IDao<Users> {
	//Attribute
	private DataSource datasource;

	

	@Override
	public boolean insert(Users users) throws SQLException {
		
		boolean r=false;
		Connection connection=null;
		try {
			connection=datasource.getConnection();
			//�]�w�s�W�y�k
			String sql="insert into javausers(username,password,realname,email) values(?,?,?,?)";
			//���ͨ㦳�ѼƬ[�c�R�O����
			PreparedStatement st=connection.prepareStatement(sql);
			//�]�w�ѼƤ��e
			st.setString(1, users.getUserName());
			st.setString(2, users.getPassword());
			st.setString(3, users.getRealName());
			st.setString(4, users.getEmail());
			//����s�W
			int rs=st.executeUpdate();
			r=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			if(connection!=null) {
				connection.close();
			}
		}
		return r;
		}


	
	



	@Override
	public boolean selectForObject(Object key1, Object key2) throws SQLException {
		//�z�L�`�J��DataSource���o�s������
		boolean r=false;
		Connection connection=this.datasource.getConnection();
		//String 
		String sql="select count(*) as counter from javausers where username=? and password=?";
		PreparedStatement pre=connection.prepareStatement(sql);
		//�ѼƳ]�w
		pre.setObject(1, key1);
		pre.setObject(2, key2);
		//����d��
		ResultSet rs=pre.executeQuery();
		rs.next();
		if(rs.getInt("counter")>0) {
			//�|��
			r=true;
		}
		connection.close();
		return r;
		
	}







	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		
	}
	
}
