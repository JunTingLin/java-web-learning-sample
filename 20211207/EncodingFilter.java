package com.gjun.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//攔截網站所有目錄 的請求與回應
public class EncodingFilter implements Filter{
	private String encoding;

	//攔截HTTP封包 進出都要攔截
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, 
			FilterChain chain)
			throws IOException, ServletException {
		//前端進來時
		System.out.println("有人來了...");
		req.setCharacterEncoding(this.encoding);
		
		
		
		//要回到前端去//回應的編碼
		resp.setCharacterEncoding(this.encoding);
		//如何往下走???
		chain.doFilter(req, resp); //往下走 並且將先的request/response物件帶下去
		System.out.println("有人要回去了...");
		
		
		
	}

	//聽Filter物件活過來時 進行初始化(注入組態配置初始化參數)
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		System.out.println("編碼攔截器活過來了...");
		this.encoding=filterConfig.getInitParameter("encoding");
	}
	

}
