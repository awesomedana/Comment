package com.app.oraclespring.DAO;

import java.util.ArrayList;

import com.app.oraclespring.VO.Board;
import com.app.oraclespring.VO.Comment;

public interface BoardMapper {

	public int insertBoard(Board board);// 게시글 등록

	public ArrayList<Board> boardList();// 게시글 가져오기

	public Board boardDetail(String boardSeq);// 특정게시글 가져오기

	public void increaseHit(String boardSeq);// 게시글 조회수 올리기

	public void deleteBoard(String boardSeq);// 게시글 삭제

	public void updateContent(Board board);// 게시글 수정

	public void insertComment(Comment comment);// 댓글 등록

	public ArrayList<Comment> selectComment(String boardSeq);// 댓글 가져오기
}




