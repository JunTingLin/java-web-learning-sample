package com.gjun.entity;
//Javabean--�ŰѼƫغc�l/�ʸ��ݩ�/�]�wsetter and getter/��@�ǦC�Ƥ���
public class AppConfig implements java.io.Serializable{
	//�ʸ��ݩ�
	private String url;//�s���r��
	private String userName; //�n�J��Ʈw�b��
	private String password;
	private String companyName;
	private String address;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
