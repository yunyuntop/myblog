package com.yunyuntop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Greate;
import com.yunyuntop.domain.Info;
import com.yunyuntop.domain.PageBean;
import com.yunyuntop.service.GreateService;
import com.yunyuntop.service.InfoService;

public class AdminGreateFindAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Info info=Info.getInstance();
		info.setGreatecount(0);
	
		InfoService is=new InfoService();
		
		is.updateInfo(info);
		int currPage;
		String currpage = request.getParameter("currPage");
		try {
			currPage = Integer.parseInt(currpage);
		} catch (Exception e) {
			currPage = 1;
		}
		GreateService gs = new GreateService();
		int size = 8;
		int totalSize = gs.findCount();

		
		
		List<Greate> list = gs.findPage(currPage, totalSize);
		PageBean<Greate> pb = new PageBean<Greate>(list, currPage, size, totalSize);
		request.setAttribute("bean", pb);
		request.getRequestDispatcher("admin/managerDiscuss/likelist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
