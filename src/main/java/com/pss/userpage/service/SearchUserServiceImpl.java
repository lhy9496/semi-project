package com.pss.userpage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pss.common.mybatis_template.Template;
import com.pss.diet.model.dao.DietRecord;
import com.pss.exercise.model.vo.ExerciseRecord;
import com.pss.userpage.model.dao.SearchUserDao;

public class SearchUserServiceImpl implements SearchUserService {

	@Override
	public HashMap<String, Object> getSearchUserTotalInfo(String nickname) {
		SqlSession sqlSession = Template.getSqlSession();
		HashMap<String, Object> SearchUserTotalInfoMap = new HashMap<String, Object>();
		SearchUserDao searchUserDao = new SearchUserDao();
		
		SearchUserTotalInfoMap.put("searchUserInfo", searchUserDao.getSearchUserInfo(sqlSession, nickname));
		SearchUserTotalInfoMap.put("searchUserPhysicalInfo", searchUserDao.getSearchUserPhysicalInfo(sqlSession, nickname));
		SearchUserTotalInfoMap.put("searchUserPicture", searchUserDao.getSearchUserPicture(sqlSession, nickname));
		
		
		sqlSession.close();
		return SearchUserTotalInfoMap;
	}

	public ArrayList<ExerciseRecord> getSearchUserExerciseRecord(String nickname) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<ExerciseRecord> exerciseList = new ArrayList<>();
		exerciseList.addAll(new SearchUserDao().getDietList(sqlSession, nickname));
		
		sqlSession.close();
		return exerciseList;
	}

	public ArrayList<DietRecord> getSearchUserDietRecord(String nickname) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<DietRecord> dietList = new ArrayList<>();
//		dietList.addAll(new SearchUserDao().getExerciseList(sqlSession, nickname)); -------------------- 여기서부터 하자.............
		
		sqlSession.close();
		return dietList;
	}
	

}
