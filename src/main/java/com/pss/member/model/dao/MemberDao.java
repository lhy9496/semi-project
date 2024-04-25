package com.pss.member.model.dao;



import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.pss.member.model.vo.Member;
import com.pss.member.model.vo.UserPhysicalInfo;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		int result1 = sqlSession.insert("memberMapper.insertMember", m);
		int result2 = 0;
		
		if (result1 > 0) {
			result2 = sqlSession.insert("memberMapper.insertMemberInfo", m);
		}
		return result2;
	}
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
	public int idCheck(SqlSession sqlSession, String checkId) {
		
		return sqlSession.selectOne("memberMapper.idCheck", checkId);
	}
	
	public int nicknameCheck(SqlSession sqlSession, String checkNickname) {
		
		return sqlSession.selectOne("memberMapper.nicknameCheck", checkNickname);
	}
	
	public Member findId(SqlSession sqlSession, Member m) {
		
		return sqlSession.selectOne("memberMapper.findId", m);
	}

	public Member findPwd(SqlSession sqlSession, Member m) {
	
		return sqlSession.selectOne("memberMapper.findPwd", m);
	}
	
	public int updatePhysicalInfo(SqlSession sqlSession, UserPhysicalInfo userPInfo) {
		
		return sqlSession.update("memberMapper.updatePhysicalInfo", userPInfo);
	}
	
	public int pwdCheck(SqlSession sqlSession, Member former) {
		
		return sqlSession.selectOne("memberMapper.pwdCheck", former);
	}
	
	public int updateMember(SqlSession sqlSession, Member update) {
		
		return sqlSession.update("memberMapper.updateMember", update);
	}
}
