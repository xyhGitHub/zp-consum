
package com.four.model;

import java.io.Serializable;


public class Tree implements Serializable{
    private static final long serialVersionUID = 225567936375890125L;

	private Integer id;
	private Integer pid;
	private String  text;
	private String  url;
	private Boolean checked=false;
	private String iconCls;
	
	
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Tree [id=" + id + ", pid=" + pid + ", text=" + text + ", url=" + url + ", checked=" + checked
				+ ", iconCls=" + iconCls + "]";
	}

	
	
}
