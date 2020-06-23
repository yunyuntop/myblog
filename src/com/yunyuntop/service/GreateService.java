package com.yunyuntop.service;

import java.util.List;

import com.yunyuntop.dao.GreateDao;
import com.yunyuntop.domain.Blogs;
import com.yunyuntop.domain.Greate;
import com.yunyuntop.domain.User;

public class GreateService {

	public List<Greate> findPage(int currPage,int size){
		
		return new GreateDao().findPage(currPage,size);
	}
    public void saveLike(Greate greate){
		
		new GreateDao().saveLike(greate);
		
	}
	
	public void delLike(Greate greate){
		new GreateDao().delLike(greate);
	}
	
	public Greate findLikeByGid(String gid){
		
		return new GreateDao().findLikeByGid(gid);
	}
	
	public Greate findGreate(User user, Blogs blog) {
		
		return new GreateDao().findGreate(user, blog);
	}
	
	
	public int findSize(Blogs blog){
		return new GreateDao().findSize(blog);
	}

	public int findCount() {
		
		return new GreateDao().findCount();
	}
	public void delete(String gid) {
		new GreateDao().delete(gid);
		
	}
}
