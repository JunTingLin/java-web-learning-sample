package com.gjun.domain;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface IDao<T> {
	//抽象方法
	public default boolean insert(T entity) throws SQLException {
		return true;
	}
	//單筆查詢
	public default T selectForObject(Object key) throws SQLException {
		return null;
	}
	//多筆查詢
	public default List<T> selectForList(Object key)throws SQLException{
		return null;
	}
	//屬性注入DataSource
	public void setDataSource(DataSource datasource);
	
}
