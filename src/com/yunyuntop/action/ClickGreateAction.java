package com.yunyuntop.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.domain.Greate;
import com.yunyuntop.domain.Info;
import com.yunyuntop.domain.User;
import com.yunyuntop.service.BlogsService;
import com.yunyuntop.service.GreateService;
import com.yunyuntop.service.InfoService;

public class ClickGreateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null){
			BlogsService bs=new BlogsService();
			
		String bid=request.getParameter("bid");	
		
		GreateService gs=new GreateService();
		
		
		Greate greate2=gs.findGreate(user, new BlogsService().findByBid(bid));
		if(greate2==null){
			Blogs up=bs.findByBid(bid);
			up.setGreatecount(up.getGreatecount()+1);
			bs.EditBlog(up);
			Info info=Info.getInstance();
			info.setGreatecount(info.getGreatecount()+1);
			new InfoService().updateInfo(info);
			Greate greate=new Greate(null, user, up);
			gs.saveLike(greate);
			
			Integer count=gs.findSize(up);
			response.getWriter().print("[{\"flag\":\"add\"},{\"count\":\""+count+"\"}]");
		}else{
			Blogs dw=bs.findByBid(bid);
			dw.setGreatecount(dw.getGreatecount()-1);
			bs.EditBlog(dw);
			
			gs.delLike(greate2);
			Integer count=gs.findSize(dw);
			response.getWriter().print("[{\"flag\":\"del\"},{\"count\":\""+count+"\"}]");
		}}else{response.getWriter().print("[{\"flag\":\"none\"}]");}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
