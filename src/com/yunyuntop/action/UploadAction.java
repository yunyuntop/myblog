package com.yunyuntop.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.yunyuntop.domain.User;
import com.yunyuntop.service.UserService;
import com.yunyuntop.util.UploadUtils;



public class UploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		User user=(User) request.getSession().getAttribute("user");
		response.setContentType("text/html;charset=utf-8");
		if(user!=null){
			List<FileItem> list;
			try {
				list = upload.parseRequest(request);
			
			for(FileItem fi:list){
				
					String name=fi.getName();
					if(name.substring(name.lastIndexOf(".")+1).equalsIgnoreCase("jpg")||name.substring(name.lastIndexOf(".")+1).equalsIgnoreCase("jpeg")){
					String realName=UploadUtils.getRealName(name);
					String uuidname=UploadUtils.getUUIDName(realName);
					
					String path=this.getServletContext().getRealPath("blog/icon");
					InputStream is=fi.getInputStream();
					FileOutputStream os=new FileOutputStream(new File(path,uuidname));
					IOUtils.copy(is, os);
					fi.delete();
					
					String uimg="/icon/"+uuidname;					
					is.close();
					os.close();
					user.setUimg(uimg);
					UserService us = new UserService();
					us.editUser(user);
					request.getSession().setAttribute("user",user);
					response.sendRedirect("blog/userinfo.jsp");
					}else{
						response.getWriter().print("<script>alert('文件格式错误');location.href='blog/upload.jsp';</script>");
						return;
					}
			    }
			    } catch (FileUploadException e) {
				
				e.printStackTrace();
				response.getWriter().print("<script>alert('修改头像失败啦');location.href='blog/upload.jsp';</script>");
				return;
			    }
		  }else{
			response.getWriter().print("<script>alert('用户信息竟然失效了');location.href='"+request.getContextPath()+"login/index.jsp';</script>");
			return;	
		   }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
