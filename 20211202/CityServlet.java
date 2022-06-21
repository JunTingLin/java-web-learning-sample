package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//硓筁竝﹍て把计猔 砞﹚き常匡兜
public class CityServlet extends HttpServlet{
	//Attribute 把σ﹍て把计ン
	//private ServletConfig config;
	//Overriding init(把计)--钮Servlet筁ㄓま祇ㄆン祘
	//き常﹃皚
	//private String[] items;
	
	//Overriding doGet(蹦ノHttp Request Method-GET)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//砞﹚莱絪絏籔MIME Type
		resp.setContentType("text/html;charset=UTF-8");
		//舱篈皌竚把计
		ServletConfig config=this.getServletConfig();
		//硓筁getInitParameter() 眔﹍て把计ず甧
		String names=config.getInitParameter("cities"); //ㄏノ,硆翴秈︽だ澄
		String [] items=names.split(",");
				
		//Writer
		PrintWriter out=resp.getWriter();
		out.println("<select>");
		//ǐ砐皚
		for(String city:items) {
			out.println("<option value='"+city+"'>"+city+"</option>");
		}
		out.println("</select>");
	}

	//留猔ServletConfigン
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
	}

	//Overriding init(ServletConfig) 叫痙㊣摸init super.init(config)
	//ㄆ皌Servlet.getServletConfig() 拜猔秈ㄓServletConfigン
	//@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		System.out.println("City Serviet筁ㄓ ");
//		
//	}
	

	
	
	
}
