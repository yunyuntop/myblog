package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.User;
import com.yunyuntop.service.UserService;


public class AdminUserDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currPage=request.getParameter("currPage");
		String uid=request.getParameter("uid");
		User user=null;
		UserService us = new UserService();
		user=us.findByUid(uid);
		us.delete(user);
		response.sendRedirect("adminUserFindAction?currPage="+currPage);
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
