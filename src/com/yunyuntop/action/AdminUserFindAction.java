package com.yunyuntop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.PageBean;
import com.yunyuntop.domain.User;
import com.yunyuntop.service.UserService;


public class AdminUserFindAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService us=new UserService();
		
		String currpage =  request.getParameter("currPage");
		int currPage;
		int size=10;
		int totalSize=us.findTotalSize();
		if(currpage!=null&&currpage.length()>0){
			
			currPage=Integer.parseInt(currpage);
		}else{
			currPage=1;
		}
		List<User> list=us.findAllByUtime(size,currPage);
		PageBean<User> pb=new PageBean<User>(list, currPage, size, totalSize);
		request.setAttribute("bean", pb);
		request.getRequestDispatcher("admin/managerUser/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
