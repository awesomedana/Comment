package com.app.oraclespring.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.oraclespring.VO.Member;

@Repository
public class MemberDAO {

	@Autowired
	SqlSession sqlSession;

	// ȸ������
	public int insertMember(Member member) {
		int result = 0; // 0�ϰ�� ��Ͻ���, 1�ϰ�� ��ϼ���
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			result = mapper.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return result;
	}

	// ȸ�� �α���
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
