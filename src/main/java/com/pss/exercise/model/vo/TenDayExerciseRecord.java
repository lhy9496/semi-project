package com.pss.exercise.model.vo;

public class TenDayExerciseRecord {
	
	private String exName;
	private String exrDate;
	public TenDayExerciseRecord(String exName, String exrDate) {
		super();
		this.exName = exName;
		this.exrDate = exrDate;
	}
	public TenDayExerciseRecord() {
		super();
	}
	public String getExName() {
		return exName;
	}
	public void setExName(String exName) {
		this.exName = exName;
	}
	public String getExrDate() {
		return exrDate;
	}
	public void setExrDate(String exrDate) {
		this.exrDate = exrDate;
	}

	
	
}
