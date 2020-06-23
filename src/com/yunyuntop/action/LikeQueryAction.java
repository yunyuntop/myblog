package com.yunyuntop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.service.BlogsService;


public class LikeQueryAction extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String context = request.getParameter("name");
		BlogsService bs=new BlogsService();
		
		List<Blogs > list=bs.findLikeContext(context);
		request.setAttribute("searchblog", list);
		System.out.println(list);
		request.getRequestDispatcher("blog/search.jsp").forward(request, response);

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

}
