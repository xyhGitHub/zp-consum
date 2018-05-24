/** 
 * <pre>项目名称:seven_group 
 * 文件名称:Dept.java 
 * 包名:com.seven.model 
 * 创建日期:2018年3月13日下午7:28:43 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.four.model;

import java.io.Serializable;

/** 
 * <pre>项目名称：seven_group    
 * 类名称：Dept    
 * 类描述：    
 * 创建人：薛怡衡  
 * 创建时间：2018年3月13日 下午7:28:43    
 * 修改人：薛怡衡    
 * 修改时间：2018年3月13日 下午7:28:43    
 * 修改备注：       
 * @version </pre>    
 */
public class Dept implements Serializable{

	
	private static final long serialVersionUID = -179715151988491637L;
	
	private Integer deptid;
	private String deptname;
	
	private String usernames;
	private String usersexs;
	
	public String getUsernames() {
		return usernames;
	}
	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}
	public String getUsersexs() {
		return usersexs;
	}
	public void setUsersexs(String usersexs) {
		this.usersexs = usersexs;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Dept [deptid=" + deptid + ", deptname=" + deptname + ", usernames=" + usernames + ", usersexs="
				+ usersexs + "]";
	}

	
}
