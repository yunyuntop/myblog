package com.yunyuntop.service;

import java.util.List;

import com.yunyuntop.dao.UserDao;
import com.yunyuntop.domain.User;

public class UserService {
	public int findTotalSize(){
	return new UserDao().findTotalSize();
	}	
	

	public User findByUid(String uid) {
		return new UserDao().findByUid(uid);
	}

	public User updatePassword(String password, String uemail) {

		return new UserDao().updatePassword(password, uemail);
	}

	public User updateState(String uid) {
		return new UserDao().updateState(uid);
	}
	public List<User> findAllByUtime(int size,int currPage){
		return new UserDao().findAllByUtime(size,currPage);
	}

	public User login(String username, String password) {
		return new UserDao().login(username, password);
	}

	public void add(User u) {

		new UserDao().add(u);
	}

	public User findByEmail(String email) {

		return new UserDao().findByEmail(email);
	}

	public User findByName(String username) {

		return new UserDao().findByName(username);
	}
	
	public void editUser(User user){
		new UserDao().editUser(user);
	}


	public void delete(User user) {
		new UserDao().deleteuser(user);
		
	}

}
