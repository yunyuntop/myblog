package com.yunyuntop.service;

import java.util.List;

import com.yunyuntop.dao.BlogsDao;
import com.yunyuntop.domain.Blogs;

public class BlogsService {
	public List<Blogs> findNewBlogs() {
		return new BlogsDao().findNewBlogs();
	}

	public List<Blogs> findByKtext(String ktext) {
		return new BlogsDao().findByKtext(ktext);
	}

	public List<Blogs> findAll() {
		return new BlogsDao().findAll();
	}

	public Blogs findByBid(String bid) {
		return new BlogsDao().findByBid(bid);
	}

	public String writeBlog(Blogs blog) {
		return new BlogsDao().writeBlog(blog);

	}

	public void deleteBlog(String bid) {
		ContextService cs=new ContextService();
		if(cs.findBlogContext(bid)!=null)
		cs.delete(cs.findBlogContext(bid).getCid());
		new BlogsDao().deleteBlog(bid);

	}

	public void EditBlog(Blogs blog) {
		new BlogsDao().EditBlog(blog);
	}
	
	public List<Blogs> findPageBlogs(Integer currPage,Integer size) {
	return new BlogsDao().findPageBlogs(currPage, size)	;
	}

	public List<Blogs> findLikeContext(String context) {
        return new BlogsDao().findLikeContext(context);		
	}

	public List<Blogs> findFeatureBlogs() {
		
		return new BlogsDao().findFeatureBlogs();
	}
	
	public void updateTotallook(String bid){
		
		new BlogsDao().updateTotallook(bid);
	}
}
