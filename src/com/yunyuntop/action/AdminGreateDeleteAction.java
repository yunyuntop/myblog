package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.service.BlogsService;
import com.yunyuntop.service.GreateService;


public class AdminGreateDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		String bid=request.getParameter("bid");
		String gid=request.getParameter("gid");
		String currPage=request.getParameter("currPage");
		GreateService gs=new GreateService();
		gs.delete(gid);
		BlogsService bs=new BlogsService();
		Blogs up=bs.findByBid(bid);
		up.setGreatecount(up.getGreatecount()-1);
		bs.EditBlog(up);
		response.sendRedirect("adminGreateFindAction?currPage="+currPage);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
