package com.gjun.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

//��@����Tag
public class HelloWorldTagHandler implements Tag{
	//Attribute
	private PageContext pageContext;

	@Override
	public int doEndTag() throws JspException {
		JspWriter out=this.pageContext.getOut();
		try {
			out.println("<br/><font size='7' color='red'>���K�q��</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;  //�i�H���U��this.�ݬݦ����g�`�ƥi�H�ϥ�
	}

	// ���Үw tld �ӨM�w �}�Y <xxx:xxx>�������</xxx:xxx>   <xxx:xxx  />
	@Override
	public int doStartTag() throws JspException {
		//1.�z�L�`�J�i�Ӫ� PageContext(Context��e�ݤ@���s�������q�^
		//2.���XWriter JspWriter
		JspWriter out=this.pageContext.getOut();
		try {
			out.println("<font size='7' color='red'>Hello World</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�^���X��(�p�󩹤U��) ���o�@�Ӽ��ҫ᭱�������e�h����
		return EVAL_PAGE;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	//���M�����D�T���n�g����̥h
	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext=pageContext;
		
	}

	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub
		
	}

}
