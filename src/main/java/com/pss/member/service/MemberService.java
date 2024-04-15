package com.pss.member.service;

import com.pss.member.model.vo.Member;

public interface MemberService {
	public int insertMember(Member m);
	
	public Member loginMember(Member m);
	
	public int idCheck(String checkId);
}
