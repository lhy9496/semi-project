package com.pss.exercise.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.pss.exercise.model.vo.Exercise;
import com.pss.exercise.model.vo.ExerciseRecord;

public interface ExerciseService {

	int insertExerciseRecord(HashMap<String, Integer> map);
	
	ArrayList<ExerciseRecord> selectExerciseRecordList(int userNo);


	ArrayList<Exercise> selectExerciseList();


	ArrayList<ExerciseRecord> selectClickedDateWorkoutList(HashMap<String, String> map);

	
}
