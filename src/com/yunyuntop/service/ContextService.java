package com.yunyuntop.service;




import com.yunyuntop.dao.ContextDao;
import com.yunyuntop.domain.Context;


public class ContextService {
	public void delete(String cid){
		new ContextDao().delete(cid);
	}
	public String add(Context context){
		return new ContextDao().add(context);
	}
	
	public void update(Context context){
		
		new ContextDao().update(context);
	}
	public  Context findBlogContext(String bid){
	return new ContextDao().findBlogContext(bid);

	}
}
