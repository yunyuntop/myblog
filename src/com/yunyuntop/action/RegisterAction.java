package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.User;
import com.yunyuntop.service.UserService;
import com.yunyuntop.util.MD5Utils;


public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String uemail=request.getParameter("uemail");
		UserService us=new UserService();
		if(!username.matches("^[a-zA-Z_0-9]{6,15}$")){
			response.getWriter().print("<script>alert('用户名由字母或数字组成，6-15个字符之间');location.href='login/register.jsp';</script>");
			return;
		}
		if(!password.matches("^.{6,15}$")){
			response.getWriter().print("<script>alert('密码需要在6-15之间');location.href='login/register.jsp';</script>");
			return;

		}
		if(!uemail.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$")){
			response.getWriter().print("<script>alert('邮箱不正确');location.href='login/register.jsp';</script>");
			return;
		}
		if(uemail!=null&&uemail.length()>0&&us.findByEmail(uemail)==null){
		User user = new User();
		user.setPassword(MD5Utils.md5(password));
		user.setUsername(username);
		user.setUemail(uemail);
		us.add(user);
		request.setAttribute("uid", user.getUid());
		request.setAttribute("uemail", uemail);
		request.getRequestDispatcher("emailSendAction").forward(request, response);
		}else{
			response.getWriter().print("<script>alert('邮箱已注册，您可以选择登录，或者点击忘记密码！');location.href='login/register.jsp';</script>");
		}
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
