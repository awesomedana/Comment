package com.app.oraclespring.DAO;

import java.util.ArrayList;

import com.app.oraclespring.VO.Board;
import com.app.oraclespring.VO.Comment;

public interface BoardMapper {

	public int insertBoard(Board board);// �Խñ� ���

	public ArrayList<Board> boardList();// �Խñ� ��������

	public Board boardDetail(String boardSeq);// Ư���Խñ� ��������

	public void increaseHit(String boardSeq);// �Խñ� ��ȸ�� �ø���

	public void deleteBoard(String boardSeq);// �Խñ� ����

	public void updateContent(Board board);// �Խñ� ����

	public void insertComment(Comment comment);// ��� ���

	public ArrayList<Comment> selectComment(String boardSeq);// ��� ��������
}




