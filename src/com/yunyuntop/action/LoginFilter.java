package com.yunyuntop.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.User;
import com.yunyuntop.service.UserService;
import com.yunyuntop.util.CookUtils;


public class LoginFilter implements Filter {
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		//System.out.println(request.getRequestURI());
		if(!request.getRequestURI().contains("login")&&!request.getRequestURI().contains("admin")){
			
			if(request.getSession().getAttribute("user")==null&&CookUtils.getCookieByName("autoLogin",request.getCookies()) != null){
				String username=CookUtils.getCookieByName("autoLogin",request.getCookies()).getValue().split("-")[0];
				String password=CookUtils.getCookieByName("autoLogin", request.getCookies()).getValue().split("-")[1];
				//System.out.println(username);
				//System.out.println(password);
				UserService us=new UserService();
				User user=us.login(username, password);
				if(user!=null){
				request.getSession().setAttribute("user", user);
				}
			}
		}
		chain.doFilter(new MyReq(request), response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}

class MyReq extends HttpServletRequestWrapper{

	HttpServletRequest request;
	public MyReq(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	
	@Override
	public String getParameter(String name) {
		
		if(request.getMethod().equalsIgnoreCase("get")){
			String name2=request.getParameter(name);String n=null;
			try {
				
				if(name2!=null){
				  n=new String(name2.getBytes("ISO-8859-1"),"UTF-8");
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}return n;
		}else if(request.getMethod().equalsIgnoreCase("post")){
			
			
			
			try {
				request.setCharacterEncoding("utf-8");
				return request.getParameter(name);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		}
		return super.getParameter(name);
	}
	
}
