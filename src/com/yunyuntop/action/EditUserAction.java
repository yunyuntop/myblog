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

public class EditUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");

		response.setContentType("text/html;charset=utf-8");
		UserService us = new UserService();

		String username = request.getParameter("username");
		if (user != null) {
			if (!username.matches("^[a-zA-Z_0-9]{6,15}$")) {
				response.getWriter()
						.print("<script>alert('用户名由字母或数字组成，6-15个字符之间');location.href='blog/edit.jsp';</script>");
				return;
			}

			if (us.findByName(username) == null || us.findByName(username).getUsername().equals(user.getUsername())) {
				String uinfo = request.getParameter("uinfo");

				String uphone = request.getParameter("uphone");

				user.setUinfo(uinfo);
				user.setUsername(username);
				user.setUphone(uphone);

				us.editUser(user);
				Cookie autoLogin = CookUtils.getCookieByName("autoLogin", request.getCookies());
				Cookie remmberme = CookUtils.getCookieByName("username", request.getCookies());
				if (autoLogin != null) {
					autoLogin.setPath(request.getContextPath() + "/");
					autoLogin.setMaxAge(0);
					response.addCookie(autoLogin);
				}
				if (remmberme != null) {
					remmberme.setPath(request.getContextPath() + "/");
					remmberme.setMaxAge(0);
					response.addCookie(remmberme);
				}
				response.sendRedirect("blog/userinfo.jsp");
			} else {
				response.getWriter().print("<script>alert('用户名不可用！');location.href='blog/edit.jsp';</script>");
				return;
			}
		} else {
			response.getWriter().print("<script>alert('登录信息无效！');location.href='login/index.jsp';</script>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
