package com.yunyuntop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Discuss;
import com.yunyuntop.domain.Info;
import com.yunyuntop.domain.PageBean;
import com.yunyuntop.service.DiscussService;
import com.yunyuntop.service.InfoService;


public class AdminDiscussFindAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Info info=Info.getInstance();
		info.setDiscusscount(0);
	
		InfoService is=new InfoService();
		
		is.updateInfo(info);
		int currPage;
		String currpage=request.getParameter("currPage");
		try{
			currPage=Integer.parseInt(currpage);
		}catch(Exception e){
			currPage=1;
		}
		int size=5+1;
		int totalSize=new DiscussService().findSize();
		
		List<Discuss> list= new DiscussService().findByDtime(currPage,size);
		PageBean<Discuss> pb=new PageBean<Discuss>(list, currPage, size, totalSize);
		request.setAttribute("bean", pb);
		request.getRequestDispatcher("admin/managerDiscuss/list.jsp").forward(request, response);;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
