package com.pss.member.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.pss.common.mybatis_template.Template;
import com.pss.member.model.dao.MemberDao;
import com.pss.member.model.vo.Member;
import com.pss.member.model.vo.UserPhysicalInfo;

public class MemberServiceImpl implements MemberService{

	private MemberDao mDao = new MemberDao();
	
	@Override
	public int insertMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDao.insertMember(sqlSession, m);
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginUser = mDao.loginMember(sqlSession, m);
		
		sqlSession.close();
		
		return loginUser;
	}
	
	@Override
	public int idCheck(String checkId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDao.idCheck(sqlSession, checkId);
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public int nicknameCheck(String checkNickname) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDao.nicknameCheck(sqlSession, checkNickname);
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public Member findId(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Member findId = mDao.findId(sqlSession, m);
		
		sqlSession.close();
		
		return findId;
	}
	@Override
	public Member findPwd(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Member findPwd = mDao.findPwd(sqlSession, m);
		
		sqlSession.close();
		
		return findPwd;
	}
	
	@Override
	public int updatePhysicalInfo(UserPhysicalInfo userPInfo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDao.updatePhysicalInfo(sqlSession, userPInfo);
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public int pwdCheck(Member former) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDao.pwdCheck(sqlSession, former);
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public int updateMember(Member update) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDao.updateMember(sqlSession, update);
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
}
