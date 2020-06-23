package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.User;
import com.yunyuntop.service.UserService;

public class AdminUserUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uid = request.getParameter("uid");
		String username = request.getParameter("username");
		String uemail = request.getParameter("ueamil");
		String uphone = request.getParameter("uphone");
		String ustate = request.getParameter("ustate");

		UserService us = new UserService();
		User user = us.findByUid(uid);
		user.setUsername(username);
		user.setUemail(uemail);
		user.setUphone(uphone);
		int ustate1;
		try {
			ustate1 = Integer.parseInt(ustate);
		} catch (Exception x) {
			ustate1 = 0;
		}

		user.setUstate(ustate1);
		response.setContentType("text/html;charset=utf-8");
		us.editUser(user);
		response.getWriter().print("<script>alert('修改成功！');location.href='adminUserFindAction';</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
