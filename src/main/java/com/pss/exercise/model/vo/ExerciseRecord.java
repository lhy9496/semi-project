package com.pss.exercise.model.vo;

import java.sql.Date;

public class ExerciseRecord {
	
	private int exRecordNo;
	private String exRecordUser;
	private String exName;
	private Date exRecordDate;
	private int exRecordSet;
	private int exRecordWeight;
	private int exRecordCount;
	
	public ExerciseRecord() {
		super();
	}

	public ExerciseRecord(int exRecordNo, String exRecordUser, String exName, Date exRecordDate, int exRecordSet,
			int exRecordWeight, int exRecordCount) {
		super();
		this.exRecordNo = exRecordNo;
		this.exRecordUser = exRecordUser;
		this.exName = exName;
		this.exRecordDate = exRecordDate;
		this.exRecordSet = exRecordSet;
		this.exRecordWeight = exRecordWeight;
		this.exRecordCount = exRecordCount;
	}


	public ExerciseRecord(String exName, int exRecordSet, int exRecordWeight, int exRecordCount) {
		super();
		this.exName = exName;
		this.exRecordSet = exRecordSet;
		this.exRecordWeight = exRecordWeight;
		this.exRecordCount = exRecordCount;
	}

	public int getExRecordNo() {
		return exRecordNo;
	}

	public void setExRecordNo(int exRecordNo) {
		this.exRecordNo = exRecordNo;
	}

	public String getExRecordUser() {
		return exRecordUser;
	}

	public void setExRecordUser(String exRecordUser) {
		this.exRecordUser = exRecordUser;
	}

	public String getExName() {
		return exName;
	}

	public void setExName(String exName) {
		this.exName = exName;
	}

	public Date getExRecordDate() {
		return exRecordDate;
	}

	public void setExRecordDate(Date exRecordDate) {
		this.exRecordDate = exRecordDate;
	}

	public int getExRecordSet() {
		return exRecordSet;
	}

	public void setExRecordSet(int exRecordSet) {
		this.exRecordSet = exRecordSet;
	}

	public int getExRecordWeight() {
		return exRecordWeight;
	}

	public void setExRecordWeight(int exRecordWeight) {
		this.exRecordWeight = exRecordWeight;
	}

	public int getExRecordCount() {
		return exRecordCount;
	}

	public void setExRecordCount(int exRecordCount) {
		this.exRecordCount = exRecordCount;
	}

	@Override
	public String toString() {
		return "ExerciseRecord [exRecordNo=" + exRecordNo + ", exRecordUser=" + exRecordUser + ", exName=" + exName
				+ ", exRecordDate=" + exRecordDate + ", exRecordSet=" + exRecordSet + ", exRecordWeight="
				+ exRecordWeight + ", exRecordCount=" + exRecordCount + "]";
	}
	
	
	
}
