<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글상세보기</title>
</head>
<body>

	<c:if test="${sessionScope.loginId==board.id}">
	<div style="display:inline-flex;">
	<form action="updateBoard" method="post">
		<input type="hidden" name="boardSeq" value="${board.boardSeq}">
		<input type="submit" value="수정">
	</form>
	<form action="deleteBoard" method="post">
		<input type="hidden" name="boardSeq" value="${board.boardSeq}">
		<input type="submit" value="삭제">
	</form>
	</div>
	</c:if>

	<table>
	<tr><td>제목 : </td><td>${board.boardTitle}</td></tr>
	<tr><td>게시자 : </td><td>${board.id}</td></tr>
	<tr><td>조회수 : </td><td>${board.hitcount}</td></tr>
	<tr><td>등록일 : </td><td>${board.indate}</td></tr>
	</table>
	
	<hr>
	<div>${board.boardContent}</div>
	<hr>
	
	<form action="boardList">
	<input type="submit" value="돌아가기">
	</form>
	
	<form action="insertComment" method="post">
	<input type="hidden" name="boardSeq" value="${board.boardSeq}">
	<input type="text" name="comments">
	<input type="submit" value="댓글등록">
	</form>
	
	<table>
	<c:forEach var="comment" items="${commentList}">
	<tr>
	<td>${comment.id} : </td>
	<td>${comment.comments}</td>
	<td>${comment.indate}</td>
	</tr>
	</c:forEach>
	</table>
	
	
</body>
</html>


