package com.mycom.mybatis0111.vo;

public class Comments {
	private String commentseq;
	private int boardseq;
	private String id;
	private String contents;
	private String indate;
	
	
	public Comments() {
		super();
	}
	public Comments(String commentseq, int boardseq, String id, String contents, String indate) {
		super();
		this.commentseq = commentseq;
		this.boardseq = boardseq;
		this.id = id;
		this.contents = contents;
		this.indate = indate;
	}
	
	public String getCommentseq() {
		return commentseq;
	}
	public void setCommentseq(String commentseq) {
		this.commentseq = commentseq;
	}
	public int getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	@Override
	public String toString() {
		return "Comments [commentseq=" + commentseq + ", boardseq=" + boardseq + ", id=" + id + ", contents=" + contents
				+ ", indate=" + indate + "]";
	}
}