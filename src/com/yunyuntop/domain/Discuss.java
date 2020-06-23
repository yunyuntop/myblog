package com.yunyuntop.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.yunyuntop.service.ReceiveService;

public class Discuss {

	
	private String did;
	
	private String dtext;
	private String dtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	private Blogs blog;
	private User user;
	private Receive receive;
	
	public Receive getReceive() {
		return new ReceiveService().findByRid(did);
	}
	public void setReceive(Receive receive) {
		this.receive = receive;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Blogs getBlog() {
		return blog;
	}
	public void setBlog(Blogs blog) {
		this.blog = blog;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	
	
	public String getDtext() {
		return dtext;
	}
	public void setDtext(String dtext) {
		this.dtext = dtext;
	}
	public String getDtime() {
		if(dtime!=null&&dtime.length()>=19)
			return dtime.substring(0,19);
			else
				return null;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public Discuss(String did,Blogs blog, User user, String dtext) {
		super(); 
		this.did = did;
		this.blog=blog;				
		this.user=user;
		this.dtext = dtext;
	}
	public Discuss() {
	}

}
