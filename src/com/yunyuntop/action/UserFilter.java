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

import com.yunyuntop.domain.User;


public class UserFilter implements Filter {


	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		response.setContentType("text/html;charset=utf-8");
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			response.getWriter().print("<script>alert('登录信息竟然失效了-_-?');location.href='"+request.getContextPath()+"/login/index.jsp';</script>");
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
