package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.User;
import com.yunyuntop.service.UserService;
import com.yunyuntop.util.CookUtils;
import com.yunyuntop.util.MD5Utils;




public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		String username=request.getParameter("username");
		String password1=request.getParameter("password");
		String password=MD5Utils.md5(password1);
		UserService us=new UserService();
		
		User user=us.login(username,password);
		if(user!=null&&user.getUstate()!=0){
		if(request.getParameter("auto")!=null){
			Cookie cookie = new Cookie("autoLogin",username+"-"+password);
			cookie.setMaxAge(72*60*1000);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
		}
		if(request.getParameter("rememberme")!=null){
			Cookie cookie = new Cookie("username",username);
			cookie.setPath(request.getContextPath()+"/");
			cookie.setMaxAge(24*10*60*1000);
			response.addCookie(cookie);
		}
		
			request.getSession().setAttribute("user", user);
			if(request.getSession().getAttribute("commentinfo")==null){
			response.sendRedirect("index.jsp");
			}else{
				String bid=request.getParameter("bid");
				if(bid!=null&&bid!=""){			request.getSession().setAttribute("bid", null);				
					response.sendRedirect("sigleAction?bid="+bid+"#create-comment");return;							
				}request.getSession().setAttribute("commentinfo",null);response.sendRedirect("index.jsp");return;
				
			}
		}else{
			
			response.getWriter().print("<script>alert('用户名或密码不正确');location.href='login/index.jsp';</script>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
