package com.yunyuntop.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CodeValAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		String val=(String) request.getSession().getAttribute("validate");
		String val2=request.getParameter("val");
		String uemail=request.getParameter("uemail");
		if(val!=null&&val.equals(val2)){
			request.getSession().setAttribute("uemail", uemail);
			response.sendRedirect("login/backpassword.jsp");
			return;
		}else{
		response.getWriter().print("<script>alert('验证码不对!');location.href='login/forgot.jsp';</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
