package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.service.KindsService;


public class AdminKindsDeleteMuchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] kids=request.getParameterValues("checkKid");
		KindsService ks=new KindsService();
		if(kids!=null){
		for(int i=0;i<kids.length;i++){
			ks.delete(kids[i]);
		}}response.sendRedirect("adminKindsFindAction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
