package com.pss.userpage.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.pss.diet.model.dao.DietRecord;
import com.pss.exercise.model.vo.ExerciseRecord;

public interface SearchUserService {
	
	public abstract HashMap<String, Object> getSearchUserTotalInfo(String nickname);
	public abstract ArrayList<ExerciseRecord> getSearchUserExerciseRecord(String nickname);
	public abstract ArrayList<DietRecord> getSearchUserDietRecord(String nickname);

}
