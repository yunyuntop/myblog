package com.yunyuntop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.domain.Kinds;
import com.yunyuntop.service.BlogsService;
import com.yunyuntop.service.KindsService;

public class SelectAllAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 BlogsService bs=new BlogsService();
		 KindsService ks=new KindsService();
		 List<Blogs> list=bs.findNewBlogs();
		 List<Blogs> feature=bs.findFeatureBlogs();
		 List<Kinds> kinds=ks.findAllTag();
		 request.getServletContext().setAttribute("kindslist", kinds);
		 request.getServletContext().setAttribute("featurelist", feature);
		 request.getServletContext().setAttribute("newbloglist", list);
		 request.getRequestDispatcher("blog/index.jsp").forward(request,
		 response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
