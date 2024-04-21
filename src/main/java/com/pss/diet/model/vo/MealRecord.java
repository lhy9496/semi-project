package com.pss.diet.model.vo;

import java.sql.Date;

public class MealRecord {
	
	private int mealRecordNo;
	private int userNo;
	private int foodNo;
	private String foodName;
	private int amount;
	private int foodKcal;
	public int getFoodKcal() {
		return foodKcal;
	}

	public void setFoodKcal(int foodKcal) {
		this.foodKcal = foodKcal;
	}

	private int mealTimingNo;
	private String mealTimingName;
	private Date whenEatDate;
	

	
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getMealTimingName() {
		return mealTimingName;
	}

	public void setMealTimingName(String mealTimingName) {
		this.mealTimingName = mealTimingName;
	}

	public MealRecord() {
		super();
	}

	public MealRecord(int mealRecordNo, int userNo, int foodNo, int amount, int mealTimingNo, Date whenEatDate) {
		super();
		this.mealRecordNo = mealRecordNo;
		this.userNo = userNo;
		this.foodNo = foodNo;
		this.amount = amount;
		this.mealTimingNo = mealTimingNo;
		this.whenEatDate = whenEatDate;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setMealRecordNo(int mealRecordNo) {
		this.mealRecordNo = mealRecordNo;
	}



	public int getUserNo() {
		return userNo;
	}



	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}



	public Date getWhenEatDate() {
		return whenEatDate;
	}

	public void setWhenEatDate(Date whenEatDate) {
		this.whenEatDate = whenEatDate;
	}

	public int getMealTimingNo() {
		return mealTimingNo;
	}


	public void setMealTimingNo(int mealTimingNo) {
		this.mealTimingNo = mealTimingNo;
	}


	public int getMealRecordNo() {
		return mealRecordNo;
	}

	@Override
	public String toString() {
		return "MealRecord [mealRecordNo=" + mealRecordNo + ", userNo=" + userNo + ", foodNo=" + foodNo + ", foodName="
				+ foodName + ", amount=" + amount + ", foodKcal=" + foodKcal + ", mealTimingNo=" + mealTimingNo
				+ ", mealTimingName=" + mealTimingName + ", whenEatDate=" + whenEatDate + "]";
	}

	

	
}
