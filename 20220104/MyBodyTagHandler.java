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
		//借助注入進來的BodyContent <xxx>xxxxx...</xxx>
		String sourceBody=this.bodyContent.getString();
		JspWriter innerWriter=this.bodyContent.getEnclosingWriter();
		try {
			String msg=String.format("<font size='7'>我是Body內容....%s</font>",sourceBody);
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
		//取出PageContext JspWriter
		JspWriter out=this.pageContext.getOut();
		try {
			out.println("<font size='4'>開頭標籤處理</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//回應旗標可能影響到body處理方式 (Buffered 將body儲放在BodyContent內 進行緩存與處理)
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
