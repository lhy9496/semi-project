package com.pss.userpage.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.pss.member.model.vo.Member;
import com.pss.member.model.vo.UserPhysicalInfo;
import com.pss.member.model.vo.UserPicture;

public class SearchUserDao {

	public Member getSearchUserInfo(SqlSession sqlSession, String nickname) {
		return sqlSession.selectOne("memberMapper.searchUserInfo", nickname);
	}

	public UserPhysicalInfo getSearchUserPhysicalInfo(SqlSession sqlSession, String nickname) {
		return sqlSession.selectOne("memberMapper.searchUserPhysicalInfo", nickname);
	}

	public UserPicture getSearchUserPicture(SqlSession sqlSession, String nickname) {
		return sqlSession.selectOne("memberMapper.searchUserPicture", nickname);
	}

}
