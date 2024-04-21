package com.pss.diet.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.pss.diet.model.vo.Food;
import com.pss.diet.model.vo.MealRecord;

public class FoodDao {

	public ArrayList<Food> selectFoodList(SqlSession sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("dietMapper.selectFoodList");
	}

	public int insertMealRecord(SqlSession sqlSession, HashMap<String,Integer> map) {
		return sqlSession.insert("dietMapper.insertMealRecord", map);
	}

	public ArrayList<MealRecord> selectMealRecord(SqlSession sqlSession) {
		return (ArrayList)sqlSession.selectList("dietMapper.selectMealRecord");
	}

}
