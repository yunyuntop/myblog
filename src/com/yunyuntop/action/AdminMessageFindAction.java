package com.yunyuntop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Info;
import com.yunyuntop.domain.Message;
import com.yunyuntop.domain.PageBean;
import com.yunyuntop.service.InfoService;
import com.yunyuntop.service.MessageService;


public class AdminMessageFindAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Info info=Info.getInstance();
		info.setMessagecount(0);
	
		InfoService is=new InfoService();
		
		is.updateInfo(info);
		Integer size=4;
		MessageService ms=new MessageService();
		List<Message> list=null;
		PageBean<Message> pb=null;		
		String currPage=request.getParameter("currPage");int currpage;
		if(currPage==null||currPage.length()<=0){
			currpage=0;
		}else{
			currpage=Integer.parseInt(currPage);
		}		
		list=ms.findByPage(size,currpage);
		Integer totalSize=ms.findCount();		
		pb =  new PageBean<Message>(list, currpage, size, totalSize);
		request.setAttribute("bean", pb);
		request.getRequestDispatcher("admin/managerMessage/list.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
