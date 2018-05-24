package com.four.model;

import java.io.Serializable;

public class Type implements Serializable{
    private static final long serialVersionUID = -8915837330440415649L;
    private Integer typeid;

    private String typename;

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
        this.typename = typename == null ? null : typename.trim();
    }

	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", typename=" + typename + "]";
	}
    
}