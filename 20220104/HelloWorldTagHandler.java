package com.gjun.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

//實作原始介面Tag
public class HelloWorldTagHandler implements Tag{
	//Attribute
	private PageContext pageContext; //配合一個瀏覽器請求網頁jsp 產生相對資訊page Context

	@Override
	public int doEndTag() throws JspException {
		JspWriter out=this.pageContext.getOut();
		try {
			out.println("<br/><font size='7' color='red'>巨匠電腦</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	// 標籤庫 tld 來決定 開頭 <xxx:xxx>實體標籤</xxx:xxx>   <xxx:xxx  />
	//回應值 整數(往往跟定義出來的常數有關)
	@Override
	public int doStartTag() throws JspException {
		//1.透過注入進來的 PageContext(Context跟前端一個瀏覽器互通）
		//2.取出Writer JspWriter
		JspWriter out=this.pageContext.getOut();
		try {
			out.println("<font size='7' color='red'>Hello World</font>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//回應旗標(如何往下走) 往這一個標籤後面網頁內容去執行
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

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext=pageContext;
		
	}

	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub
		
	}

}
