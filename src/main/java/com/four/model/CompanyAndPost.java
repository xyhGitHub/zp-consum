/** 
 * <pre>项目名称:seven_group 
 * 文件名称:CompanyAndPost.java 
 * 包名:com.seven.model 
 * 创建日期:2018年3月14日下午4:06:35 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.four.model;

import java.io.Serializable;

/** 
 * <pre>项目名称：seven_group    
 * 类名称：CompanyAndPost    
 * 类描述：    
 * 创建人：JavaScript 
 * 创建时间：2018年3月14日 下午4:06:35    
 * 修改人：JavaScript  
 * 修改时间：2018年3月14日 下午4:06:35    
 * 修改备注：       
 * @version </pre>    
 */
public class CompanyAndPost implements Serializable{
	public Boolean getB() {
		return b;
	}
	public void setB(Boolean b) {
		this.b = b;
	}
	private static final long serialVersionUID = -2864629320741080553L;
	private Integer companyid;	//公司ID
	private String companyname;	//公司
	private Integer companyaudit;	//公司是否審核
	private Integer postid;	//職位ID
	private String postname;	//職位名稱
	private Integer postcompany;	//和公司關聯字段
	
	private Boolean b = false;	//未真是说明投过简历
	//------------------
	
	private Integer offset;//當前起始位置
	private Integer pageNumber;	//当前几页
	private Integer pageSize;	//每页条数
	private String departmentname;//條件查詢參數1
	private String statu;//條件查詢參數2
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public Integer getCompanyid() {
		return companyid;
	}
	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public Integer getCompanyaudit() {
		return companyaudit;
	}
	public void setCompanyaudit(Integer companyaudit) {
		this.companyaudit = companyaudit;
	}
	public Integer getPostid() {
		return postid;
	}
	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	public Integer getPostcompany() {
		return postcompany;
	}
	public void setPostcompany(Integer postcompany) {
		this.postcompany = postcompany;
	}
	@Override
	public String toString() {
		return "CompanyAndPost [companyid=" + companyid + ", companyname=" + companyname + ", companyaudit="
				+ companyaudit + ", postid=" + postid + ", postname=" + postname + ", postcompany=" + postcompany
				+ ", b=" + b + ", offset=" + offset + ", pageNumber=" + pageNumber + ", pageSize=" + pageSize
				+ ", departmentname=" + departmentname + ", statu=" + statu + "]";
	}
	
	
}
