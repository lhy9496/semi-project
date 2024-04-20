package com.pss.diet.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.pss.diet.model.vo.Food;

public class FoodDao {

	public ArrayList<Food> selectFoodList(SqlSession sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("dietMapper.selectFoodList");
	}

}
