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
		//�]�w�^����MIME Type
		response.setContentType("image/jpeg");
		//���X�ǻ����ﶵselect������
		String photoName=request.getParameter("selphoto");
		//�����۹�����ؿ������
		String virtualPath="photos/"+photoName; //�ϥμ���<img src="....�����ؿ�/>
		//1.�ǳ�Ū�� �i�JI/O ��������O���@�ӺϺ� ���@�ӹ�ڥؿ�
		//1.1 �z�L�o�@��Servlet�ݥX�۹�����t��(ServletContext)
		ServletContext application=this.getServletContext();
		//�z�LServletContext �������ؿ��ݥX��ڥؿ�
		String realPath=application.getRealPath(virtualPath);
		//2.Ū���ɮ� �ܦ���yStream
		//�غcInputStream���� 
		InputStream is=new FileInputStream(realPath);
		//Ū���ɮר�@�ӽw�s��(byte array)
		byte[] buffer=new byte[is.available()];
		is.read(buffer);
		//������y
		is.close();
		//�z�LResponse�h�ݥX�g�X�D��r��Stream
		ServletOutputStream os=response.getOutputStream();
		os.write(buffer, 0, buffer.length);
		//�M�w�s��
		os.flush();
		os.close();
		//3.�p��ɧUresponse�z�L�g�X��ybytes ��e�ݥh(�p��q����� Content-Type)
		//System.out.println(virtualPath);
		//System.out.println("��ڥؿ�:"+realPath);
		
	}
	
}
