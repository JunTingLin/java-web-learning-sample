package com.gjun.domain;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface IDao<T> {
	//��H��k
	public default boolean insert(T entity) throws SQLException {
		return true;
	}
	//�浧�d��
	public default T selectForObject(Object key) throws SQLException {
		return null;
	}
	//�h���d��
	public default List<T> selectForList(Object key)throws SQLException{
		return null;
	}
	//�ݩʪ`�JDataSource
	public void setDataSource(DataSource datasource);
	
}
