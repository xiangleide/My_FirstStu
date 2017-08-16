package com.stu.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter(filterName="loginFilter",
		urlPatterns={"/*"},
		initParams={
		@WebInitParam(name="encoding",value="utf-8"),
		@WebInitParam(name="loginPage",value="/login.jsp"),
		@WebInitParam(name="loginController",value="/login.do")
})
public class LoginFilter implements Filter{
	
	
	private FilterConfig config;
	public void init(FilterConfig config) throws ServletException {
		this.config=config;
	}
	public void destroy() {
		this.config=null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		String encoding=config.getInitParameter("encoding");
		String loginPage=config.getInitParameter("loginPage");
		String loginController=config.getInitParameter("loginController");
		
		request.setCharacterEncoding(encoding);
		HttpServletRequest requ=(HttpServletRequest)request;
		HttpSession session=requ.getSession(true);
		
		String requestPath=requ.getServletPath();
		
		if(session.getAttribute("username")==null
				&&session.getAttribute("pasword")==null
				&&!requestPath.endsWith(loginPage)
				&&!requestPath.endsWith(loginController)){
			
			request.setAttribute("inf", "请登录!");
			request.getRequestDispatcher(loginPage).forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}
}
