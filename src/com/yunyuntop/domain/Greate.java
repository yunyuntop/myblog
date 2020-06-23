package com.yunyuntop.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Greate {
	
	private String gid;
	private User user;
	private Blogs blog;
	private String gtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
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
	public String getGtime() {
		if(gtime!=null&&gtime.length()>=19)
			return gtime.substring(0,19);
			else
				return null;
	}
	public void setGtime(String gtime) {
		this.gtime = gtime;
	}
	@Override
	public String toString() {
		return "Greate [gid=" + gid + ", uid=" + user + ", bid=" + blog + ", gtime=" + gtime + "]";
	}
	public Greate(String gid, User user, Blogs blog) {
		super();
		this.gid = gid;
		this.user = user;
		this.blog = blog;
	}
	public Greate() {
	}
	
}
