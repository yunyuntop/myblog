package com.yunyuntop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.domain.Context;
import com.yunyuntop.domain.Discuss;
import com.yunyuntop.domain.Greate;
import com.yunyuntop.domain.User;
import com.yunyuntop.service.BlogsService;
import com.yunyuntop.service.ContextService;
import com.yunyuntop.service.DiscussService;
import com.yunyuntop.service.GreateService;
import com.yunyuntop.util.CookUtils;



public class SigleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bid=request.getParameter("bid");
		if(bid==null){
			bid=(String)request.getAttribute("bid");
		}
		BlogsService bs=new BlogsService();
		ContextService cs=new ContextService();
		DiscussService ds = new DiscussService();		
		Context context =cs.findBlogContext(bid);
		GreateService gs=new GreateService();
		User user= null;
		user=(User)request.getSession().getAttribute("user");
		String img="/img/greatedel.jpg";
		String maoname=request.getParameter("maoname");
		if(user!=null){
		Greate greate=gs.findGreate(user, new BlogsService().findByBid(bid));
		if(greate!=null){
			img="/img/greateadd.jpg";
		}
		}
		if(maoname==null){
			bs.updateTotallook(bid);
		}
		Blogs blogs=bs.findByBid(bid);
		int count=gs.findSize(blogs);
		List<Discuss> discusslist=ds.findAllByBid(bid);
		if(CookUtils.getCookieHistoryLogByName("historyLook"+bid, request.getCookies()).size()>0){
			
			Cookie cookie = new Cookie("historyLook"+bid,null );
			cookie.setMaxAge(3000);
			cookie.setPath(request.getContextPath()+"/");
			response.addCookie(cookie);
			
		}
		Cookie cookie = new Cookie("historyLook"+bid,blogs.getBid() );
		cookie.setMaxAge(72*60*1000);
		cookie.setPath(request.getContextPath()+"/");
		response.addCookie(cookie);
		request.setAttribute("context", context);
		request.setAttribute("blog", blogs);
		request.setAttribute("discusslist", discusslist);
		request.setAttribute("img", img);
		request.setAttribute("count", count);
		request.getRequestDispatcher("blog/single.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
