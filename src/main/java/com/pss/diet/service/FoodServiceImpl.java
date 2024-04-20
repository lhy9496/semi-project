package com.pss.diet.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.pss.common.mybatis_template.Template;
import com.pss.diet.model.dao.FoodDao;
import com.pss.diet.model.vo.Food;

public class FoodServiceImpl implements FoodService{

	private FoodDao foodDao = new FoodDao();
	
	@Override
	public ArrayList<Food> selectFoodList() {
		SqlSession sqlSession = Template.getSqlSession();

		return foodDao.selectFoodList(sqlSession);
	}

}
