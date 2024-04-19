package com.pss.member.model.dao;



import org.apache.ibatis.session.SqlSession;

import com.pss.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		int result = sqlSession.insert("memberMapper.insertMember", m);
		
		return result;
	}
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
	public int idCheck(SqlSession sqlSession, String checkId) {
		
		int result = sqlSession.selectOne("memberMapper.idCheck", checkId);
		
		return result;
	}
	
	public int nicknameCheck(SqlSession sqlSession, String checkNickname) {
		
		int result = sqlSession.selectOne("memberMapper.nicknameCheck", checkNickname);
		
		return result;
	}
	
	public Member findId(SqlSession sqlSession, Member m) {
		
		return sqlSession.selectOne("memberMapper.findId", m);
	}

	public Member findPwd(SqlSession sqlSession, Member m) {
	
		return sqlSession.selectOne("memberMapper.findPwd", m);
	}
}
