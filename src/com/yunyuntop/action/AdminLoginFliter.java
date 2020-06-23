package com.yunyuntop.action;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminLoginFliter implements Filter {

	public void destroy() {
	
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String uri=request.getRequestURI();
		if((!(uri.contains("adminLogin"))&&!(uri.contains("login")))&&((uri.contains("/admin")&&uri.contains("Action"))||(uri.contains(".jsp")&&uri.contains("/admin/")))){
			
			if(request.getSession().getAttribute("admin")==null){
				
				response.getWriter().println("<script>alert('you must login in system ');window.parent.location.href='"+request.getContextPath()+"/admin/login.jsp';</script>");
			return;
			}
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
