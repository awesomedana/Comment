<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<h1>로그인</h1>
<form action="loginMember" method="post">
ID:<input type="text" name="id" value="${member.id}"><font color="red">${warning}</font><br>
PW:<input type="password" name="pw" value="${member.pw}"><br>
<input type="submit" value="login">
</form>


</body>
</html>





