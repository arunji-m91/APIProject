package com.pojo.read;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainJsonPojo {
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private Support support;
	private ArrayList<Data> data;
	
	
	public ArrayList<Data> getData() {
		return data;
	}
	public void setData(ArrayList<Data> data) {
		this.data = data;
	}
	public Support getSupport() {
		return support;
	}
	public void setSupport(Support support) {
		this.support = support;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	
	
	
}
	

