package com.yunyuntop.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.domain.Context;
import com.yunyuntop.service.BlogsService;
import com.yunyuntop.service.ContextService;
import com.yunyuntop.util.UploadUtils;

import net.sf.json.JSONObject;

public class AdminAddBlogImgAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject jb = new JSONObject();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> list = null;
		try {
			list = upload.parseRequest(request);
			for (FileItem f : list) {
				if (!(f.isFormField())) {
					String name = f.getName();
					String realName = UploadUtils.getRealName(name);
					String uuidname = UploadUtils.getUUIDName(realName);
					String path = this.getServletContext().getRealPath("blog/img/");
					
					FileOutputStream os = new FileOutputStream(new File(path, uuidname));
					f.write(new File(path, uuidname));
					
					
					os.close();
					jb.put("error", 0);
					jb.put("url", request.getContextPath() + "/blog/img/" + uuidname);
					response.getWriter().print(jb.toString());
				}
			}

		} catch (Exception e) {
			JSONObject obj = new JSONObject();
			obj.put("error", 1);
			obj.put("message", "上传不成功");
			response.getWriter().print(jb.toString());
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
