package com.pss.userpage.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pss.common.mybatis_template.Template;
import com.pss.userpage.model.dao.SearchUserDao;
import com.pss.userpage.model.vo.TotalRecord;

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

	public List<TotalRecord> getSearchUserTotalRecord(String nickname) {
		return null;
	}
	

}
