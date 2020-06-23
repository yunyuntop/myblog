package com.yunyuntop.domain;

public class Context {

	
	private String cid;
	private String context;
	private String bid;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public Context(String cid, String context, String bid) {
		super();
		this.cid = cid;
		this.context = context;
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "Context [cid=" + cid + ", context=" + context + ", bid=" + bid + "]";
	}
	public Context() {
	}
	
	
	
	
}
