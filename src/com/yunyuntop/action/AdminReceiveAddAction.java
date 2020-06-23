package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Receive;
import com.yunyuntop.service.DiscussService;
import com.yunyuntop.service.ReceiveService;


public class AdminReceiveAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		Receive receive=new Receive();
		String currpage=request.getParameter("currPage");
		String rtext=request.getParameter("rtext");
		receive.setRtext(rtext);
		String did=request.getParameter("did");
		ReceiveService rs = new ReceiveService();
		receive.setRid(did);
		rs.writeReceive(receive); 
		response.sendRedirect("adminDiscussFindAction?currPage="+currpage);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
