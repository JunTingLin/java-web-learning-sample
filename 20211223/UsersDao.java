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
			//砞﹚穝糤粂猭
			String sql="insert into javausers(username,password,realname,email) values(?,?,?,?)";
			//玻ネㄣΤ把计琜篶㏑ン
			PreparedStatement st=connection.prepareStatement(sql);
			//砞﹚把计ず甧
			st.setString(1, users.getUserName());
			st.setString(2, users.getPassword());
			st.setString(3, users.getRealName());
			st.setString(4, users.getEmail());
			//︽穝糤
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
		//硓筁猔DataSource眔硈钡ン
		boolean r=false;
		Connection connection=this.datasource.getConnection();
		//String 
		String sql="select count(*) as counter from javausers where username=? and password=?";
		PreparedStatement pre=connection.prepareStatement(sql);
		//把计砞﹚
		pre.setObject(1, key1);
		pre.setObject(2, key2);
		//磅︽琩高
		ResultSet rs=pre.executeQuery();
		rs.next();
		if(rs.getInt("counter")>0) {
			//穦
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
