package com.yunyuntop.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.yunyuntop.domain.Kinds;
import com.yunyuntop.service.BlogsService;
import com.yunyuntop.service.ContextService;
import com.yunyuntop.service.KindsService;
import com.yunyuntop.util.UploadUtils;

public class AdminBlogUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		Map<String, String> map = new HashMap<String, String>();
		List<FileItem> list = null;
		List<String> ktext = new LinkedList<String >();
		try {
			list = upload.parseRequest(request);
			for (FileItem f : list) {
				if (f.isFormField()) {
					if(f.getFieldName().equals("ktext")){
					ktext.add(f.getString("utf-8"));
					}else
					map.put(f.getFieldName(), f.getString("utf-8"));
				} else {
					String name = f.getName();
					/*if (name.length() > 0) {*/
						String realName = UploadUtils.getRealName(name);
						String uuidname = UploadUtils.getUUIDName(realName);
						String path = this.getServletContext().getRealPath("blog/img/");
						InputStream is = f.getInputStream();

						OutputStream os = new FileOutputStream(new File(path, uuidname));

						map.put(f.getFieldName(), "/img/" + uuidname);
						IOUtils.copy(is, os);
						os.close();

						is.close();
					}

				/*}*/
			}
		} catch (FileUploadException e)

		{
			e.printStackTrace();
		}

		String currpage = map.get("currPage");
		int currPage;
		try

		{
			currPage = Integer.parseInt(currpage);
		} catch (

		Exception e)

		{
			currPage = 1;
		}

		Blogs blog = new Blogs();
		ContextService cs = new ContextService();
		KindsService ks=new KindsService();
		Context context = new Context();
		Set<Kinds> kindsSet=new HashSet<Kinds>();
		blog.setBtitle(map.get("btitle"));
		blog.setBheader(map.get("bheader"));
		blog.setBimg(map.get("bimg"));
		String text = map.get("context");

		for (String k : ktext) {
			Kinds kinds=ks.findKindsByText(k);
			if(kinds!=null){
				kindsSet.add(kinds);
				
			}else{
				Kinds kind=ks.addKinds(new Kinds(null, k));
				kindsSet.add(kind);
			}
		}
		blog.setKindsSet(kindsSet);
		context.setContext(text);
		String cid = cs.add(context);
		blog.setCid(cid);
		BlogsService bs = new BlogsService();
		String bid = bs.writeBlog(blog);
		context.setBid(bid);
		cs.update(context);
		response.sendRedirect("adminBlogFindAction?currPage=" + currPage);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
