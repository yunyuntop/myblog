package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.service.BlogsService;
import com.yunyuntop.service.DiscussService;


public class AdminDisscussDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bid =request.getParameter("bid");
		String did=request.getParameter("did");
		String currPage=request.getParameter("currPage");
		DiscussService ds=new DiscussService();
		BlogsService bs=new BlogsService();
		ds.delete(did);
		Blogs up=bs.findByBid(bid);
		up.setDiscusscount(up.getDiscusscount()-1);
		bs.EditBlog(up);
		response.sendRedirect("adminDiscussFindAction?currPage="+currPage);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
