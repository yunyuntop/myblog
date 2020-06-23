package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.domain.Context;
import com.yunyuntop.service.BlogsService;
import com.yunyuntop.service.ContextService;


public class AdminBlogShowAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String bid=request.getParameter("bid");
		String currPage=request.getParameter("currPage");
		BlogsService bs=new BlogsService();
		ContextService cs=new ContextService();
		Blogs b=bs.findByBid(bid);
		Context c=cs.findBlogContext(bid);
		request.setAttribute("currPage",currPage);
		request.setAttribute("adminblog", b);
		request.setAttribute("admincontext", c);
		request.getRequestDispatcher("admin/managerBlog/update.jsp").forward(request, response);;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
