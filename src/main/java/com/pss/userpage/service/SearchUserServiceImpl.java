package com.pss.userpage.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.pss.common.mybatis_template.Template;
import com.pss.diet.model.vo.TenDayDietRecord;
import com.pss.exercise.model.vo.TenDayExerciseRecord;
import com.pss.member.model.vo.Member;
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
		
		Member mem = (Member)(searchUserDao.getSearchUserInfo(sqlSession, nickname));
		String tier = "Bronze";
		int point = mem.getUserPoint();
		if (point < 100) {
			tier = "Bronze";
		} else if (point < 200) {
			tier = "Silver";
		} else if (point < 300) {
			tier = "Gold";
		} else if (point < 400) {
			tier = "Platinum";
		} else if (point < 500) {
			tier = "Diamond";
		} else if (point < 1000) {
			tier = "Master";
		} else if (point < 5000) {
			tier = "God";
		}
		
		SearchUserTotalInfoMap.put("searchUserTier", tier);
		
		
		sqlSession.close();
		return SearchUserTotalInfoMap;
	}

	public ArrayList<TenDayExerciseRecord> getSearchUserExerciseRecord(String nickname) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<TenDayExerciseRecord> exerciseList = new ArrayList<>();
		exerciseList.addAll(new SearchUserDao().getExerciseList(sqlSession, nickname));
		
		sqlSession.close();
		return exerciseList;
	}

	public ArrayList<TenDayDietRecord> getSearchUserDietRecord(String nickname) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<TenDayDietRecord> dietList = new ArrayList<>();
		dietList.addAll(new SearchUserDao().getDietList(sqlSession, nickname));
		
		sqlSession.close();
		return dietList;
	}
	

}
