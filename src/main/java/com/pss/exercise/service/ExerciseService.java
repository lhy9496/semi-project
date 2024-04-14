package com.pss.exercise.service;

import java.util.ArrayList;

import com.pss.exercise.model.vo.Exercise;

public interface ExerciseService {
	ArrayList<Exercise> selectExerciseList();

	int insertWorkoutRecord(String exName, String bodyPart, int exSet, int exWeight, int exCount);
}
