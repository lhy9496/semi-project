package com.pss.member.model.vo;

import java.sql.Date;

public class UserInfo {
	private int userNo;
	private String userName;
	private String userNickname;
	private String userEmail;
	private String userPwd;
	private String gender;
	private int age;
	private int userPoint;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
	public UserInfo() {
		super();
	}

	public UserInfo(int userNo, String userName, String userNickname, String userEmail, String userPwd, String gender,
			int age, int userPoint, Date enrollDate, Date modifyDate, String status) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.gender = gender;
		this.age = age;
		this.userPoint = userPoint;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserInfo [userNo=" + userNo + ", userName=" + userName + ", userNickname=" + userNickname
				+ ", userEmail=" + userEmail + ", userPwd=" + userPwd + ", gender=" + gender + ", age=" + age
				+ ", userPoint=" + userPoint + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status="
				+ status + "]";
	}
	
	
	
	
	
}
