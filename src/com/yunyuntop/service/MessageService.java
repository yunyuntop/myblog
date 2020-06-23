package com.yunyuntop.service;

import java.util.List;



import com.yunyuntop.dao.MessageDao;
import com.yunyuntop.domain.Message;

public class MessageService {

	public void addMessage(Message me){
		
		new MessageDao().addMessage(me);
	}
	
	public List<Message> findAll(){
		return new MessageDao().findAll();
		
	}
	
	
	public void  delMessage(String mid){
		
		new MessageDao().delMessage(mid);
	}
	
	public Integer findCount(){
		return new MessageDao().findCount();
	}

	public List<Message> findByPage(Integer size,Integer currPage) {
		return new MessageDao().findByPage(size,currPage);
	}
}
