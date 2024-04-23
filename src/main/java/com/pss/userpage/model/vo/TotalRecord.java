package com.pss.userpage.model.vo;

import java.util.ArrayList;

public class TotalRecord {
	private int totalKcal;
	private ArrayList totalExerciseList;
	
	public TotalRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TotalRecord(int totalKcal, ArrayList totalExerciseList) {
		super();
		this.totalKcal = totalKcal;
		this.totalExerciseList = totalExerciseList;
	}

	public int getTotalKcal() {
		return totalKcal;
	}

	public void setTotalKcal(int totalKcal) {
		this.totalKcal = totalKcal;
	}

	public ArrayList getTotalExerciseList() {
		return totalExerciseList;
	}

	public void setTotalExerciseList(ArrayList totalExerciseList) {
		this.totalExerciseList = totalExerciseList;
	}

	@Override
	public String toString() {
		return "TotalRecord [totalKcal=" + totalKcal + ", totalExerciseList=" + totalExerciseList + "]";
	}
	
	
}
