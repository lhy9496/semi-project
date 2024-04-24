package com.pss.userpage.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.pss.diet.model.vo.TenDayDietRecord;
import com.pss.diet.model.vo.UserDietRecord;
import com.pss.exercise.model.vo.ExerciseRecord;
import com.pss.exercise.model.vo.TenDayExerciseRecord;

public interface SearchUserService {
	
	public abstract HashMap<String, Object> getSearchUserTotalInfo(String nickname);
	public abstract ArrayList<TenDayExerciseRecord> getSearchUserExerciseRecord(String nickname);
	public abstract ArrayList<TenDayDietRecord> getSearchUserDietRecord(String nickname);

}
