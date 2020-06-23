package com.yunyuntop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Message;
import com.yunyuntop.service.MessageService;
import com.yunyuntop.util.JsonUtil;

public class FindMessageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currPage;
		response.setContentType("text/html;charset=utf-8");
		try{
			currPage=Integer.parseInt(request.getParameter("currPage"));
		}catch(NumberFormatException e){
			currPage=2;
		}
		int size=4;
		MessageService ms=new MessageService();
		List<Message> list = ms.findByPage(size, currPage);
		String json=JsonUtil.list2json(list);
		System.out.println(json);
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
