package com.pss.userpage.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.pss.common.mybatis_template.Template;
import com.pss.userpage.model.dao.SearchUserDao;

public class SearchUserServiceImpl implements SearchUserService {

	@Override
	public HashMap getSearchUserTotalInfo(String nickname) {
		SqlSession sqlSession = Template.getSqlSession();
		HashMap SearchUserTotalInfoMap = new HashMap();
		SearchUserDao searchUserDao = new SearchUserDao();
		SearchUserTotalInfoMap.put("SearchUserInfo", searchUserDao.getSearchUserInfo(sqlSession, nickname));
		SearchUserTotalInfoMap.put("SearchUserPhysicalInfo", searchUserDao.getSearchUserPhysicalInfo(sqlSession, nickname));
		SearchUserTotalInfoMap.put("SearchUserPicture", searchUserDao.getSearchUserPicture(sqlSession, nickname));
		SearchUserTotalInfoMap.put("SearchUserdietRecord", searchUserDao.getSearchUserdietRecord(sqlSession, nickname));
		SearchUserTotalInfoMap.put("SearchUserExerciseRecord", searchUserDao.getSearchUserExerciseRecord(sqlSession, nickname));
		
		
		sqlSession.close();
		return SearchUserTotalInfoMap;
	}
	

}
