package com.yunyuntop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.domain.PageBean;
import com.yunyuntop.service.BlogsService;


public class AdminBlogFindAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BlogsService bs=new BlogsService();
		String currPage=request.getParameter("currPage");
		int currpage;
		try{
		currpage=Integer.parseInt(currPage);
		}catch(Exception e){
			currpage=1;
		}
		int size=10;
		int totalSize=(bs.findAll()).size();
		List<Blogs> adminbloglist=bs.findPageBlogs(currpage, size);
		PageBean<Blogs> pb=new PageBean<Blogs>(adminbloglist,currpage,size,totalSize);
		request.setAttribute("bean", pb);
		request.getRequestDispatcher("admin/managerBlog/list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
