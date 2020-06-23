package com.yunyuntop.domain;

import java.util.HashSet;
import java.util.Set;


public class Kinds {

	
	private String kid;
	private String ktext;
	
	private Set<Blogs> BlogsSet = new HashSet<Blogs>();
	
	
	public Set<Blogs> getBlogsSet() {
		return BlogsSet;
	}
	public void setBlogsSet(Set<Blogs> blogsSet) {
		BlogsSet = blogsSet;
	}
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	public String getKtext() {
		return ktext;
	}
	public void setKtext(String ktext) {
		this.ktext = ktext;
	}
	
	
	public String toString() {
		return "Kinds [kid=" + kid + ", ktext=" + ktext + ", BlogsSet=" + BlogsSet + "]";
	}
	public Kinds(String kid, String ktext) {
		super();
		this.kid = kid;
		this.ktext = ktext;
		
	}
	public Kinds() {
	}
	
	
	
	
}
