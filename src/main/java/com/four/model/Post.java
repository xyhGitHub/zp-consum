package com.four.model;


import java.io.Serializable;

//岗位
public class Post implements Serializable{
	private static final long serialVersionUID = 3601824904621353601L;
	private Integer postid;
	
	private String postname;
	
	private Integer postcompany;
	private String  postcompanyname;

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public String getpostname() {
		return postname;
	}

	public void setpostname(String postname) {
		this.postname = postname;
	}

	public Integer getPostcompany() {
		return postcompany;
	}

	public void setPostcompany(Integer postcompany) {
		this.postcompany = postcompany;
	}

	public String getPostcompanyname() {
		return postcompanyname;
	}

	public void setPostcompanyname(String postcompanyname) {
		this.postcompanyname = postcompanyname;
	}

	public String toString() {
		return "Post [postid=" + postid + ", postname=" + postname + ", postcompany=" + postcompany
				+ ", postcompanyname=" + postcompanyname + "]";
	}

	

	

	

	
	

}
