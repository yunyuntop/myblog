package com.yunyuntop.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yunyuntop.domain.Info;
import com.yunyuntop.domain.Message;
import com.yunyuntop.service.InfoService;
import com.yunyuntop.service.MessageService;

public class MessageSubmitAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		Message message = new Message();

		message.setEmail(request.getParameter("email"));
		message.setMessage(request.getParameter("message"));
		message.setRealname(request.getParameter("realname"));

		MessageService ms = new MessageService();
		Info info=Info.getInstance();
		info.setMessagecount(info.getMessagecount()+1);
		new InfoService().updateInfo(info);
		ms.addMessage(message);

		response.sendRedirect("findAllMessageAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
