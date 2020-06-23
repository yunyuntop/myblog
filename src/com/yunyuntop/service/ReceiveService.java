package com.yunyuntop.service;

import com.yunyuntop.dao.ReceiveDao;
import com.yunyuntop.domain.Receive;

public class ReceiveService {

	public Receive findByRid(String rid){
		return new ReceiveDao().findByRid(rid);
	}
		public void writeReceive(Receive receive){
	
		new ReceiveDao().writeReceive(receive);
	}
	public void delete(String rid){
		new ReceiveDao().delete(rid);
	}
}
