package com.yunyuntop.action;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.util.MailUtils;


public class EmailSendAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid=(String)request.getAttribute("uid");
		String uemail=(String)request.getAttribute("uemail");
		response.setContentType("text/html;charset=utf-8");
		try {
			MailUtils.sendMail(uemail, "欢迎加入我们，请点击<a href='http://39.106.191.12/activeAction?uid="+uid+"'>激活</a>，验证成功后方可登录","账户激活");
		} catch (MessagingException e) {
			e.printStackTrace();
			response.getWriter().print("<script>alert('注册失败，邮件发送失败');location.href='login/register.jsp';</script>");
			
		}
		
		response.getWriter().print("<script>alert('注册成功，您需要先去邮箱激活账号后才能正常登录~');location.href='login/index.jsp';</script>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
