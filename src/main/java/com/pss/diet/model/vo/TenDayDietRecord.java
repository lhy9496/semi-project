package com.pss.diet.model.vo;

import java.sql.Date;

public class TenDayDietRecord {
	
	private int foodCount;
	private String whenEatDate;
	private int foodKcal;
	public TenDayDietRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TenDayDietRecord(int foodCount, String whenEatDate, int foodKcal) {
		super();
		this.foodCount = foodCount;
		this.whenEatDate = whenEatDate;
		this.foodKcal = foodKcal;
	}
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	public String getWhenEatDate() {
		return whenEatDate;
	}
	public void setWhenEatDate(String whenEatDate) {
		this.whenEatDate = whenEatDate;
	}
	public int getFoodKcal() {
		return foodKcal;
	}
	public void setFoodKcal(int foodKcal) {
		this.foodKcal = foodKcal;
	}
	@Override
	public String toString() {
		return "TenDayDietRecord [foodCount=" + foodCount + ", whenEatDate=" + whenEatDate + ", foodKcal=" + foodKcal
				+ "]";
	}
	
	
}
