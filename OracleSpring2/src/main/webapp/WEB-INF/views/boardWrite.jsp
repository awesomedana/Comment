<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글폼</title>
</head>
<body>

    <c:if test="${board==null}">
	<form action="insertBoard" method="post">
    </c:if>
	<c:if test="${board!=null}">
	<form action="updateContent" method="post">
	<input type="hidden" name="boardSeq" value="${board.boardSeq}">
    </c:if>	
	<table>
	<tr><td>제목 : </td><td><input type="text" name="boardTitle" value="${board.boardTitle}"></td></tr>
	<tr><td>내용 : </td><td><textarea name="boardContent" rows="10" cols="23">${board.boardContent}</textarea></td></tr>
	</table>
	<input type="submit" value="작성하기">
	</form>


</body>
</html>