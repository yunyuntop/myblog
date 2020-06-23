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
import com.yunyuntop.util.JsonUtil;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;


public class HistoryPostAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currPage1=request.getParameter("currPage");
		response.setContentType("text/html;charset=utf-8");
		if(currPage1!=null&&!currPage1.equals("")){
			Integer currPage=Integer.parseInt(currPage1);
			BlogsService bs=new BlogsService();
			Integer totalSize=bs.findAll().size();
			Integer size=6;
			List<Blogs> list=bs.findPageBlogs(currPage, size);
			PageBean<Blogs> pb=new PageBean<Blogs>(list,currPage,size,totalSize);
			System.out.println(pb.getTotalPage()+"页");
			System.out.println(currPage1+"页");
			if(currPage<=pb.getTotalPage()){
				response.getWriter().print("[");
				for(int i=0;i<list.size();i++){
					response.getWriter().print("{\"bid\":\""+list.get(i).getBid()+"\",\"btitle\":\""+list.get(i).getBtitle()+"\",\"btime\":\""+list.get(i).getBtime()+"\",\"bheader\":\""+(list.get(i).getBheader()==null?"": list.get(i).getBheader())+"\",\"bimg\":\""+list.get(i).getBimg()+"\"}");
					response.getWriter().print(i==list.size()-1?"":",");
				}response.getWriter().print("]");
			}
			
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
