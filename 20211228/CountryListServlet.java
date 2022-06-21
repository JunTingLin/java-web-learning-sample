package com.gjun.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CountryListServlet")
public class CountryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ǳư�a�O�M����
		List<String> countries=new ArrayList<>();
		countries.add("����");
		countries.add("�^��");
		countries.add("�w��");
		countries.add("�q�j�Q");
		countries.add("��Z��");
		//���򪬺A
		request.setAttribute("country", countries);
		//���XRequestDispatcher
		RequestDispatcher disp=request.getRequestDispatcher("countryselect.jsp");
		disp.forward(request, response);
		
	}

}
