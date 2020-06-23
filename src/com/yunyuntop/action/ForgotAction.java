package com.yunyuntop.action;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.service.UserService;
import com.yunyuntop.util.MailUtils;

public class ForgotAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uemail = request.getParameter("uemail");
		
		if(!uemail.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$")){
			response.getWriter().print("{\"name\":\"fail\"}");
			return;
		}
		UserService us=new UserService();
		if(us.findByEmail(uemail)==null){
			response.getWriter().print("{\"name\":\"none\"}");
			return;
		}
		String validate = "";
		for(int i=0;i<4;i++){
			
			validate+=(int) (Math.random() * 10);
		}
		
		try {
			MailUtils.sendMail(uemail, "验证码是" + validate + "谁问都不许告诉他！！！！", "邮箱验证码");
		} catch (MessagingException e) {
			e.printStackTrace();
			response.getWriter().print("{\"name\":\"false\"}");
			return;
		}

		request.getSession().setAttribute("validate", validate);
		response.getWriter().print("{\"name\":\"true\"}");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
