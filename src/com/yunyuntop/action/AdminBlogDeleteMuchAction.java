package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.service.BlogsService;

public class AdminBlogDeleteMuchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] bids=request.getParameterValues("checkBid");
		BlogsService bs=new BlogsService();
		if(bids!=null){
		for(int i=0;i<bids.length;i++){
			bs.deleteBlog(bids[i]);
		}}response.sendRedirect("adminBlogFindAction");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
