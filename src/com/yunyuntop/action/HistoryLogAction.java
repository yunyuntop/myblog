package com.yunyuntop.action;

import java.io.IOException;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.service.BlogsService;
import com.yunyuntop.util.CookUtils;
import com.yunyuntop.util.JsonUtil;


public class HistoryLogAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		List<String> ls =CookUtils.getCookieHistoryLogByName("historyLook", request.getCookies());
		BlogsService bs=new BlogsService();
		List<Blogs> blogs = new LinkedList<Blogs>();
		for(int i=0;i<ls.size();i++){
			Blogs blog=bs.findByBid(ls.get(i));
			if(blog!=null)
			blogs.add(blog);
		}
		if(blogs!=null&&blogs.size()>0){
		response.getWriter().print("[");
		for(int i=blogs.size()-1;i>=0;i--){
			response.getWriter().print("{\"bid\":\""+blogs.get(i).getBid()+"\",\"btitle\":\""+blogs.get(i).getBtitle()+"\"}");
			//System.out.println(blogs.get(i) );
			response.getWriter().print(i==0?"":",");
		}response.getWriter().print("]");}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
