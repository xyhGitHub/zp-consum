/** 
 * <pre>项目名称:seven_group 
 * 文件名称:User.java 
 * 包名:com.seven.model 
 * 创建日期:2018年3月13日下午1:07:58 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.four.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * <pre>项目名称：seven_group    
 * 类名称：User    
 * 类描述：    
 * 创建人：JavaScript 
 * 创建时间：2018年3月13日 下午1:07:58    
 * 修改人：JavaScript  
 * 修改时间：2018年3月13日 下午1:07:58    
 * 修改备注：       
 * @version </pre>    
 */
public class User implements Serializable{

	private static final long serialVersionUID = 4185009803373372107L;

	//用户id
	private Integer userid;

	//用户类型
	private Integer userTtpe;


	//用户帐号
	private String username;
	
	//用户性别,0男,1女
	private Integer usersex;
	
	//用户登录名字,
	private String loginname;	
	
	//部门id,
	private Integer deptid;	
	
	//用户类型,
	private Integer typeid;
	
	//用户名称
	private String typename;
	
	//所属部门名称 
	private String deptname;
	
	//公司id
	private Integer companyid;
	
	//公司名称
	private String companyname;
	
	//联系电话
	private String userphone;

	//用户密码
	private String pwd;

	private List<Tree> listTree;

	//用于用户注册时的验证码
	private String checkcode;
	
	//用于用户注册时的手机验证码
	private Integer checkPhone;
	
	//用户邮箱,用于发送面试通知邮件
	private String  email;
	

	private List<Role> list;
	
	private Set<String> resources = new HashSet<String>();
    
	private Set<Role> roles=new HashSet<Role>();
		
	//条件查询
	//姓名条件查询
	private String usernamecriteria;
	
	//性别条件查询
	private Integer usersexcriteria;
	
	//部门条件查询
	private Integer deptidcriteria;
	
	//类型条件查询
	private Integer typeidcriteria;
	
	//登录名称条件查询
	private Integer loginnamecriteria;

	public Integer getUserTtpe() {
		return userTtpe;
	}

	public void setUserTtpe(Integer userTtpe) {
		this.userTtpe = userTtpe;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUsersex() {
		return usersex;
	}

	public void setUsersex(Integer usersex) {
		this.usersex = usersex;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
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

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<Tree> getListTree() {
		return listTree;
	}

	public void setListTree(List<Tree> listTree) {
		this.listTree = listTree;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public Integer getCheckPhone() {
		return checkPhone;
	}

	public void setCheckPhone(Integer checkPhone) {
		this.checkPhone = checkPhone;
	}

	public List<Role> getList() {
		return list;
	}

	public void setList(List<Role> list) {
		this.list = list;
	}

	public Set<String> getResources() {
		return resources;
	}

	public void setResources(Set<String> resources) {
		this.resources = resources;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUsernamecriteria() {
		return usernamecriteria;
	}

	public void setUsernamecriteria(String usernamecriteria) {
		this.usernamecriteria = usernamecriteria;
	}

	public Integer getUsersexcriteria() {
		return usersexcriteria;
	}

	public void setUsersexcriteria(Integer usersexcriteria) {
		this.usersexcriteria = usersexcriteria;
	}

	public Integer getDeptidcriteria() {
		return deptidcriteria;
	}

	public void setDeptidcriteria(Integer deptidcriteria) {
		this.deptidcriteria = deptidcriteria;
	}

	public Integer getTypeidcriteria() {
		return typeidcriteria;
	}

	public void setTypeidcriteria(Integer typeidcriteria) {
		this.typeidcriteria = typeidcriteria;
	}

	public Integer getLoginnamecriteria() {
		return loginnamecriteria;
	}

	public void setLoginnamecriteria(Integer loginnamecriteria) {
		this.loginnamecriteria = loginnamecriteria;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#hashCode()    
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkPhone == null) ? 0 : checkPhone.hashCode());
		result = prime * result + ((checkcode == null) ? 0 : checkcode.hashCode());
		result = prime * result + ((companyid == null) ? 0 : companyid.hashCode());
		result = prime * result + ((companyname == null) ? 0 : companyname.hashCode());
		result = prime * result + ((deptid == null) ? 0 : deptid.hashCode());
		result = prime * result + ((deptidcriteria == null) ? 0 : deptidcriteria.hashCode());
		result = prime * result + ((deptname == null) ? 0 : deptname.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((listTree == null) ? 0 : listTree.hashCode());
		result = prime * result + ((loginname == null) ? 0 : loginname.hashCode());
		result = prime * result + ((loginnamecriteria == null) ? 0 : loginnamecriteria.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((resources == null) ? 0 : resources.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((typeid == null) ? 0 : typeid.hashCode());
		result = prime * result + ((typeidcriteria == null) ? 0 : typeidcriteria.hashCode());
		result = prime * result + ((typename == null) ? 0 : typename.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((usernamecriteria == null) ? 0 : usernamecriteria.hashCode());
		result = prime * result + ((userphone == null) ? 0 : userphone.hashCode());
		result = prime * result + ((usersex == null) ? 0 : usersex.hashCode());
		result = prime * result + ((usersexcriteria == null) ? 0 : usersexcriteria.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (checkPhone == null) {
			if (other.checkPhone != null)
				return false;
		} else if (!checkPhone.equals(other.checkPhone))
			return false;
		if (checkcode == null) {
			if (other.checkcode != null)
				return false;
		} else if (!checkcode.equals(other.checkcode))
			return false;
		if (companyid == null) {
			if (other.companyid != null)
				return false;
		} else if (!companyid.equals(other.companyid))
			return false;
		if (companyname == null) {
			if (other.companyname != null)
				return false;
		} else if (!companyname.equals(other.companyname))
			return false;
		if (deptid == null) {
			if (other.deptid != null)
				return false;
		} else if (!deptid.equals(other.deptid))
			return false;
		if (deptidcriteria == null) {
			if (other.deptidcriteria != null)
				return false;
		} else if (!deptidcriteria.equals(other.deptidcriteria))
			return false;
		if (deptname == null) {
			if (other.deptname != null)
				return false;
		} else if (!deptname.equals(other.deptname))
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (listTree == null) {
			if (other.listTree != null)
				return false;
		} else if (!listTree.equals(other.listTree))
			return false;
		if (loginname == null) {
			if (other.loginname != null)
				return false;
		} else if (!loginname.equals(other.loginname))
			return false;
		if (loginnamecriteria == null) {
			if (other.loginnamecriteria != null)
				return false;
		} else if (!loginnamecriteria.equals(other.loginnamecriteria))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (resources == null) {
			if (other.resources != null)
				return false;
		} else if (!resources.equals(other.resources))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (typeid == null) {
			if (other.typeid != null)
				return false;
		} else if (!typeid.equals(other.typeid))
			return false;
		if (typeidcriteria == null) {
			if (other.typeidcriteria != null)
				return false;
		} else if (!typeidcriteria.equals(other.typeidcriteria))
			return false;
		if (typename == null) {
			if (other.typename != null)
				return false;
		} else if (!typename.equals(other.typename))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (usernamecriteria == null) {
			if (other.usernamecriteria != null)
				return false;
		} else if (!usernamecriteria.equals(other.usernamecriteria))
			return false;
		if (userphone == null) {
			if (other.userphone != null)
				return false;
		} else if (!userphone.equals(other.userphone))
			return false;
		if (usersex == null) {
			if (other.usersex != null)
				return false;
		} else if (!usersex.equals(other.usersex))
			return false;
		if (usersexcriteria == null) {
			if (other.usersexcriteria != null)
				return false;
		} else if (!usersexcriteria.equals(other.usersexcriteria))
			return false;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"userid=" + userid +
				", userTtpe=" + userTtpe +
				", username='" + username + '\'' +
				", usersex=" + usersex +
				", loginname='" + loginname + '\'' +
				", deptid=" + deptid +
				", typeid=" + typeid +
				", typename='" + typename + '\'' +
				", deptname='" + deptname + '\'' +
				", companyid=" + companyid +
				", companyname='" + companyname + '\'' +
				", userphone='" + userphone + '\'' +
				", pwd='" + pwd + '\'' +
				", listTree=" + listTree +
				", checkcode='" + checkcode + '\'' +
				", checkPhone=" + checkPhone +
				", email='" + email + '\'' +
				", list=" + list +
				", resources=" + resources +
				", roles=" + roles +
				", usernamecriteria='" + usernamecriteria + '\'' +
				", usersexcriteria=" + usersexcriteria +
				", deptidcriteria=" + deptidcriteria +
				", typeidcriteria=" + typeidcriteria +
				", loginnamecriteria=" + loginnamecriteria +
				'}';
	}
}
