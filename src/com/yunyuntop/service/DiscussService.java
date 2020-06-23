package com.yunyuntop.service;

import java.util.List;

import com.yunyuntop.dao.DiscussDao;
import com.yunyuntop.domain.Discuss;

public class DiscussService {

	public void addDiscuss(Discuss discuss){
		
		
		new DiscussDao().addDiscuss(discuss);
	}public List<Discuss> findByDtime(int currPage,int size) {
		return new DiscussDao().findByDtime(currPage,size); 
	}

	public List<Discuss> findAllByBid(String bid) {
		
		return new DiscussDao().findAllByBid(bid);
	}
	public int findSize() {
		
		return new DiscussDao().findSize();
	}
	public void delete(String did) {
		 new DiscussDao().delete(did);
		
	}
	public Discuss findByDid(String did) {
		
		return new DiscussDao().findByDid(did);
	}
}
