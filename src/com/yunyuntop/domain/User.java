package com.yunyuntop.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {

	
	private String uid;
	private String username;
	private String password;
	private String uimg="/icon/default.jpg";
	private String uinfo;
	private String uemail;
	private String uphone; 
	private int ustate;
	private String utime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	private Set<Discuss> discussSet=new HashSet<Discuss>();
	
	
	
	public Set<Discuss> getDiscussSet() {
		return discussSet;
	}
	public void setDiscussSet(Set<Discuss> discussSet) {
		this.discussSet = discussSet;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public User(){}
	
	public String getUtime() {
		if(utime!=null&&utime.length()>=19)
			return utime.substring(0,19);
			else
				return null;
	}
	public void setUtime(String utime) {
		this.utime = utime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUimg() {
		return uimg;
	}
	public void setUimg(String uimg) {
		this.uimg = uimg;
	}
	public String getUinfo() {
		return uinfo;
	}
	public void setUinfo(String uinfo) {
		this.uinfo = uinfo;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public int getUstate() {
		return ustate;
	}
	public void setUstate(int ustate) {
		this.ustate = ustate;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", uimg=" + uimg + ", uinfo="
				+ uinfo + ", uemail=" + uemail + ", uphone=" + uphone + ", ustate=" + ustate + ", discussSet="
				+ discussSet + "]";
	}
	public User(String uid, String username, String password, String uimg, String uinfo, String uemail, String uphone,
			int ustate, Set<Discuss> discussSet) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.uimg = uimg;
		this.uinfo = uinfo;
		this.uemail = uemail;
		this.uphone = uphone;
		this.ustate = ustate;
		this.discussSet = discussSet;
	}
	
	
	
	

	
	
}
