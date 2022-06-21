package com.gjun.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class WhoHelloTagHandler extends TagSupport {
	//Attribute
	private String who;
	private String information;
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	//�}�Y���ҵ{��
	@Override
	public int doStartTag() throws JspException {
		//�ɧU�`�J�i��PageContext ���XWriter
		PageContext pageContext=this.pageContext;
		JspWriter out=pageContext.getOut();
		String msg=String.format("<font size='7' color='red'>%s ���F...%s</font>",who,information);
		try {
			out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���U��
		return EVAL_PAGE;
	}
	
}
