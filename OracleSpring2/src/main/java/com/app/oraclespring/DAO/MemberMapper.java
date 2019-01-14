package com.app.oraclespring.DAO;

import com.app.oraclespring.VO.Member;

public interface MemberMapper {

	public int insertMember(Member mem);// 회원가입

	public Member loginMember(Member mem);// 회원로그인
}
