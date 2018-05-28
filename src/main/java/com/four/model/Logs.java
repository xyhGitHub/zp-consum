package com.four.model;

import java.io.Serializable;

public class Logs implements Serializable{
	private static final long serialVersionUID = 923522888120974690L;

	private String logId;
	private String clazzName;
	private String methodName;
	private String params;
	private String exception;
	private String user;
	private String chenggongcount;
	private String shibaicount;

	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getClazzName() {
		return clazzName;
	}
	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public String getChenggongcount() {
		return chenggongcount;
	}

	public void setChenggongcount(String chenggongcount) {
		this.chenggongcount = chenggongcount;
	}

	public String getShibaicount() {
		return shibaicount;
	}

	public void setShibaicount(String shibaicount) {
		this.shibaicount = shibaicount;
	}

	@Override
	public String toString() {
		return "Logs{" +
				"logId='" + logId + '\'' +
				", clazzName='" + clazzName + '\'' +
				", methodName='" + methodName + '\'' +
				", params='" + params + '\'' +
				", exception='" + exception + '\'' +
				", user='" + user + '\'' +
				", chenggongcount='" + chenggongcount + '\'' +
				", shibaicount='" + shibaicount + '\'' +
				'}';
	}
}
