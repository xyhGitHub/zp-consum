package com.four.model;


import java.io.Serializable;


public class Role implements Serializable{
    private static final long serialVersionUID = 6126404880633242396L;

	private Integer roleId;


    private String roleName;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

   
}