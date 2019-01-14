package com.app.oraclespring.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.oraclespring.VO.Board;
import com.app.oraclespring.VO.Comment;

@Repository
public class BoardDAO {

	@Autowired
	SqlSession session;

	public int insertBoard(Board board) {
		int result = 0;

		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			return result;
		}

		return result;
	}

	public ArrayList<Board> boardList() {
		ArrayList<Board> result = null;

		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			result = mapper.boardList();
		} catch (Exception e) {
			return result;
		}

		return result;
	}

	// 특정게시글의 정보를 가져오는 메서드
	public Board boardDetail(String boardSeq) {
		Board result = null;

		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			result = mapper.boardDetail(boardSeq);
		} catch (Exception e) {
			return result;
		}
		return result;
	}

	public void increaseHit(String boardSeq) {

		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			mapper.increaseHit(boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteBoard(String boardSeq) {

		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			mapper.deleteBoard(boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateContent(Board board) {

		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			mapper.updateContent(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertComment(Comment comment) {

		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			mapper.insertComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Comment> selectComment(String boardSeq) {
		ArrayList<Comment> result = null;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			result = mapper.selectComment(boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

}
