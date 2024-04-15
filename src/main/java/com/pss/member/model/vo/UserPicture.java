package com.pss.member.model.vo;

public class UserPicture {
	private int picNo;
	private int userNo;
	private String originName;
	private String changeName;
	private String filePath;
	
	public UserPicture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPicture(int picNo, int userNo, String originName, String changeName, String filePath) {
		super();
		this.picNo = picNo;
		this.userNo = userNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
	}

	public int getPicNo() {
		return picNo;
	}

	public void setPicNo(int picNo) {
		this.picNo = picNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "UserPicture [picNo=" + picNo + ", userNo=" + userNo + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + "]";
	}
	
	
	

}