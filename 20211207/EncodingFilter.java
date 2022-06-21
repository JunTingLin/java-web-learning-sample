package com.gjun.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//�d�I�����Ҧ��ؿ� ���ШD�P�^��
public class EncodingFilter implements Filter{
	private String encoding;

	//�d�IHTTP�ʥ] �i�X���n�d�I
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, 
			FilterChain chain)
			throws IOException, ServletException {
		//�e�ݶi�Ӯ�
		System.out.println("���H�ӤF...");
		req.setCharacterEncoding(this.encoding);
		
		
		
		//�n�^��e�ݥh//�^�����s�X
		resp.setCharacterEncoding(this.encoding);
		//�p�󩹤U��???
		chain.doFilter(req, resp); //���U�� �åB�N����request/response����a�U�h
		System.out.println("���H�n�^�h�F...");
		
		
		
	}

	//ťFilter���󬡹L�Ӯ� �i���l��(�`�J�պA�t�m��l�ưѼ�)
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		System.out.println("�s�X�d�I�����L�ӤF...");
		this.encoding=filterConfig.getInitParameter("encoding");
	}
	

}
