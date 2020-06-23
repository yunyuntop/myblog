package com.yunyuntop.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

	private String mid;
	private String message;
	private String realname;
	private String email;
	private String mtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	public String getMtime() {
		if(mtime!=null&&mtime.length()>=19)
			return mtime.substring(0,19);
			else
				return null;
	}
	public void setMtime(String mtime) {
		//if(mtime!=null&&mtime.length()>=20)
		this.mtime = mtime;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Message(String mid, String message, String realname, String email) {
		super();
		this.mid = mid;
		this.message = message;
		this.realname = realname;
		this.email = email;
	}
	public Message() {
		super();		
	}
	@Override
	public String toString() {
		return "Message [mid=" + mid + ", message=" + message + ", realname=" + realname + ", email=" + email + "]";
	}
	
	
}
