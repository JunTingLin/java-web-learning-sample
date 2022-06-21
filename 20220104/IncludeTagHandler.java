package com.gjun.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class IncludeTagHandler extends BodyTagSupport {
	//Attribute
	private String who;
	private BodyContent bodyContent;
	private int start=1;

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	@Override
	public int doAfterBody() throws JspException {
		//1.取得注入BodyContent??? 採用EVAL_BODY_INCLUDE
		//String content=this.bodyContent.getString();
		//JspWriter out=this.bodyContent.getEnclosingWriter();
//		try {
//			out.print("<font size='7' color='red'>"+content+"</font>");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(this.start<=3) {
			this.start++;
			return EVAL_BODY_AGAIN;
		}else {
			return EVAL_PAGE;
		}
	}

	@Override
	public int doStartTag() throws JspException {
		//Body Include
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public void setBodyContent(BodyContent b) {
		// TODO Auto-generated method stub
		this.bodyContent=b;
	}
	
	
}
