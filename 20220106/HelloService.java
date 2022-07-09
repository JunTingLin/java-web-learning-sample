package com.gjun.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
//RESTful Resource
//POJO(Plain Old Java Object)
@Path("/hello")
public class HelloService {
	//建構子
	public HelloService() {
		System.out.println("Hello Resource...");
	}
	@Path("/say/hello")
	@GET //前端請求方法 
	//被請求到這個端點的時候就會產生一個個體物件
	@Produces("text/plain") //決定Response Header Content-Type
	public String sayHello() {
		return "<font size='7' color='red'>您好</font>";
	}

}
