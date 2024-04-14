package com.pss.exercise.service;

import java.util.ArrayList;

import com.pss.exercise.model.vo.Exercise;
import com.pss.exercise.model.vo.ExerciseRecord;

public interface ExerciseService {
	ArrayList<Exercise> selectExerciseList();

	int insertWorkoutRecord(String exName, ExerciseRecord exRecord);
}
