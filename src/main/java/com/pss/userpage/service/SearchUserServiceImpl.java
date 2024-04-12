package com.pss.userpage.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.pss.common.mybatis_template.Template;
import com.pss.userpage.model.dao.SearchUserDao;

public class SearchUserServiceImpl implements SearchUserService {

	@Override
	public ArrayList searchUser(String nickname) {
		ArrayList<Object> list = new ArrayList<>();
		SqlSession sqlSession = Template.getSqlSession();
		list = SearchUserDao.searchUser(sqlSession, nickname);
		sqlSession.close();
		return list;
	}
	
	

}
