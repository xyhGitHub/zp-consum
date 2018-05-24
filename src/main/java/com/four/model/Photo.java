/** 
 * <pre>项目名称:seven_group 
 * 文件名称:Photo.java 
 * 包名:com.seven.model 
 * 创建日期:2018年3月12日下午9:14:28 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.four.model;

import java.io.Serializable;

/** 
 * <pre>项目名称：seven_group    
 * 类名称：Photo    
 * 类描述：    
 * 创建人：薛怡衡  
 * 创建时间：2018年3月12日 下午9:14:28    
 * 修改人：薛怡衡    
 * 修改时间：2018年3月12日 下午9:14:28    
 * 修改备注：       
 * @version </pre>    
 */
public class Photo implements Serializable{
	
	private static final long serialVersionUID = 1752268289282855377L;
	
	private Integer photoid;
	private String photoname;
	private String uploadtime;
	private String downloadtime;
	private String photostatus;
	public Integer getPhotoid() {
		return photoid;
	}
	public void setPhotoid(Integer photoid) {
		this.photoid = photoid;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getDownloadtime() {
		return downloadtime;
	}
	public void setDownloadtime(String downloadtime) {
		this.downloadtime = downloadtime;
	}
	public String getPhotostatus() {
		return photostatus;
	}
	public void setPhotostatus(String photostatus) {
		this.photostatus = photostatus;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Photo [photoid=" + photoid + ", photoname=" + photoname + ", uploadtime=" + uploadtime
				+ ", downloadtime=" + downloadtime + ", photostatus=" + photostatus + "]";
	}

	
}
