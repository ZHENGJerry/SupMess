package com.supinfo.supmessaging.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/auth/*")
public class AuthenticateFilter implements Filter {
	
	private FilterConfig fc;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
	
		String username  = (String) ((HttpServletRequest)req).getSession().getAttribute("username");
		String password  = (String) ((HttpServletRequest)req).getSession().getAttribute("password");
		if(username!=null && password !=null)
		{
			System.out.print("222222222222222222222222222");
			chain.doFilter(req, resp);
		  System.out.print("222222222222222222222222222");
		}
		
		else
			((HttpServletResponse)resp).sendRedirect(((HttpServletRequest)req).getContextPath()+"/index.jsp");
	}

	
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.fc = filterConfig;
	}

}
