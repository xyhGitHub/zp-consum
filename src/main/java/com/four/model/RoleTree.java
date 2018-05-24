package com.four.model;

import java.io.Serializable;

public class RoleTree implements Serializable{
	private static final long serialVersionUID = -8670052010069518979L;
	private Integer roleId;

    private Integer treeid;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getTreeid() {
		return treeid;
	}

	public void setTreeid(Integer treeid) {
		this.treeid = treeid;
	}

	@Override
	public String toString() {
		return "RoleTree [roleId=" + roleId + ", treeid=" + treeid + "]";
	}

   
    
    
}