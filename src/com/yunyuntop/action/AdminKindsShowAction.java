package com.yunyuntop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Kinds;
import com.yunyuntop.service.KindsService;


public class AdminKindsShowAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kid=request.getParameter("kid");
		KindsService ks=new KindsService();
		
		Kinds kind=ks.findKindsById(kid);
		request.setAttribute("kinds", kind);
		request.getRequestDispatcher("admin/managerKinds/update.jsp").forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
