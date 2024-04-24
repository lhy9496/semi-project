package com.pss.diet.model.vo;

import java.sql.Date;

public class TenDayDietRecord {
	
	private int foodCount;
	private Date whenEatDate;
	private int foodKcal;
	public TenDayDietRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TenDayDietRecord(int foodCount, Date whenEatDate, int foodKcal) {
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
	public Date getWhenEatDate() {
		return whenEatDate;
	}
	public void setWhenEatDate(Date whenEatDate) {
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
