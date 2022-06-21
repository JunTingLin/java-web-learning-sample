package com.gjun.view;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/showphoto")
public class ShowPhotoServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//設定回應的MIME Type
		response.setContentType("image/jpeg");
		//取出傳遞的選項select表單欄位
		String photoName=request.getParameter("selphoto");
		//反應相對虛擬目錄完整性
		String virtualPath="photos/"+photoName; //使用標籤<img src="....虛擬目錄/>
		//1.準備讀檔 進入I/O 首先面對是哪一個磁碟 哪一個實際目錄
		//1.1 透過這一個Servlet問出相對網站系統(ServletContext)
		ServletContext application=this.getServletContext();
		//透過ServletContext 給虛擬目錄問出實際目錄
		String realPath=application.getRealPath(virtualPath);
		//2.讀取檔案 變成串流Stream
		//建構InputStream物件 
		InputStream is=new FileInputStream(realPath);
		//讀取檔案到一個緩存區(byte array)
		byte[] buffer=new byte[is.available()];
		is.read(buffer);
		//關閉串流
		is.close();
		//透過Response去問出寫出非文字的Stream
		ServletOutputStream os=response.getOutputStream();
		os.write(buffer, 0, buffer.length);
		//清緩存區
		os.flush();
		os.close();
		//3.如何借助response透過寫出串流bytes 到前端去(如何通知對方 Content-Type)
		//System.out.println(virtualPath);
		//System.out.println("實際目錄:"+realPath);
		
	}
	
}
