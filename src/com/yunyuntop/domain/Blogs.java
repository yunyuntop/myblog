package com.yunyuntop.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Blogs {
	
	private String bid;
	private String bimg;
	
	private String btime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) ;
	private String cid;
	private String btitle;
	private String bheader;
	private String author="吴云";
	private long totallook;
	private Set<Greate> greateSet=new HashSet<Greate>();
	private long greatecount;

	private long discusscount;
	public Set<Greate> getGreateSet() {
		return greateSet;
	}
	public void setGreateSet(Set<Greate> greateSet) {
		this.greateSet = greateSet;
	}
	public long getTotallook() {
		return totallook;
	}
	public void setTotallook(long totallook) {
		this.totallook = totallook;
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
	private Set<Kinds> kindsSet = new HashSet<Kinds>();
	private Set<Discuss> discussSet = new HashSet<Discuss>();
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBheader() {
		return bheader;
	}
	public void setBheader(String bheader) {
		this.bheader = bheader;
	}

	public Set<Discuss> getDiscussSet() {
		return discussSet;
	}
	public void setDiscussSet(Set<Discuss> discussSet) {
		this.discussSet = discussSet;
	}

	public Set<Kinds> getKindsSet() {
		return kindsSet;
	}
	public void setKindsSet(Set<Kinds> kindsSet) {
		this.kindsSet = kindsSet;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBimg() {
		return bimg;
	}
	public void setBimg(String bimg) {
		this.bimg = bimg;
	}
	public String getBtime() {
		if(btime!=null&&btime.length()>=19)
			return btime.substring(0,19);
			else
				return null;
	}
	
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public Blogs() {
	}
	public Blogs(String bid, String bimg, String btime, String cid, String btitle, String bheader, String author) {
		super();
		this.bid = bid;
		this.bimg = bimg;
		this.btime = btime;
		this.cid = cid;
		this.btitle = btitle;
		this.bheader = bheader;
		this.author = author;
		
	}
	@Override
	public String toString() {
		return "Blogs [bid=" + bid + ", bimg=" + bimg + ", btime=" + btime + ", cid=" + cid + ", btitle=" + btitle
				+ ", bheader=" + bheader + ", author=" + author +  "]";
	}
	
	
	
}
