package com.pss.diet.model.vo;

public class MealRecord {
	
	private int foodNo;
	private int amount;
	private String mealTiming;
	
	public MealRecord() {
		super();
	}

	public MealRecord(int foodNo, int amount, String mealTiming) {
		super();
		this.foodNo = foodNo;
		this.amount = amount;
		this.mealTiming = mealTiming;
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

	public String getMealTiming() {
		return mealTiming;
	}

	public void setMealTiming(String mealTiming) {
		this.mealTiming = mealTiming;
	}

	@Override
	public String toString() {
		return "MealRecord [foodNo=" + foodNo + ", amount=" + amount + ", mealTiming=" + mealTiming + "]";
	}
	
	
	
	
}
