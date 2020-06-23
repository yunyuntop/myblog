package com.yunyuntop.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.util.CookUtils;

public class OutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().setAttribute("user", null);
		Cookie autoLogin = CookUtils.getCookieByName("autoLogin", request.getCookies());
		if(autoLogin!=null){
		autoLogin.setPath(request.getContextPath() + "/");
		autoLogin.setMaxAge(0 );
		response.addCookie(autoLogin);
		}
		response.sendRedirect("login/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
