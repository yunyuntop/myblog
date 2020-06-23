package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.service.BlogsService;


public class AdminBlogDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String bid=request.getParameter("bid");
		String currPage=request.getParameter("currPage");
		BlogsService bs=new BlogsService();
		bs.deleteBlog(bid);
		response.sendRedirect("adminBlogFindAction?currPage="+currPage);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
