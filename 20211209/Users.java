package com.gjun.beans;
//JavaBean
//1.特性-具有空參數建構子 2.封裝欄位(Attribute) 3.存取子 
public class Users implements java.io.Serializable {
	//Attribute--封裝性
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
