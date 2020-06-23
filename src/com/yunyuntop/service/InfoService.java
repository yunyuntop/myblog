package com.yunyuntop.service;

import java.util.List;

import com.yunyuntop.dao.InfoDao;
import com.yunyuntop.domain.Info;

public class InfoService {

	public void updateInfo( Info info){
		new InfoDao().updateInfo(info);
	}
	public void insertInfo( Info info){
		new InfoDao().insertInfo(info);
	}
	public Info findInfo( String iid){
		return new InfoDao().findInfo(iid);
	}
	public List<Info> find() {
		return new InfoDao().find();
	}
	public void deleteInfo( String iid){
		new InfoDao().deleteInfo(iid);
	}
	
}
