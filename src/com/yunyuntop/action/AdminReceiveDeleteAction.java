package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.service.ReceiveService;

public class AdminReceiveDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currPage=request.getParameter("currPage");
		String rid=request.getParameter("rid");
		ReceiveService rs=new ReceiveService();
		rs.delete(rid);
		response.sendRedirect("adminDiscussFindAction?currPage="+currPage);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
