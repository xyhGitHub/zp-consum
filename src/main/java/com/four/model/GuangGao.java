package com.four.model;

import java.io.Serializable;

public class GuangGao implements Serializable{
	private static final long serialVersionUID = 5412014664708585246L;

	//广告ID
	private Integer guangGaoId;
	//广告名称
	private String guangGaoName;
	//广告说明
	private String guangGaoShuoMing;
	//广告起始时间
	private String guangGaoStart;
	//广告结束时间
	private String guangGaoEnd;
	//广告图片
	private String guangGaoPhoto;
	//广告金额
	private Integer guangGaoprice;
	//广告位序号
	private Integer guangGaoNum;
	//广告官网
	private String guangGaoGuanWang;
	//图片长
	private Integer guangGaoWidth;
	//图片宽
	private Integer guangGaoHeight;
	//广告状态
	private Integer guangGaoStatus;


	public Integer getGuangGaoId() {
		return guangGaoId;
	}

	public void setGuangGaoId(Integer guangGaoId) {
		this.guangGaoId = guangGaoId;
	}

	public String getGuangGaoName() {
		return guangGaoName;
	}

	public void setGuangGaoName(String guangGaoName) {
		this.guangGaoName = guangGaoName;
	}

	public String getGuangGaoShuoMing() {
		return guangGaoShuoMing;
	}

	public void setGuangGaoShuoMing(String guangGaoShuoMing) {
		this.guangGaoShuoMing = guangGaoShuoMing;
	}

	public String getGuangGaoStart() {
		return guangGaoStart;
	}

	public void setGuangGaoStart(String guangGaoStart) {
		this.guangGaoStart = guangGaoStart;
	}

	public String getGuangGaoEnd() {
		return guangGaoEnd;
	}

	public void setGuangGaoEnd(String guangGaoEnd) {
		this.guangGaoEnd = guangGaoEnd;
	}

	public String getGuangGaoPhoto() {
		return guangGaoPhoto;
	}

	public void setGuangGaoPhoto(String guangGaoPhoto) {
		this.guangGaoPhoto = guangGaoPhoto;
	}

	public Integer getGuangGaoprice() {
		return guangGaoprice;
	}

	public void setGuangGaoprice(Integer guangGaoprice) {
		this.guangGaoprice = guangGaoprice;
	}

	public Integer getGuangGaoNum() {
		return guangGaoNum;
	}

	public void setGuangGaoNum(Integer guangGaoNum) {
		this.guangGaoNum = guangGaoNum;
	}

	public String getGuangGaoGuanWang() {
		return guangGaoGuanWang;
	}

	public void setGuangGaoGuanWang(String guangGaoGuanWang) {
		this.guangGaoGuanWang = guangGaoGuanWang;
	}

	public Integer getGuangGaoWidth() {
		return guangGaoWidth;
	}

	public void setGuangGaoWidth(Integer guangGaoWidth) {
		this.guangGaoWidth = guangGaoWidth;
	}

	public Integer getGuangGaoHeight() {
		return guangGaoHeight;
	}

	public void setGuangGaoHeight(Integer guangGaoHeight) {
		this.guangGaoHeight = guangGaoHeight;
	}

	public Integer getGuangGaoStatus() {
		return guangGaoStatus;
	}

	public void setGuangGaoStatus(Integer guangGaoStatus) {
		this.guangGaoStatus = guangGaoStatus;
	}

	@Override
	public String toString() {
		return "GuangGao{" +
				"guangGaoId=" + guangGaoId +
				", guangGaoName='" + guangGaoName + '\'' +
				", guangGaoShuoMing='" + guangGaoShuoMing + '\'' +
				", guangGaoStart='" + guangGaoStart + '\'' +
				", guangGaoEnd='" + guangGaoEnd + '\'' +
				", guangGaoPhoto='" + guangGaoPhoto + '\'' +
				", guangGaoprice=" + guangGaoprice +
				", guangGaoNum=" + guangGaoNum +
				", guangGaoGuanWang='" + guangGaoGuanWang + '\'' +
				", guangGaoWidth=" + guangGaoWidth +
				", guangGaoHeight=" + guangGaoHeight +
				", guangGaoStatus=" + guangGaoStatus +
				'}';
	}
}
