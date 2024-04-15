package com.pss.exercise.model.vo;

import java.util.ArrayList;

public class WorkoutRecord {
	private String exercise;
	private String bodyPart;
	private String exerciseNo;
	private ArrayList<ExerciseInfo> exInfos;
	
	public String getExerciseNo() {
		return exerciseNo;
	}
	public void setExerciseNo(String exerciseNo) {
		this.exerciseNo = exerciseNo;
	}
	
	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	public String getBodyPart() {
		return bodyPart;
	}
	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}
	public ArrayList<ExerciseInfo> getExInfos() {
		return exInfos;
	}
	public void setExInfos(ArrayList<ExerciseInfo> exInfos) {
		this.exInfos = exInfos;
	}
	
	
	
	
	
}
