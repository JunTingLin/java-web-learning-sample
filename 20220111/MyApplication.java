package com.gjun.service;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//跟應用系統啟動之後 註冊REST Service(Resource)
//設定服務入口 也是一個Configuation 組態配置類別(註冊服務類別的架構 )
@ApplicationPath("/api")
public class MyApplication extends Application{
	//自訂建構子
	public MyApplication() {
		System.out.println("REST Service已經啟動了....");
	}
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return super.getClasses();
	}
	
	

}
