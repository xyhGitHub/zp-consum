/** 
 * <pre>项目名称:sixCRM-model 
 * 文件名称:ProductRelCategroy.java 
 * 包名:com.six.model 
 * 创建日期:2018年4月27日下午4:05:56 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */
package com.four.model;

import java.io.Serializable;

/**
 * <pre>
 * 项目名称：sixCRM-model    
 * 类名称：ProductRelCategroy    
 * 类描述：    
 * 创建人：周录军     
 * 创建时间：2018年4月27日 下午4:05:56    
 * 修改人：周录军 
 * 修改时间：2018年4月27日 下午4:05:56    
 * 修改备注：       
 * @version
 * </pre>
 */
public class ProductRelCategroy implements Serializable{
	private static final long serialVersionUID = -5483177503210318382L;
	private Integer id;
	private Integer pid;
	private String product_name;
	private String product_category;

	private float product_price;
	private String p_statues;
	private String p_specifications;
	private String p_unit;
	private String remarks;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	public String getP_statues() {
		return p_statues;
	}
	public void setP_statues(String p_statues) {
		this.p_statues = p_statues;
	}
	public String getP_specifications() {
		return p_specifications;
	}
	public void setP_specifications(String p_specifications) {
		this.p_specifications = p_specifications;
	}
	public String getP_unit() {
		return p_unit;
	}
	public void setP_unit(String p_unit) {
		this.p_unit = p_unit;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "ProductRelCategroy [id=" + id + ", pid=" + pid
				+ ", product_name=" + product_name + ", product_category="
				+ product_category + ", product_price=" + product_price
				+ ", p_statues=" + p_statues + ", p_specifications="
				+ p_specifications + ", p_unit=" + p_unit + ", remarks="
				+ remarks + "]";
	}
	public ProductRelCategroy(Integer id, Integer pid, String product_name,
			String product_category, float product_price, String p_statues,
			String p_specifications, String p_unit, String remarks) {
		super();
		this.id = id;
		this.pid = pid;
		this.product_name = product_name;
		this.product_category = product_category;
		this.product_price = product_price;
		this.p_statues = p_statues;
		this.p_specifications = p_specifications;
		this.p_unit = p_unit;
		this.remarks = remarks;
	}
	public ProductRelCategroy() {
		super();
	}
	 
	
}
