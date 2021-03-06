package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			//設定新增語法
			String sql="insert into javausers(username,password,realname,email) values(?,?,?,?)";
			//產生具有參數架構命令物件
			PreparedStatement st=connection.prepareStatement(sql);
			//設定參數內容
			st.setString(1, users.getUserName());
			st.setString(2, users.getPassword());
			st.setString(3, users.getRealName());
			st.setString(4, users.getEmail());
			//直行新增
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
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		
	}
	
}
