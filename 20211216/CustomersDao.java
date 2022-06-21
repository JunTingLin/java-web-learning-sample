package com.gjun.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.gjun.beans.Customers;
//Data Access Object(DAO�]�p�Ҧ�) ��{MVC(Model)
public class CustomersDao implements IDao<Customers>{
	//Attribute
	private DataSource datasource;

	//Property Injection(�ݩʪ`�J �̿����Y����)
	@Override
	public void setDataSource(DataSource datasource) {
		this.datasource=datasource;
		
	}

	@Override
	public List<Customers> selectForList(Object key) throws SQLException {
		List<Customers> data=new ArrayList<>();
		//1.�z�L�`�J�i�Ӫ� DataSource���ͤ@�ӳs���W��Ʈw���s������
		Connection connection=datasource.getConnection();
		//2.�z�L�s�����󲣥ͤ@�Ө㦳�ƫe�sĶStatement ����ǳƬd�߱ԭzSQL
		String sql="SELECT * FROM customer_list where country=?";
		PreparedStatement pre=connection.prepareStatement(sql);
		//�]�w�Ѽ�
		pre.setObject(1,key);
		//���O�d�� ����ResultSet
		ResultSet rs=pre.executeQuery();
		//�h�� �v��Fetching
		while(rs.next()) {
			//�غcJavaBean ����ʸˬ۹�O�����
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
