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
import com.yunyuntop.util.MD5Utils;


public class EditPWDAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		String pwd1=request.getParameter("pwdold");
		String pwd2=request.getParameter("pwdnew");
		UserService us=new UserService();
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null){
			
			
			if(pwd2!=null&&!pwd2.matches("^.{6,15}$")){
				response.getWriter().print("<script>alert('密码需要在6-15之间');location.href='blog/edit.jsp';</script>");
				return;

			}
			String username=user.getUsername();
			if(us.login(username, MD5Utils.md5(pwd1))!=null){
				user.setPassword(MD5Utils.md5(pwd2));
				us.editUser(user);
				request.getSession().setAttribute("user", null);
				Cookie autoLogin = CookUtils.getCookieByName("autoLogin", request.getCookies());
				Cookie remmberme = CookUtils.getCookieByName("username", request.getCookies());
				if(autoLogin!=null){
					autoLogin.setPath(request.getContextPath() + "/");
					autoLogin.setMaxAge(0 );
					response.addCookie(autoLogin);
					}
				if(remmberme!=null){
					remmberme.setPath(request.getContextPath() + "/");
					remmberme.setMaxAge(0 );
					response.addCookie(remmberme);
					}
				response.getWriter().print("<script>alert('修改成功，请用新密码再次登录');location.href='login/index.jsp';</script>");

			}else{
				response.getWriter().print("<script>alert('原密码错误。');location.href='blog/editpwd.jsp';</script>");	
			}
		}else{
			response.getWriter().print("<script>alert('用户信息失效，请登录');location.href='login/index.jsp';</script>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
