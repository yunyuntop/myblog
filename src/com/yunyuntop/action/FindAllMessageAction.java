package com.yunyuntop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Message;
import com.yunyuntop.domain.PageBean;
import com.yunyuntop.service.MessageService;


public class FindAllMessageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MessageService ms=new MessageService();
		int size=4;
		int currPage;
		try{
			currPage=Integer.parseInt(request.getParameter("currPage"));
		}catch(NumberFormatException e){
			currPage=1;
		}
		int totalSize=ms.findCount();
		List<Message> list=ms.findByPage(size, currPage); 
		PageBean<Message> pb=new PageBean<Message>(list, currPage, size, totalSize);
		request.setAttribute("bean", pb);
		request.getRequestDispatcher("blog/message.jsp").forward(request, response);;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
