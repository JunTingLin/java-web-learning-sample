package com.gjun.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
//RESTful Resource
//POJO(Plain Old Java Object)
@Path("/hello")
public class HelloService {
	//�غc�l
	public HelloService() {
		System.out.println("Hello Resource...");
	}
	@Path("/say/hello")
	@GET //�e�ݽШD��k 
	@Produces("text/plain") //�M�wResponse Header Content-Type
	public String sayHello() {
		return "<font size='7' color='red'>�z�n</font>";
	}

}
