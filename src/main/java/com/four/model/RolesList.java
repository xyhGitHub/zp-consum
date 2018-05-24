  
package com.four.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RolesList implements Serializable{

	private static final long serialVersionUID = 3456225214247434387L;
	private Set<Role> roles=new HashSet<Role>();
	
	private List<Role> list=new ArrayList<Role>();

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Role> getList() {
		return list;
	}

	public void setList(List<Role> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "RolesList [roles=" + roles + ", list=" + list + "]";
	}

	
	
	
	
	
	
}
