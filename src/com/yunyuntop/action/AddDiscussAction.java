package com.yunyuntop.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.domain.Discuss;
import com.yunyuntop.domain.Info;
import com.yunyuntop.domain.User;
import com.yunyuntop.service.BlogsService;
import com.yunyuntop.service.DiscussService;
import com.yunyuntop.service.InfoService;

public class AddDiscussAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String bid = request.getParameter("bid");
		
		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			String message = request.getParameter("comment");System.out.println(message);
			//String dtime = String.format("%tF", new Date()) + " " + String.format("%tT", new Date());
			BlogsService bs = new BlogsService();
			Blogs blog = bs.findByBid(bid);
			
			Discuss discuss = new Discuss(null, blog, user, message);

			DiscussService ds = new DiscussService();
			ds.addDiscuss(discuss);
			blog.setDiscusscount(blog.getDiscusscount() + 1);
			bs.EditBlog(blog);	
			Info info = Info.getInstance();
			info.setDiscusscount(info.getDiscusscount() + 1);
			new InfoService().updateInfo(info);

			response.sendRedirect("sigleAction?bid=" + bid + "&maoname=maoname#comments");
			/* response.getWriter().print("{\"flag\":\"true\"}"); */
		} else {
			String mes[]=request.getParameterValues("comment");
			String message=null;
			if(mes!=null&&mes.length>0){
				message=mes[0];
			}
			System.out.println(message);
			request.getSession().setAttribute("commentinfo", message);
			request.getSession().setAttribute("bid", bid);
			response.getWriter().print("<script>alert('评论失败，请登录');location.href='login/index.jsp';</script>");
			/* response.getWriter().print("{\"flag\":\"false\"}"); */
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
