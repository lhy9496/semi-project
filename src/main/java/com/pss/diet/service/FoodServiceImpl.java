package com.pss.diet.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.pss.common.mybatis_template.Template;
import com.pss.diet.model.dao.FoodDao;
import com.pss.diet.model.vo.Food;
import com.pss.diet.model.vo.MealRecord;

public class FoodServiceImpl implements FoodService{

	private FoodDao foodDao = new FoodDao();
	
	@Override
	public ArrayList<Food> selectFoodList() {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Food> list = foodDao.selectFoodList(sqlSession);
		sqlSession.close();
		return list;
	}

	
	@Override
	public int insertMealRecord(HashMap<String, Integer> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = foodDao.insertMealRecord(sqlSession, map);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}


	@Override
	public ArrayList<MealRecord> selectMealRecord(int userNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<MealRecord> list = foodDao.selectMealRecord(sqlSession,userNo);
		
		sqlSession.close();
		return list;
	}


	@Override
	public ArrayList<MealRecord> selectClickedDateMealList(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<MealRecord> list = foodDao.selectClickedDateMealList(sqlSession, map);
		
		sqlSession.close();
		return list;
	}

}
