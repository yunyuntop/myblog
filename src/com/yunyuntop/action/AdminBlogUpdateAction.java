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

public class AdminBlogUpdateAction extends HttpServlet {
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
					if (f.isFormField()) {
						if(f.getFieldName().equals("ktext")){
						ktext.add(f.getString("utf-8"));
						}else{
						map.put(f.getFieldName(), f.getString("utf-8"));}
					}
				} else {
					String name = f.getName();
					if(name.substring(name.lastIndexOf(".")+1).equals("jpg")||name.substring(name.lastIndexOf(".")+1).equals("jpeg")){
						String realName = UploadUtils.getRealName(name);
						String uuidname = UploadUtils.getUUIDName(realName);
						String path = this.getServletContext().getRealPath("blog/img/");
						InputStream is = f.getInputStream();
						OutputStream os = new FileOutputStream(new File(path, uuidname));
						IOUtils.copy(is, os);
						is.close();
						os.close();
						map.put(f.getFieldName(), "/img/" + uuidname);
						
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		String bid = map.get("bid");
		BlogsService bs = new BlogsService();
		ContextService cs = new ContextService();
		Context c = cs.findBlogContext(bid);
		KindsService ks=new KindsService();
		Set<Kinds> kindsSet=new HashSet<Kinds>();
		Blogs b = bs.findByBid(bid);
		b.setBheader(map.get("bheader"));
		b.setAuthor(map.get("author"));
		b.setBtitle(map.get("btitle"));
		if (map.get("bimg") == null) {
			b.setBimg(map.get("bimg1"));
		} else {
			b.setBimg(map.get("bimg"));
		}
		String context=map.get("context");
		
		for (String k : ktext) {
			Kinds kinds=ks.findKindsByText(k);
			if(kinds!=null){
				kindsSet.add(kinds);
				
			}else{
				Kinds kind=ks.addKinds(new Kinds(null, k));
				kindsSet.add(kind);
			}
		}
		b.setKindsSet(kindsSet);
		if (c != null && c.getBid() != null){
			c.setContext(context);
			}else{c=new Context(null,context,bid);}cs.update(c);
		bs.EditBlog(b);
		String currPage = map.get("currPage");
		response.sendRedirect("adminBlogFindAction?currPage=" + currPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
