package com.four.utils;

import java.util.ArrayList;
import java.util.List;

public class PageModel<T> {
	
	
	//总条数
	private   int   pageSum;
	
	//每页条数
	private   int     pageSize=6;
	
	//总页数
	private    int   pageCount;
	
	 
	//当前页
	private    int   pageNow;
	
    //数据内容
	private   List<T>  pageList=new ArrayList<T>();
	//第几条开始
	private    int   start;
	
	private    int   endindex;
	  

	public int getEndindex() {
		
		return (pageNow-1)*pageSize+pageSize;
	}

	public void setEndindex(int endindex) {
		this.endindex = endindex;
	}

	public int getStart() {
	 
		return (pageNow-1)*pageSize;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageSum() {
		
		return pageSum;
	}

	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		 if(pageSum%pageSize==0)
	        {
			 pageCount=pageSum/pageSize;
	        	
	        }else
	        { 
	        	pageCount=pageSum/pageSize+1; 
	        }
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	} 
	
	
	
	

}
