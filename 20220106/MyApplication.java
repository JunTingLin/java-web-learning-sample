package com.gjun.service;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//�����Ψt�αҰʤ��� ���UREST Service(Resource)
//�]�w�A�ȤJ�fbase path
// ���ݭn�A�h����web.xml��ť��listener
@ApplicationPath("/api")
public class MyApplication extends Application{
	//�ۭq�غc�l
	// ���ӴN���w�]�غc�l�A�u�O���F�n��ܰT���A�����`�N�������ŰѼ�
	public MyApplication() {
		System.out.println("REST Service�w�g�ҰʤF....");
	}
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return super.getClasses();
	}
	
	

}
