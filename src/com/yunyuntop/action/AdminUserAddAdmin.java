package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Admin;
import com.yunyuntop.service.AdminService;
import com.yunyuntop.util.MD5Utils;

public class AdminUserAddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String aname = request.getParameter("aname");
		String apwd = request.getParameter("apwd");
		Admin admin;
		String pwd=MD5Utils.md5(apwd);
		admin = new Admin(null,aname,pwd);
		AdminService as= new AdminService();
		
		as.registeradmin(admin);
		response.getWriter().println("<script>alert('add ok');location.href='adminUserFindAdminAction';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
