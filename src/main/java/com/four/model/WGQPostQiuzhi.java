/** 
 * <pre>项目名称:seven_group 
 * 文件名称:WGQPostQiuzhi.java 
 * 包名:com.seven.model 
 * 创建日期:2018年3月16日下午1:49:09 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.four.model;

import java.io.Serializable;

/** 
 * <pre>项目名称：seven_group    
 * 类名称：WGQPostQiuzhi    
 * 类描述：    
 * 创建人：JavaScript 
 * 创建时间：2018年3月16日 下午1:49:09    
 * 修改人：JavaScript  
 * 修改时间：2018年3月16日 下午1:49:09    
 * 修改备注：       
 * @version </pre>    
 */
public class WGQPostQiuzhi implements Serializable{
	
	private static final long serialVersionUID = -5635801835376411876L;

	//用户求职表id
	private Integer pqid;
	
	//用户求职表 和职位表关联ID
	private Integer postid;
	
	//用户求职表 和 职位表关联职位ID
	private Integer typeid;
	
	//用户求职表的职位所属公司ID
	private Integer companyid;
	
	//用户ID
	private Integer userid;

	public Integer getPqid() {
		return pqid;
	}

	public void setPqid(Integer pqid) {
		this.pqid = pqid;
	}

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "WGQPostQiuzhi [pqid=" + pqid + ", postid=" + postid + ", typeid=" + typeid + ", companyid=" + companyid
				+ ", userid=" + userid + "]";
	}
	
	
}
