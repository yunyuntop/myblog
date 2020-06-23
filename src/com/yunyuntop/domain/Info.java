package com.yunyuntop.domain;

import java.util.List;

import com.yunyuntop.service.InfoService;

public class Info {

	
	private String iid;
	private long    messagecount;
	private long    greatecount;
	private long    discusscount;
	private static Info info;
	
	public String getIid() {
		return iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public long getMessagecount() {
		return messagecount;
	}

	public void setMessagecount(long messagecount) {
		this.messagecount = messagecount;
	}

	public long getGreatecount() {
		return greatecount;
	}

	public void setGreatecount(long greatecount) {
		this.greatecount = greatecount;
	}

	public long getDiscusscount() {
		return discusscount;
	}

	public void setDiscusscount(long discusscount) {
		this.discusscount = discusscount;
	}

	

	@Override
	public String toString() {
		return "Info [iid=" + iid + ", messagecount=" + messagecount + ", greatecount=" + greatecount
				+ ", discusscount=" + discusscount +"]";
	}
	public static  Info getInstance(){
		if(info==null){
			synchronized("info"){
				if(info==null){
					
				
					List<Info> list=new InfoService().find();
					if(list.size()!=0){
						info=list.get(0);
					}else{
						info=new Info();
					}
				}
			}
		}
		return info;
	}

	private Info(){}
	
}
