package com.gjun.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.gjun.entity.Message;

//REST Service--類別當作Resource 資源 往往被註冊才能使用
//採用POJO(Plain Old Java Object) 乾淨類別撰寫 沒有包袱
//描述入口第一層端點
@Path("/hello") //設定端點
public class HelloService {
	//撰寫方法 當作處理程序 當作服務
	@Path("/helloworld") //設定端點
	@GET //設定Request Method傳送方法
	@Produces("text/plain") //設應回應Response的MIME Type
	public String sayHello() {
		return "Hello World";
	}
	
	//回應一個Message 物件 隱藏一個回應的攔截器(MessageBodyWriter 將物件序列化成mime type字串)
	@Path("/saymessage")
	@GET
	@Produces("application/json") //MIME Type
	public Message sayMessage() {
		//建構物件
		Message msg=new Message();
		msg.setCode(200);
		msg.setMessage("我是實體物件資訊");
		return msg; //jersey framework埋回應的攔截器 使用ResponseBodyWriter 序列化物件為json string
	}
}
