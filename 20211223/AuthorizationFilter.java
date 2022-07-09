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
// 新建filter時用工具設定
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
		//轉換到Http
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		//透過request取出所有Cookies
		Cookie[] cookies=req.getCookies();
		boolean isValid=false;
		String errMsg=null;
		if(cookies==null) {
			errMsg="沒有任何前端的憑證!非法侵入!!!";
		}else {
			//逐一走訪 看看有沒有登入後憑證
			for(Cookie cookie:cookies) {
				//判斷name
				if(cookie.getName().equals("cred"))
				{
					isValid=true;
					break;
				}
			}
	
		}
		if(isValid) {
			//驗證通過
			chain.doFilter(req, res); //往下走
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
