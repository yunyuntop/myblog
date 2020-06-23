package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.User;
import com.yunyuntop.service.UserService;

public class AdminUserShowAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		String currPage=request.getParameter("currPage");
		UserService us=new UserService();
		User user=us.findByUid(uid);
		request.setAttribute("currPage", currPage);
		request.setAttribute("user", user);
		request.getRequestDispatcher("admin/managerUser/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
