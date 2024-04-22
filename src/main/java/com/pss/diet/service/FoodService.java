package com.pss.diet.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.pss.diet.model.vo.Food;
import com.pss.diet.model.vo.MealRecord;

public interface FoodService {
	
	// 음식 리스트 가져오기 
	ArrayList<Food> selectFoodList();
	
	// 식사기록 입력 
	int insertMealRecord(HashMap<String, Integer> map);
	
	// 식사기록 가져오기

	ArrayList<MealRecord> selectMealRecord(int userNo);
	
	
}
