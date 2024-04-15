package com.pss.diet.model.vo;

import java.sql.Date;

public class UserDietRecord {
	
	private int mrNo;
	private int userNo;
	private int foodNo;
	private int foodCount;
	private Date whenEatDate;

	public UserDietRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDietRecord(int mrNo, int userNo, int foodNo, int foodCount, Date whenEatDate) {
		super();
		this.mrNo = mrNo;
		this.userNo = userNo;
		this.foodNo = foodNo;
		this.foodCount = foodCount;
		this.whenEatDate = whenEatDate;
	}

	public int getMrNo() {
		return mrNo;
	}

	public void setMrNo(int mrNo) {
		this.mrNo = mrNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public int getFoodCount() {
		return foodCount;
	}

	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}

	public Date getWhenEatDate() {
		return whenEatDate;
	}

	public void setWhenEatDate(Date whenEatDate) {
		this.whenEatDate = whenEatDate;
	}

	@Override
	public String toString() {
		return "UserDietRecord [mrNo=" + mrNo + ", userNo=" + userNo + ", foodNo=" + foodNo + ", foodCount=" + foodCount
				+ ", whenEatDate=" + whenEatDate + "]";
	}
	
	
	
}