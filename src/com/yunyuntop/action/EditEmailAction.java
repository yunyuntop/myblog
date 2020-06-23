package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.User;
import com.yunyuntop.service.UserService;

public class EditEmailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		User user = (User) request.getSession().getAttribute("user");
		String val1 = (String) request.getSession().getAttribute("validate");
		String val2 = request.getParameter("val");
		if (user != null) {
			String uemail = request.getParameter("uemail");
			
			if(uemail!=null&&!uemail.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$")){
				response.getWriter().print("<script>alert('邮箱不正确');location.href='" + request.getContextPath()+"/blog/editemail.jsp';</script>");
				return;
			}
			UserService us = new UserService();
			if (us.findByEmail(uemail) == null||(us.findByEmail(uemail).getUemail().equals(user.getUemail()))) {
				if (uemail != null && uemail.length() > 0 && val1 != null && val1.equals(val2)) {

					user.setUemail(uemail);

					us.editUser(user);
				
					response.getWriter().print("<script>alert('已成功修改邮箱~');location.href='blog/userinfo.jsp';</script>");
					return;
				} else {
					response.getWriter().print("<script>alert('验证码不对啊');location.href='" + request.getContextPath()
							+ "/blog/editemail.jsp';</script>");

					return;
				}
			}
			else{response.getWriter().print("<script>alert('邮箱已被注册了');location.href='" + request.getContextPath()
						+ "/blog/editemail.jsp';</script>");

				return;
			}
			
		} else {
			response.getWriter().print("<script>alert('登录信息失效了');location.href='" + request.getContextPath()
					+ "/login/indexjsp';</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
