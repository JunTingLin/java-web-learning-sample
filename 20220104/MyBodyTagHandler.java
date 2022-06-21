package com.gjun.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

public class MyBodyTagHandler implements BodyTag {
	//Attribute
	private PageContext pageContext;
	private Tag parent;
	private BodyContent bodyContent;
	

	@Override
	public int doAfterBody() throws JspException {
		//�ɧU�`�J�i�Ӫ�BodyContent <xxx>xxxxx...</xxx>
		String sourceBody=this.bodyContent.getString();
		JspWriter innerWriter=this.bodyContent.getEnclosingWriter();
		try {
			String msg=String.format("<font size='7'>�ڬOBody���e....%s</font>",sourceBody);
			innerWriter.print(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		//���XPageContext JspWriter
		JspWriter out=this.pageContext.getOut();
		try {
			out.println("<font size='4'>�}�Y���ҳB�z</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�^���X�Хi��v�T��body�B�z�覡 (Buffered �Nbody�x��bBodyContent�� �i��w�s�P�B�z)
		return EVAL_BODY_BUFFERED;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext pc) {
		this.pageContext=pc;
		
	}

	@Override
	public void setParent(Tag parent) {
		this.parent=parent;
		
	}

	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent=bodyContent;
		
	}

}
