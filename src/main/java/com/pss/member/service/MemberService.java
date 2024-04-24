package com.pss.member.service;

import com.pss.member.model.vo.Member;
import com.pss.member.model.vo.UserPhysicalInfo;

public interface MemberService {
	public int insertMember(Member m);
	
	public Member loginMember(Member m);
	
	public int idCheck(String checkId);
	
	public Member findId(Member m);
	
	public Member findPwd(Member m);
	
	public int nicknameCheck(String checkNickname);
	
	public int updatePhysicalInfo(UserPhysicalInfo userPInfo);
}
