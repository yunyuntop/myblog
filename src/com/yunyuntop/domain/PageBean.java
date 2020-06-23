package com.yunyuntop.domain;

import java.util.List;

public class PageBean<T> {

	private List<T> list;
	private Integer currPage;
	private Integer totalPage;
	private Integer size;
	private Integer totalSize;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	
	public PageBean(List<T> list, Integer currPage , Integer size, Integer totalSize) {
		super();
		this.list = list;
		this.currPage = currPage;
		this.totalPage = totalSize%size==0?totalSize/size:totalSize/size+1;
		this.size = size;
		this.totalSize = totalSize;
	}
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
