package com.app.oraclespring.DAO;

import com.app.oraclespring.VO.Member;

public interface MemberMapper {

	public int insertMember(Member mem);// ȸ������

	public Member loginMember(Member mem);// ȸ���α���
}
