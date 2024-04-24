package com.pss.exercise.model.vo;

public class TenDayExerciseRecord {
	
	private String exName;

	public TenDayExerciseRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TenDayExerciseRecord(String exName) {
		super();
		this.exName = exName;
	}

	public String getExName() {
		return exName;
	}

	public void setExName(String exName) {
		this.exName = exName;
	}

	@Override
	public String toString() {
		return "TenDayExerciseRecord [exName=" + exName + "]";
	}
	
	
}
