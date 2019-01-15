package com.mycom.mybatis0111.dao;

import java.util.ArrayList;

import com.mycom.mybatis0111.vo.Board;
import com.mycom.mybatis0111.vo.Comments;

public interface BoardMapper {
	
	public int insertBoard(Board board);//게시글 등록
	public ArrayList<Board> boardList();//게시글 목록 가져오기
	public void increaseHit(String boardseq);//조회수 올리기
	public Board boardDetail(String boardseq);//특정 게시글 가져오기
	public void updateContent(Board board);//게시글 수정하기
	public void deleteBoard(String boardseq);//게시글 삭제하기
	
	public int insertComments(Comments comments);//댓글 입력하기
	public ArrayList<Comments> commentsList(String boardseq);//댓글 전체 보기
	public void deleteComments(Comments comments);//댓글 삭제하기
}
