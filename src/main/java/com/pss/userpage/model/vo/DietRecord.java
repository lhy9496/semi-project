package com.pss.userpage.model.vo;

import java.sql.Date;

public class DietRecord {
	private int foodCount;
	private Date whenEatDate;
	private int foodKcal;
	
	public DietRecord() {
		super();
		// 10일치 식단기록을 가져오기 위해 사용하는 객체
	}

	public DietRecord(int foodCount, Date whenEatDate, int foodKcal) {
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
		return "DietRecord [foodCount=" + foodCount + ", whenEatDate=" + whenEatDate + ", foodKcal=" + foodKcal + "]";
	}
	
	
}
