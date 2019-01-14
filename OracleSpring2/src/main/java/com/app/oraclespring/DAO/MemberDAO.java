package com.app.oraclespring.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.oraclespring.VO.Member;

@Repository
public class MemberDAO {

	@Autowired
	SqlSession sqlSession;

	// 회원가입
	public int insertMember(Member member) {
		int result = 0; // 0일경우 등록실패, 1일경우 등록성공
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			result = mapper.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return result;
	}

	// 회원 로그인
	public Member loginMember(Member member) {
		Member result = null;

		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

		try {
			result = mapper.loginMember(member);
		} catch (Exception e) {
			return result;
		}
		return result;
	}
}
