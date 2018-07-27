package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2472405770052614038L;
	
	private List<T> data ;//每一页的数据
	private int totalpage;//总共有多少页
	private int currentPage;//当前页
	
	public PageModel(List<T> data, int totalpage,int currentPage) {
		super();
		this.data = data;
		this.totalpage = totalpage;
		this.currentPage = currentPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public PageModel() {
		super();
	}

	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	
	
	
}
