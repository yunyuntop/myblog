package com.yunyuntop.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Kinds;
import com.yunyuntop.service.KindsService;


public class AdminKindsAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		KindsService ks=new KindsService();
		
		String ktext=request.getParameter("ktext");
		Kinds kind=new Kinds(null,ktext);
		ks.addKinds(kind);
		response.sendRedirect("adminKindsFindAction");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
