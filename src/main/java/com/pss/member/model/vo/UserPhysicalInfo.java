package com.pss.member.model.vo;

public class UserPhysicalInfo {
	
	private int pinfoNo;
	private int userNo;
	private double memHeight;
	private double memWeight;
	private double memSmm;
	private double memBep;
	
	public UserPhysicalInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPhysicalInfo(int pinfoNo, int userNo, double memHeight, double memWeight, double memSmm, double memBep) {
		super();
		this.pinfoNo = pinfoNo;
		this.userNo = userNo;
		this.memHeight = memHeight;
		this.memWeight = memWeight;
		this.memSmm = memSmm;
		this.memBep = memBep;
	}

	public int getPinfoNo() {
		return pinfoNo;
	}

	public void setPinfoNo(int pinfoNo) {
		this.pinfoNo = pinfoNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public double getMemHeight() {
		return memHeight;
	}

	public void setMemHeight(double memHeight) {
		this.memHeight = memHeight;
	}

	public double getMemWeight() {
		return memWeight;
	}

	public void setMemWeight(double memWeight) {
		this.memWeight = memWeight;
	}

	public double getMemSmm() {
		return memSmm;
	}

	public void setMemSmm(double memSmm) {
		this.memSmm = memSmm;
	}

	public double getMemBep() {
		return memBep;
	}

	public void setMemBep(double memBep) {
		this.memBep = memBep;
	}

	@Override
	public String toString() {
		return "UserPhysicalInfo [pinfoNo=" + pinfoNo + ", userNo=" + userNo + ", memHeight=" + memHeight
				+ ", memWeight=" + memWeight + ", memSmm=" + memSmm + ", memBep=" + memBep + "]";
	}
	
	
	
}
