package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.service.MessageService;


public class AdminMessageDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid=request.getParameter("mid");
		String currPage = request.getParameter("currPage");
		MessageService ms = new MessageService();
		ms.delMessage(mid);
		response.sendRedirect("adminMessageFindAction?currPage="+currPage);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
