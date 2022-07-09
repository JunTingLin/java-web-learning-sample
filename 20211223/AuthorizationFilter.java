package com.gjun.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthorizationFilter
 */
// �s��filter�ɥΤu��]�w
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE
		}
					, urlPatterns = { "/acct/*" })
public class AuthorizationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorizationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//�ഫ��Http
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		//�z�Lrequest���X�Ҧ�Cookies
		Cookie[] cookies=req.getCookies();
		boolean isValid=false;
		String errMsg=null;
		if(cookies==null) {
			errMsg="�S������e�ݪ�����!�D�k�I�J!!!";
		}else {
			//�v�@���X �ݬݦ��S���n�J�����
			for(Cookie cookie:cookies) {
				//�P�_name
				if(cookie.getName().equals("cred"))
				{
					isValid=true;
					break;
				}
			}
	
		}
		if(isValid) {
			//���ҳq�L
			chain.doFilter(req, res); //���U��
		}else {
			res.sendError(401, errMsg);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
