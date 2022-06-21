package com.gjun.entity;
//POJO(Plain Old Java Object)---只要繼承java.lang.Object
//JavaBean 空參數架構子 具有封裝性資料欄 設計存取子setter and getter
public class CustomersBean {
	//Attribute具有封裝性(private)
	private String customerId;
	private String companyName;
	private String address;
	private String phone;
	private String country;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	//建構不寫 編譯產生預設架構子 就是空參數的
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	//拿掉set and get CompanyName 採用駝峰命名法 Property   companyName=xxx 執行setCompanyName  
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//Overriding toString()
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("編號:%s 公司行號:%s",this.customerId,this.companyName);
	}
	
	
	
	

}
