package com.gjun.service;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//�����Ψt�αҰʤ��� ���UREST Service(Resource)
//�]�w�A�ȤJ�f �]�O�@��Configuation �պA�t�m���O(���U�A�����O���[�c )
@ApplicationPath("/api")
public class MyApplication extends Application{
	//�ۭq�غc�l
	public MyApplication() {
		System.out.println("REST Service�w�g�ҰʤF....");
	}
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return super.getClasses();
	}
	
	

}
