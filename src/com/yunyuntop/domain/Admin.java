package com.yunyuntop.domain;

public class Admin {

	private String aid;
	private String aname;
	private String apwd;
	
	
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public Admin(String aid, String aname, String apwd) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
	}
	public Admin() {
	}
	
	
	
}
