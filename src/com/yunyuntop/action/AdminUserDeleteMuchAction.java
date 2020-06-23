package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.service.UserService;


public class AdminUserDeleteMuchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uids=request.getParameterValues("checkUid");
		UserService us=new UserService();
		if(uids!=null){
		for(int i=0;i<uids.length;i++){
			us.delete(us.findByUid(uids[i]));
		}}response.sendRedirect("adminUserFindAction");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
