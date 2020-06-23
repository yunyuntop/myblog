package com.yunyuntop.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.yunyuntop.service.DiscussService;

public class Receive {

	private String rid;
	private Discuss discuss;
	private String rtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date());
	private String rtext;
	
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	public Discuss getDiscuss() {
		return  new DiscussService().findByDid(rid);
	}
	
	public String getRtime() {
		if(rtime!=null&&rtime.length()>=19)
			return rtime.substring(0,19);
			else
				return null;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	public String getRtext() {
		return rtext;
	}
	public void setRtext(String rtext) {
		this.rtext = rtext;
	}
	public Receive(String rid, String rtime, String rtext) {
		super();
		this.rid = rid;
		
		this.rtime = rtime;
		this.rtext = rtext;
	}
	public Receive() {
	}
	
	
	
}
