package com.pss.exercise.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.pss.exercise.model.vo.Exercise;
import com.pss.exercise.model.vo.ExerciseRecord;

public interface ExerciseService {
	ArrayList<Exercise> selectExerciseList();

	int insertExerciseRecord(HashMap<String, Integer> map);
	
	 ArrayList<ExerciseRecord> selectExerciseRecordList();
}
