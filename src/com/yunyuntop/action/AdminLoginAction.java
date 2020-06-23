package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Admin;
import com.yunyuntop.domain.Info;
import com.yunyuntop.service.AdminService;
import com.yunyuntop.service.InfoService;
import com.yunyuntop.util.MD5Utils;




public class AdminLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if(request.getSession().getAttribute("trys")!=null&&(Integer)request.getSession().getAttribute("trys")>=3){
			
			response.sendRedirect("adminerror.jsp");
		}
		String aname=request.getParameter("aname");
		
		String apwd=request.getParameter("apwd");
		AdminService as=new AdminService();
		Admin admin=null;int trys;
		if((admin=as.loginadmin(MD5Utils.md5(apwd), aname))!=null){
			Info info =Info.getInstance();
			request.getServletContext().setAttribute("info",  info);request.getSession().setAttribute("trys", null);
			request.getSession().setAttribute("admin", admin);response.sendRedirect("admin/main.jsp");
		}else{
			if(request.getSession().getAttribute("trys")==null){
				trys=1;
				request.getSession().setAttribute("trys", trys);
			}else{
				trys=(Integer)request.getSession().getAttribute("trys");
				trys=trys+1;
				request.getSession().setAttribute("trys", trys);
			}if(trys>=3){response.sendRedirect("adminerror.jsp");}
			response.getWriter().print("<script>alert('name or pwd is error');location.href='"+request.getContextPath()+"/admin/login.jsp';</script>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
