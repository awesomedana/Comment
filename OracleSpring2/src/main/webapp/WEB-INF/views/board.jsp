<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>

	<form action="boardWrite">
		<input type="submit" value="게시글 쓰기">
	</form>

	<hr>

	<table>
		<tr>
			<td style="width:45%;">글제목</td>
			<td style="width:15%;">게시자</td>
			<td style="width:15%;">조회수</td>
			<td>등록일</td>
		</tr>
	
	<c:forEach var="board" items="${bList}">
	
		<tr>
			<td style="width:45%;">
			<a href="boardDetail?boardSeq=${board.boardSeq}">${board.boardTitle}</a>
			</td>
			<td style="width:15%;">${board.id}</td>
			<td style="width:15%;">${board.hitcount}</td>
			<td>${board.indate}</td>
		</tr>
		
	</c:forEach>
	


	</table>

	<hr>


</body>
</html>