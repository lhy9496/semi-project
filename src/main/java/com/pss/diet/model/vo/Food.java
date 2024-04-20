package com.pss.diet.model.vo;

public class Food {
	
	private int foodNo;
	private String foodName;
	private int foodKcal;
	private int foodCarb;
	private int foodProtein;
	private int foodFat;
	
	public Food() {
		super();
	}
	
	public Food(int foodNo, String foodName, int foodKcal, int foodCarb, int foodProtein, int foodFat) {
		super();
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.foodKcal = foodKcal;
		this.foodCarb = foodCarb;
		this.foodProtein = foodProtein;
		this.foodFat = foodFat;
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
	public int getFoodCarb() {
		return foodCarb;
	}
	public void setFoodCarb(int foodCarb) {
		this.foodCarb = foodCarb;
	}
	public int getFoodProtein() {
		return foodProtein;
	}
	public void setFoodProtein(int foodProtein) {
		this.foodProtein = foodProtein;
	}
	public int getFoodFat() {
		return foodFat;
	}
	public void setFoodFat(int foodFat) {
		this.foodFat = foodFat;
	}

	@Override
	public String toString() {
		return "Food [foodNo=" + foodNo + ", foodName=" + foodName + ", foodKcal=" + foodKcal + ", foodCarb=" + foodCarb
				+ ", foodProtein=" + foodProtein + ", foodFat=" + foodFat + "]";
	}
	
	
	
	
}
