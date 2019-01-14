<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<!-- 회원로그인을 한경우 -->
	<c:if test="${sessionScope.loginId!=null}">
	<h2>${sessionScope.loginId}님, 환영합니다.</h2>
	<form action="logout">
		<input type="submit" value="LOGOUT">
	</form>
	</c:if>
	
	<!-- 새로 들어온 경우 -->	
	<c:if test="${sessionScope.loginId==null}">
	<!-- 회원가입폼 이동액션 -->
	<form action="signUp">
		<input type="submit" value="SIGNUP">
	</form>
	<!-- 로그인폼 이동액션 -->
	<form action="login">
		<input type="submit" value="LOGIN">
	</form>
	
	</c:if>
	
	<!-- 게시판 이동액션 -->
	<form action="board">
		<input type="submit" value="BOARD">
	</form>
	
</body>
</html>



