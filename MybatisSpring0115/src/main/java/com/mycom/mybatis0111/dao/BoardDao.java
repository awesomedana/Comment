package com.mycom.mybatis0111.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.mybatis0111.vo.Board;
import com.mycom.mybatis0111.vo.Comments;

@Repository//@Autowired를 통해 주입받아야 하기 때문에 레퍼지토리에 등록해둔다.
public class BoardDao {
	@Autowired
	SqlSession session;
	
	//게시물등록
	public int insertBoard(Board board) {
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			return 0;//e.printstack()을 적으면 관리용 log에 오류처리가 다 된 오류까지 나타난다.
		}
		
		return result;
	}
	
	//게시물 출력
	public ArrayList<Board> boardList(){
		ArrayList<Board> result = null;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			result = mapper.boardList();
		} catch (Exception e) {
			return result;
		}
		return result;
	}
	
	//조회수 증가시키기
	public void increaseHit(String boardseq) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			mapper.increaseHit(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//특정 게시글의 정보를 가져오는 메서드
	public Board boardDetail(String boardseq) {
		Board result = null;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			result = mapper.boardDetail(boardseq);
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	
	//게시글 수정하기
	public void updateContent(Board board) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			mapper.updateContent(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 삭제하기
	public void deleteBoard(String boardseq) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			mapper.deleteBoard(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insertComments(Comments comments) {
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			result = mapper.insertComments(comments);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}

		return result;
	}
	
	//댓글 전체 보이기
	public ArrayList<Comments> commentsList(String boardseq){
		ArrayList<Comments> cList = null;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			cList = mapper.commentsList(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return cList;
	}
	
	//댓글 삭제하기
	public void deleteComments(Comments comments) {
		BoardMapper mapper= session.getMapper(BoardMapper.class);
		try {
			mapper.deleteComments(comments);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
