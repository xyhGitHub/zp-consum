package com.four.model;

import java.io.Serializable;

public class Company implements Serializable{
	private static final long serialVersionUID = 522370482242651445L;
	private Integer companyid;

    private String companyName;

    private Integer companyAudit;

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCompanyAudit() {
		return companyAudit;
	}

	public void setCompanyAudit(Integer companyAudit) {
		this.companyAudit = companyAudit;
	}

	

	

	

    
}