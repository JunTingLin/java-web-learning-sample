package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�z�L�G�p��l�ưѼƪ`�J �]�w�����ﶵ
public class CityServlet extends HttpServlet{
	//Attribute �ѦҦ��l�ưѼƪ���
	//private ServletConfig config;
	//Overriding init(�Ѽ�)--ťServlet���L�Ӥ޵o�ƥ�{��
	//�����r��}�C
	//private String[] items;
	
	//Overriding doGet(�ĥ�Http Request Method-GET)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�]�w�^���s�X�PMIME Type
		resp.setContentType("text/html;charset=UTF-8");
		//���X�պA�t�m�Ѽ�
		ServletConfig config=this.getServletConfig();
		//�z�LgetInitParameter() ���o��l�ưѼƤ��e
		String names=config.getInitParameter("cities"); //�ϥ�,�r�I�i�����
		String [] items=names.split(",");
				
		//���XWriter
		PrintWriter out=resp.getWriter();
		out.println("<select>");
		//���X�}�C
		for(String city:items) {
			out.println("<option value='"+city+"'>"+city+"</option>");
		}
		out.println("</select>");
	}

	//���t�`�JServletConfig����
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
	}

	//Overriding init(ServletConfig) �Яd�U�I�s�����Oinit super.init(config)
	//�ƫ�t�XServlet.getServletConfig() �ݥX�`�J�i�Ӫ�ServletConfig����
	//@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		System.out.println("City Serviet���L�� ");
//		
//	}
	

	
	
	
}
