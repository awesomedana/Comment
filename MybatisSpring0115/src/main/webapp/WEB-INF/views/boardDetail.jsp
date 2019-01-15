<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- jstl 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
</head>
<body>
	<c:if test="${sessionScope.loginId == board.id}">
		<div style="display: inline-flex;">
		<form action="updateBoard" method="post">
			<input type="hidden" name="boardseq" value="${board.boardseq}">
			<input type="submit" value="수정">
		</form>
		<form action="deleteBoard" method="post">
			<input type="hidden" name="boardseq" value="${board.boardseq}">
			<input type="submit" value="삭제">
		</form>
		</div>
	</c:if>
	<hr>
	
	<table>
		<tr><td>제목:</td><td>${board.boardtitle}</td></tr>
		<tr><td>게시자:</td><td>${board.id}</td></tr>
		<tr><td>조회수:</td><td>${board.hitcount}</td></tr>
		<tr><td>등록일:</td><td>${board.indate}</td></tr>
	</table>
	<hr>
	<div>${board.boardcontent}</div>
	
	<hr>
	
	<form action="boardList">
		<input type="submit" value="돌아가기">
	</form>
	<form action="goHome">
		<input type="submit" value="홈페이지로 가기">
	</form>
	<hr>
	
	<form action="insertComments" method="post">
		<label style="font-weight: bold; font-size: 20px;">${sessionScope.loginId}</label>
		<textarea name="contents" cols="50" rows="2"></textarea>
		<input type="hidden" name="boardseq" value="${board.boardseq}">
		<input type="submit" value="댓글 달기"><font style="color: red;">${warning}</font>
	</form>
	<hr>
	
	<table style="border: 1px solid black;">
		<c:forEach var="Comments" items="${cList}">
			<tr>
			<td>${Comments.id} : </td>
			<td>${Comments.contents}</td>
			<td>${Comments.indate}</td>
			<td><c:if test="${sessionScope.loginId == Comments.id}">
					<c:if test="${Comments.contents != '(삭제된 댓글입니다.)' }">
						<form action="deleteComments" method="post">
							<!-- 댓글 시퀀스와 게시글 시퀀스를 넘겨준다. -->
							<input type="hidden" value="${Comments.commentseq}" name="commentseq">
							<input type="hidden" value="${Comments.boardseq}" name="boardseq">
							<input type="submit" value="댓글 삭제"><!-- delete하지 않고 update를 사용. 대댓글을 위해 -->
						</form>
					</c:if>
				</c:if>
			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>