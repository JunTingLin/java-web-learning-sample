package com.gjun.beans;
//JavaBean
//1.�S��-�㦳�ŰѼƫغc�l 2.�ʸ����(Attribute) 3.�s���l 
public class Users implements java.io.Serializable {
	//Attribute--�ʸ˩�
	private String userName;
	private String password;
	private String realName;
	private String email;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
