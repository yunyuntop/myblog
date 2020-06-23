package com.yunyuntop.action;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.User;
import com.yunyuntop.service.UserService;
import com.yunyuntop.util.MailUtils;


public class NewEmailCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uemail = request.getParameter("uemail");
		UserService us=new UserService();
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null){
			if(!uemail.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$")){
				response.getWriter().print("{\"name\":\"0\"}");
				return;
			}
		if(us.findByEmail(uemail)==null||us.findByEmail(uemail).getUemail().equals(user.getUemail())){
		String validate = "";
		for(int i=0;i<4;i++){
			
			validate+=(int) (Math.random() * 10);
		}
		
		try {
			MailUtils.sendMail(uemail, "验证码是" + validate + "谁问都不许告诉他！！！！", "修改邮箱验证");
		} catch (MessagingException e) {
			e.printStackTrace();
			response.getWriter().print("{\"name\":\"0\"}");
			return;
		}

		request.getSession().setAttribute("validate", validate);
		response.getWriter().print("{\"name\":\"1\"}");
		}else{
			response.getWriter().print("{\"name\":\"none\"}");
			return;
		}}else{
			response.getWriter().print("{\"name\":\"login\"}");
			return;
		}

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
