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
	public default boolean selectForObject(Object key1,Object key2) throws SQLException {
		return false;
	}
	//�h���d��
	public default List<T> selectForList(Object key)throws SQLException{
		return null;
	}
	//�ݩʪ`�JDataSource
	public void setDataSource(DataSource datasource);
	
}
