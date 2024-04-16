package com.pss.diet.model.vo;

public class Food {
	
	private int foodNo;
	private String foodName;
	private int foodKcal;
	private int carb;
	private int protein;
	private int fat;
	
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(int foodNo, String foodName, int foodKcal, int carb, int protein, int fat) {
		super();
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.foodKcal = foodKcal;
		this.carb = carb;
		this.protein = protein;
		this.fat = fat;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodKcal() {
		return foodKcal;
	}

	public void setFoodKcal(int foodKcal) {
		this.foodKcal = foodKcal;
	}

	public int getCarb() {
		return carb;
	}

	public void setCarb(int carb) {
		this.carb = carb;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	@Override
	public String toString() {
		return "Food [foodNo=" + foodNo + ", foodName=" + foodName + ", foodKcal=" + foodKcal + ", carb=" + carb
				+ ", protein=" + protein + ", fat=" + fat + "]";
	}
	
	
	

}