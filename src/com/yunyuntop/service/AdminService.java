package com.yunyuntop.service;

import java.util.List;

import com.yunyuntop.dao.AdminDao;
import com.yunyuntop.domain.Admin;

public class AdminService {

	public void registeradmin(Admin admin){
		
		new AdminDao().registeradmin(admin);
	}
	public Admin loginadmin(String apwd,String aname){
		return new AdminDao().loginadmin(apwd, aname);
	}
	public List<Admin> findAll(){
		
		return new AdminDao().findAll();
	}
	public void deleteAdmin(String aid) {
		new AdminDao().deleteAdmin(aid);
		
	}
}
