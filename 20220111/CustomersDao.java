package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.gjun.beans.Customers;
//Data Access Object(DAO設計模式) 實現MVC(Model)
public class CustomersDao implements IDao<Customers>{
	//Attribute
	private DataSource datasource;

	//Property Injection(屬性注入 依賴關係物件)
	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		
	}

	@Override
	public List<Customers> selectForList(Object key) throws SQLException {
		List<Customers> data=new ArrayList<>();
		//1.透過注入進來的 DataSource產生一個連接上資料庫的連接物件
		Connection connection=datasource.getConnection();
		//2.透過連接物件產生一個具有事前編譯Statement 先行準備查詢敘述SQL
		String sql="SELECT * FROM customer_list where country=?";
		PreparedStatement pre=connection.prepareStatement(sql);
		//設定參數
		pre.setObject(1,key);
		//正是查詢 產生ResultSet
		ResultSet rs=pre.executeQuery();
		//多筆 逐筆Fetching
		while(rs.next()) {
			//建構JavaBean 物件封裝相對記錄欄位
			Customers customers=new Customers();
			customers.setId(rs.getShort("ID"));
			customers.setName(rs.getString("name"));
			customers.setAddress(rs.getString("address"));
			customers.setPhone(rs.getString("phone"));
			customers.setCountry(rs.getString("country"));
			data.add(customers);
			
		}
		connection.close();
		return data;

	}
	

}
