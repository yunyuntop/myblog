package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.User;
import com.yunyuntop.service.UserService;
import com.yunyuntop.util.MD5Utils;


public class UpdatePasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.setContentType("text/html;charset=utf-8"); 
		 String val=request.getParameter("val");
	     String val2=(String) request.getSession().getAttribute("validate");
	     String password=request.getParameter("password");
	     String uemail=request.getParameter("uemail");
	    
		if(!password.matches("^.{6,15}$")){
				response.getWriter().print("<script>alert('密码需要在6-15之间');location.href='login/forgot.jsp';</script>");
				return;

			}
		if(!uemail.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$")){
				response.getWriter().print("<script>alert('邮箱不正确');location.href='login/forgot.jsp';</script>");
				return;
			}
	     request.getSession().setAttribute("validate", null);
	     
	     if(val!=null&&val.equals(val2)){
	    	 UserService us=new UserService();
	    	// System.out.println(password);
	    	 User user=us.updatePassword(MD5Utils.md5(password), uemail);
	    	 if(user!=null){
	    		 response.sendRedirect("login/index.jsp");
	    		 return;
	    	 }
	     }
	    
	     response.getWriter().print("<script>alert('验证码失效');location.href='login/forgot.jsp';</script>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
