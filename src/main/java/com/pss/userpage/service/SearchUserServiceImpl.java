package com.pss.userpage.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.pss.common.mybatis_template.Template;
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
		SearchUserTotalInfoMap.put("searchUserdietRecord", searchUserDao.getSearchUserdietRecord(sqlSession, nickname));
		SearchUserTotalInfoMap.put("searchUserExerciseRecord", searchUserDao.getSearchUserExerciseRecord(sqlSession, nickname));
		
		
		sqlSession.close();
		return SearchUserTotalInfoMap;
	}
	

}
